package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Pin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Pin, Long> {
}
