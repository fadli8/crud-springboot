package com.example.test.service;

import com.example.test.entity.DTO.NavireEntityRequest;
import com.example.test.entity.NavireEntity;

import java.util.List;

public interface NavireServiceInterface {
    List<NavireEntity> getAllNavires() throws Exception;
    public boolean deleteNavire(Long id);
    public NavireEntity updateNavire(Long id, NavireEntityRequest navireEntityRequest) throws NoSuchFieldException;
    public NavireEntity addNavire(String name, double tonnage);

}
