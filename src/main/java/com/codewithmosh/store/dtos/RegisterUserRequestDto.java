package com.codewithmosh.store.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequestDto {
    private String name;
    private String email;
    private String password;
}
