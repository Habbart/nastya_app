package com.nastya.images.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}