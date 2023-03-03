package com.nastya.images.dao;

import com.nastya.images.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageDao extends JpaRepository<Image, UUID> {
}
