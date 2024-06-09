package com.example.simplelibrarysystem.repos;

import com.example.simplelibrarysystem.entities.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerEntity, Long> {
}
