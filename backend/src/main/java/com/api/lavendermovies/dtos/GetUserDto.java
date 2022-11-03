package com.api.lavendermovies.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetUserDto {
    private UUID id;
    private String username;
    private String name;
    private String email;
}
