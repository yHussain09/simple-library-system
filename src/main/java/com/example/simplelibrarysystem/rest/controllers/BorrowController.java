package com.example.simplelibrarysystem.rest.controllers;

import com.example.simplelibrarysystem.dto.BorrowDto;
import com.example.simplelibrarysystem.rest.handler.RestResponseHandler;
import com.example.simplelibrarysystem.services.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController extends RestResponseHandler {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<?> reserveBook(@RequestBody BorrowDto borrowDto) {
        return successResponseDataSaving(borrowService.borrowBook(borrowDto));
    }

    @PostMapping("return")
    public ResponseEntity<?> returnBook(@RequestParam Long borrowId) {
        return successResponseDataSaving(borrowService.returnBook(borrowId));
    }
}
