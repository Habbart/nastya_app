package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

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