package com.example.test.repository;

import com.example.test.entity.NavireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NavireRepo extends JpaRepository<NavireEntity, Long> {

    @Query(value = "select n from NavireEntity n where n.name like %:name%")
    public NavireEntity searchByName(String name);
}
