package com.nastya.images.dao;

import com.nastya.images.entity.SocialNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SocialNetworkDao extends JpaRepository<SocialNetworkEntity, UUID> {

    SocialNetworkEntity findByUrlAndDescription(String url, String description);

    void deleteByUrlAndDescription(String url, String description);

}