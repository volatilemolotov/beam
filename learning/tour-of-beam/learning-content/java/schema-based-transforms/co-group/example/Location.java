package com.example.demo;

import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;

@DefaultSchema(JavaFieldSchema.class)
public class Location {
    public Long userId;
    public String countryName;

    @SchemaCreate
    public Location(Long userId, String countryName) {
        this.userId = userId;
        this.countryName = countryName;
    }
}
