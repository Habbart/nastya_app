package com.nastya.images.dao;

import com.nastya.images.entity.TitleImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TitleImageDao extends JpaRepository<TitleImage, UUID> {

}