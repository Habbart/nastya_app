package com.nastya.images.dao;

import com.nastya.images.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Short> {

}