package com.example.ThymeleafDemo.repository;


import com.example.ThymeleafDemo.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    @Query(value = "SELECT * FROM Hocsinhs WHERE hocsinhid BETWEEN ?1 AND ?2", nativeQuery = true)
     List<Students> findByIdBetween(int beginId, int endId);
}