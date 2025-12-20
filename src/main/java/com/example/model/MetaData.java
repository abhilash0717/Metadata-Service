package com.example.model;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {

    private String documentId;
    private String contentId;
    private String fileName;
    private String originalFileName;
    private String contentType;
    private String bucketName;
    private String objectKey;
    private String uploadedBy;
    private Instant uploadedAt;
    private String status;
    private int retentionPeriodDays;
}
