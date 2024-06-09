package com.example.simplelibrarysystem.repos;

import com.example.simplelibrarysystem.entities.BorrowEntity;
import com.example.simplelibrarysystem.entities.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowEntity, Long> {
}
