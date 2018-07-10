package com.example.demo.repository;

import com.example.demo.model.RentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentHistoryRepository extends JpaRepository<RentHistory, Long> {
}
