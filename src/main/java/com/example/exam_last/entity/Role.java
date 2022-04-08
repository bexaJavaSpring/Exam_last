package com.example.exam_last.entity;

import com.example.exam_last.entity.enums.PermissionEnum;
import com.example.exam_last.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<PermissionEnum> permissionEnumSet;
}
