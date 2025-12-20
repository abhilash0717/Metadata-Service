package com.example.repository;

import com.example.entity.MetadataEntity;
import com.example.model.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetadataRepository extends JpaRepository<MetadataEntity, Long> {

    Optional<MetadataEntity> findByDocumentId(String documentId);
}

