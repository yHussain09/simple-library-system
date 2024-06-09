package com.example.simplelibrarysystem.services;

import com.example.simplelibrarysystem.dto.BorrowDto;
import com.example.simplelibrarysystem.entities.BookEntity;
import com.example.simplelibrarysystem.entities.BorrowEntity;
import com.example.simplelibrarysystem.entities.BorrowerEntity;
import com.example.simplelibrarysystem.exception.CustomBadRequestException;
import com.example.simplelibrarysystem.repos.BookRepository;
import com.example.simplelibrarysystem.repos.BorrowRepository;
import com.example.simplelibrarysystem.repos.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BorrowService {
    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;
    private final BorrowRepository borrowRepository;

    public BorrowService(BookRepository bookRepository, BorrowerRepository borrowerRepository, BorrowRepository borrowRepository) {
        this.bookRepository = bookRepository;
        this.borrowerRepository = borrowerRepository;
        this.borrowRepository = borrowRepository;
    }

    public Long borrowBook(BorrowDto BorrowDto) {
        BorrowerEntity borrowerEntity = borrowerRepository.findById(BorrowDto.getBorrowerId())
                .orElseThrow(() -> new CustomBadRequestException("Invalid borrower id."));
        BookEntity book = bookRepository.findById(BorrowDto.getBookId())
                .orElseThrow(() -> new CustomBadRequestException("Invalid book id."));

        int count = book.getCount();
        if (count <= 0) {
            throw new CustomBadRequestException("No available copies to reserve.");
        }
        book.setCount(count - 1);
        return borrowRepository.save(new BorrowEntity(borrowerEntity, book, new Date(), null, false)).getId();
    }

    public Long returnBook(Long borrowId) {
        Optional<BorrowEntity> borrowEntityOptional = borrowRepository.findById(borrowId);
        if (borrowEntityOptional.isEmpty()) {
            throw new CustomBadRequestException("Reservation not found or invalid id.");
        } else {
            BorrowEntity borrowEntity = borrowEntityOptional.get();
            if (Boolean.TRUE.equals(borrowEntity.getReturned())) {
                throw new CustomBadRequestException("Borrower already returned the book.");
            }
        }
        BorrowEntity borrowEntity = borrowEntityOptional.get();
        borrowEntity.setReturned(true);
        borrowEntity.setReturnedDate(new Date());

        BookEntity bookEntity = borrowEntity.getBook();
        bookEntity.setCount(bookEntity.getCount() + 1);
        borrowEntity = borrowRepository.save(borrowEntity);
        return borrowEntity.getId();
    }
}
