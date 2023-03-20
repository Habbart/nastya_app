package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}