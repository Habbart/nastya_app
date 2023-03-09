package com.nastya.images.dao;

import com.nastya.images.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkDao extends JpaRepository<Work, UUID> {

    List<Work> findByWorkTopicsIn(List<String> workTopicIds);

}