package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.RegisterUserRequestDto;
import com.codewithmosh.store.dtos.UpdateUserRequestDto;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequestDto request);
    void update(UpdateUserRequestDto request, @MappingTarget User user);        // left - incoming data, right - existing object
}
