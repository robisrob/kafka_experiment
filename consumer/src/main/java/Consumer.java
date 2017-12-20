import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Properties properties = getConsumerProps();
        Runnable consumerThread = getConsumerThread(properties);
        executorService.submit(consumerThread);

    }

    private static Properties getConsumerProps() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("auto.offset.reset", "earliest");
        properties.put("group.id", "selfWrittenConsumer");
        return properties;
    }

    private static Runnable getConsumerThread(Properties properties) {
        return () -> {
            org.apache.kafka.clients.consumer.Consumer<String, String> consumer = new KafkaConsumer<>(properties);
            try {
                consumer.subscribe(Collections.singletonList("test"));
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(5000);
                    for (ConsumerRecord<String, String> record : records) {
                        String me = String.format("Consumed: key = %s value = %s with offset = %d partition = %d", record.key(), record.value(), record.offset(), record.partition());
                        System.out.println(me);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (consumer != null) {
                    consumer.close();
                }
            }
        };
    }
}
