package com.ahmedproject.orderservice.repository;

import com.ahmedproject.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
