package com.nastya.images.dao;

import com.nastya.images.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TopicDao extends JpaRepository<Topic, UUID>{

}