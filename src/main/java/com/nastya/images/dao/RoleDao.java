package com.nastya.images.dao;

import com.nastya.images.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleDao extends CrudRepository<Role, UUID> {

}