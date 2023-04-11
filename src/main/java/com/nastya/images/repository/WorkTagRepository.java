package com.nastya.images.repository;

import com.nastya.images.entity.WorkTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WorkTagRepository extends JpaRepository<WorkTagEntity, UUID> {

    @Query("SELECT DISTINCT w, count(w.tag) " +
            "FROM WorkTagEntity w " +
            "GROUP BY w.tag " +
            "ORDER BY count(w.tag) ASC ")
    List<WorkTagEntity> countByTagPopularity();
}
