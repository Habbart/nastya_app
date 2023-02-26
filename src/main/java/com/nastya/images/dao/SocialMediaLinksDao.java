package com.nastya.images.dao;

import com.nastya.images.entity.SocialMediaLinks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialMediaLinksDao extends JpaRepository<SocialMediaLinks, UUID> {
}
