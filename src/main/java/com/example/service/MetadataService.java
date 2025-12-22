package com.example.service;

import com.example.entity.MetadataEntity;
import com.example.kafka.MetadataProducer;
import com.example.model.MetaData;
import com.example.repository.MetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetadataService {

    private final MetadataRepository metadataRepository;
    private final MetadataProducer metadataProducer;

    public void saveToDb(MetaData metaData){
        MetadataEntity entity = MetadataEntity.builder()
                .documentId(metaData.getDocumentId())
                .contentId(metaData.getContentId())
                .fileName(metaData.getFileName())
                .originalFileName(metaData.getOriginalFileName())
                .contentType(metaData.getContentType())
                .bucketName(metaData.getBucketName())
                .objectKey(metaData.getObjectKey())
                .uploadedBy(metaData.getUploadedBy())
                .uploadedAt(metaData.getUploadedAt())
                .status(metaData.getStatus())
                .retentionPeriodDays(metaData.getRetentionPeriodDays())
                .build();

        metadataRepository.save(entity);

        log.info("Metadata saved for documentId={}", metaData.getDocumentId());

        log.info("calling kafka to send notification for presigning");

        metadataProducer.KafkaProduce(metaData);

    }
}
