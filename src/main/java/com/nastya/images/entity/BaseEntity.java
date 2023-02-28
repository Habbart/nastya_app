package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {

    @Version
    @Column(name = "VERSION")
    private Long version;
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;
    @Column(name = "LAST_UPDATE_DATE")
    private LocalDateTime lastUpdateDate;

}