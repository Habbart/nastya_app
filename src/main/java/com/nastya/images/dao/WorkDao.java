package com.nastya.images.dao;

import com.nastya.images.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkDao extends JpaRepository<WorkEntity, UUID> {

    List<WorkEntity> findByWorkTopicsIn(List<String> workTopicIds);

}