package com.dogbalbirdbal.domain;

import lombok.Data;

@Data
public class UserLoginDto {
    private String id;
    private String name;
    private String token;
}
