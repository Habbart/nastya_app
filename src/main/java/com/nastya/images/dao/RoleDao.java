package com.nastya.images.dao;

import com.nastya.images.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RoleDao extends JpaRepository<RoleEntity, UUID> {

}