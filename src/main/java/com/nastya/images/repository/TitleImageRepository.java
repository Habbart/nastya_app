package com.nastya.images.repository;

import com.nastya.images.entity.TitleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TitleImageRepository extends JpaRepository<TitleImageEntity, UUID> {

}