package com.example.kafka;

import com.example.model.MetaData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MetadataConsumer {

    @KafkaListener(
            topics = "document-metadata",
            groupId = "metadata-consumer-group"
    )
    public void consume(MetaData metaData) {
        System.out.println("Consumed message: " + metaData);

        // TODO: save to DB, send to S3, trigger workflow, etc.
    }
}

