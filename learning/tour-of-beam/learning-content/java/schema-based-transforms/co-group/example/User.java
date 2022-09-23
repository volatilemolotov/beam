package com.example.demo;

import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;

@DefaultSchema(JavaFieldSchema.class)
public class User {
    public Long userId;
    public String userName;
    public String userSurname;


    @SchemaCreate
    public User(Long userId, String userName, String userSurname) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userId = userId;
    }
}
