package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @CreationTimestamp
    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private LocalDateTime lastUpdateDate;
}