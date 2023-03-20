package com.nastya.images.dao;

import com.nastya.images.entity.TitleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TitleImageDao extends JpaRepository<TitleImageEntity, UUID> {

}