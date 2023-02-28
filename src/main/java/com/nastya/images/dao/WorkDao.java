package com.nastya.images.dao;

import com.nastya.images.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface WorkDao extends JpaRepository<Work, UUID> {

}