import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

public class KafkaStream {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "yelling_app_id");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        StreamsConfig streamingConfig = new StreamsConfig(props);
        KStreamBuilder kStreamBuilder = new KStreamBuilder();
        kStreamBuilder.stream(Serdes.String(), Serdes.String(), "test").mapValues(String::toUpperCase).print(Serdes.String(), Serdes.String());
        new KafkaStreams(kStreamBuilder, streamingConfig).start();
    }
}
