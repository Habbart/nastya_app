package com.nastya.images.repository;

import com.nastya.images.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<ImageEntity, UUID> {

    ImageEntity findByPath(String path);
    ImageEntity findByFrontId(String frontId);
    void deleteByFrontId(String frontId);
}
