package com.example.kafka;

import com.example.entity.MetadataEntity;
import com.example.model.MetaData;
import com.example.repository.MetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetadataConsumer {

    private final MetadataRepository metadataRepository;

    @KafkaListener(
            topics = "document-metadata",
            groupId = "metadata-consumer-group"
    )
    public void consume(MetaData metaData) {
        log.info("Received metadata event: {}", metaData);

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
    }
}

