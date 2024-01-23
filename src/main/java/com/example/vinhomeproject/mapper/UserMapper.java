package com.example.vinhomeproject.mapper;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "review", ignore = true)
    @Mapping(target = "contractHistories", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "tokens", ignore = true)
    Users createClassDtoToClassSubject(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "review", ignore = true),
            @Mapping(target = "contractHistories", ignore = true),
            @Mapping(target = "notifications", ignore = true),
            @Mapping(target = "appointments", ignore = true),
            @Mapping(target = "tokens", ignore = true),
    })
    void updateUser(UserDTO userDTO, @MappingTarget Users users);
}
