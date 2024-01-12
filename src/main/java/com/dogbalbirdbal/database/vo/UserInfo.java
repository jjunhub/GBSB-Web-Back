package com.dogbalbirdbal.database.vo;



import java.util.Objects;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UserInfo {

    private String id;
    private String password;
    private String email;
    private String name;


    public UserInfo(String id, String password, String email, String name) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(password, userInfo.password) && Objects.equals(email, userInfo.email) && Objects.equals(name, userInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, name);
    }
}
