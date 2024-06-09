package com.example.simplelibrarysystem.rest.controllers;

import com.example.simplelibrarysystem.dto.BookDto;
import com.example.simplelibrarysystem.dto.BorrowDto;
import com.example.simplelibrarysystem.rest.handler.RestResponseHandler;
import com.example.simplelibrarysystem.services.BookService;
import com.example.simplelibrarysystem.services.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/book")
public class BookController extends RestResponseHandler {

    private final BookService bookService;
    private final BorrowService borrowService;

    public BookController(final BookService bookService, final BorrowService borrowService) {
        this.bookService = bookService;
        this.borrowService = borrowService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return successResponseDataRetrieve(this.bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<?> registerBook(BookDto bookDto) {
        return successResponseDataSaving(bookService.registerBook(bookDto));
    }

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowDto borrowDto) {
        return successResponseDataSaving(borrowService.borrowBook(borrowDto));
    }

    @PostMapping("/return")
    public ResponseEntity<?> reserveBook(@RequestParam Long reservationId) {
        return successResponseDataSaving(borrowService.returnBook(reservationId));
    }
}
