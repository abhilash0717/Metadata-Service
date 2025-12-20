package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentId;

    @Column(nullable = false)
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

