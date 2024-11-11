package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.entity.Pin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Pin, Long> {
}
