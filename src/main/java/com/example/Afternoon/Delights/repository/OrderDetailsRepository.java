package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.OrderDetail;
import com.example.Afternoon.Delights.entity.Pin;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail,Long> {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id") // Foreign key in `pins` table
    List<Pin> pins = new ArrayList<>();

}
