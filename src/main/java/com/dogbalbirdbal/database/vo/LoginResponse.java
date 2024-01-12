package com.dogbalbirdbal.database.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private String id;
    private String name;
    private String token;

    public LoginResponse(String id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }
}
