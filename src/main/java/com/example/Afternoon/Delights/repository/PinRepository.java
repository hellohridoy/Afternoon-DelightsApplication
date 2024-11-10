package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PinRepository extends JpaRepository<Pin, String> {
}
