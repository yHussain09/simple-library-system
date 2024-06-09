package com.example.simplelibrarysystem.services;

import com.example.simplelibrarysystem.dto.BorrowerDto;
import com.example.simplelibrarysystem.entities.BorrowerEntity;
import com.example.simplelibrarysystem.exception.CustomInternalServerException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.example.simplelibrarysystem.repos.BorrowerRepository;

@Service
public class BorrowerService {
    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public BorrowerDto registerBorrower(BorrowerDto borrowerDto) {
        try {
            BorrowerEntity savedBorrowerEntity = borrowerRepository.save(new BorrowerEntity(borrowerDto.getName(), borrowerDto.getEmail()));
            return new BorrowerDto(savedBorrowerEntity.getId(), savedBorrowerEntity.getName(), savedBorrowerEntity.getEmail());
        } catch (DataAccessException e) {
            throw new CustomInternalServerException("Failed to register borrower", e);
        }
    }
}
