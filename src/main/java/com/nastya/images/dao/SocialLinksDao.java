package com.nastya.images.dao;

import com.nastya.images.entity.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SocialLinksDao extends JpaRepository<SocialNetwork, UUID> {

}