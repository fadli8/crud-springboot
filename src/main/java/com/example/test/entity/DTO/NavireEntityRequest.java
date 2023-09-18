package com.example.test.entity.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.PrimitiveIterator;
@Data @Builder
public class NavireEntityRequest {

    private String name;

    private double tonnage;

    private String status;
}
