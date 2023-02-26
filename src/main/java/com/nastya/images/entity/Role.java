package com.nastya.images.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {

    @NotBlank
    @Column(name = "role_name")
    private String name;

}
