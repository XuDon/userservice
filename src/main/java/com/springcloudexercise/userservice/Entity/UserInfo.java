package com.springcloudexercise.userservice.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserInfo {
    private String name;
    private String gender;
    private int age;
    private char married;
}
