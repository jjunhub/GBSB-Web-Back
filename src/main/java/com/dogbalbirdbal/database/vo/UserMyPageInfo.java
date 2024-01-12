package com.dogbalbirdbal.database.vo;

import lombok.Data;

@Data
public class UserMyPageInfo {
    private String id;
    private String email;
    private String name;
    private WishContainer wishContainer;
}
