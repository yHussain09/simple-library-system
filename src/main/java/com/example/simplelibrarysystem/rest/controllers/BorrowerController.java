package com.example.simplelibrarysystem.rest.controllers;

import com.example.simplelibrarysystem.dto.BorrowerDto;
import com.example.simplelibrarysystem.entities.BorrowerEntity;
import com.example.simplelibrarysystem.rest.handler.RestResponseHandler;
import com.example.simplelibrarysystem.services.BorrowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/borrower")
public class BorrowerController extends RestResponseHandler {

    private final BorrowerService borrowerService;

    public BorrowerController(final BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @PostMapping
    public ResponseEntity<?> registerBorrower(@RequestBody BorrowerDto borrowerDto) {
        return successResponseDataSaving(borrowerService.registerBorrower(borrowerDto));
    }
}
