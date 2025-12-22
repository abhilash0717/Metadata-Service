package com.example.kafka;

import com.example.model.MetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MetadataProducer {

    private final String presign_topic = "presign-metadata";
    private final KafkaTemplate<String, MetaData> kafkaTemplate;

    public MetadataProducer(KafkaTemplate<String, MetaData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void KafkaProduce(MetaData metaData){

        log.info("sending metadata event for presigning: {}", metaData);
        kafkaTemplate.send(
                presign_topic,
                metaData.getDocumentId(),
                metaData
        );
    }
}
