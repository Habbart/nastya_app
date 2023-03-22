package com.nastya.images.dao;

import com.nastya.images.entity.WorkTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WorkTopicDao extends JpaRepository<WorkTopicEntity, UUID> {

    @Query("SELECT DISTINCT w, count(w.topic) " +
            "FROM WorkTopicEntity w " +
            "GROUP BY w.topic " +
            "ORDER BY count(w.topic) ASC ")
    List<WorkTopicEntity> countByTopicPopularity();
}
