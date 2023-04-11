package com.nastya.images.repository;

import com.nastya.images.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID>{

    TagEntity findByName(String name);

    void deleteByName(String name);

}