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
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;
}