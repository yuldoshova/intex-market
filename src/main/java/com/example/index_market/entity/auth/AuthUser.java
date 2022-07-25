package com.example.index_market.entity.auth;

import com.example.index_market.entity.Auditable;
import com.example.index_market.entity.address.Address;
import com.example.index_market.enums.user.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser extends Auditable {

    private String name;


    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public AuthUser(String name, String phone,Role role) {
        this.name = name;
        this.phone = phone;
        this.role = role;
    }
}
