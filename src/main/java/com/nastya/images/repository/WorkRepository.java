package com.nastya.images.repository;

import com.nastya.images.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkRepository extends JpaRepository<WorkEntity, UUID> {

    List<WorkEntity> findByWorkTagIn(List<String> workTagIds);

    void deleteByFrontId(String frontId);

    WorkEntity findByFrontId(String frontId);

}