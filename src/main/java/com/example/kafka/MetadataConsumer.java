package com.example.kafka;

import com.example.entity.MetadataEntity;
import com.example.model.MetaData;
import com.example.repository.MetadataRepository;
import com.example.service.MetadataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
public class MetadataConsumer {

    private MetadataService metadataService;

    @KafkaListener(
            topics = "document-metadata",
            groupId = "metadata-consumer-group"
    )
    public void consume(MetaData metaData) {
        log.info("Received metadata event: {}", metaData);
        log.info("Sending the data to service");

        metadataService.saveToDb(metaData);



    }
}

