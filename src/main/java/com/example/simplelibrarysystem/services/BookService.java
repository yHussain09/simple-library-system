package com.example.simplelibrarysystem.services;

import com.example.simplelibrarysystem.dto.BookDto;
import com.example.simplelibrarysystem.entities.BookEntity;
import com.example.simplelibrarysystem.repos.BookRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto registerBook(BookDto bookDto) {
        try {
            BookEntity bookEntity;
            Optional<BookEntity> bookEntityOptional = bookRepository.findBookEntityByIsbn(bookDto.getIsbn());
            if (bookEntityOptional.isPresent()) {
                bookEntity = bookEntityOptional.get();
                if (bookEntity.getIsbn().equals(bookDto.getIsbn()) &&
                        bookEntity.getAuthor().equalsIgnoreCase(bookDto.getAuthor()) &&
                        bookEntity.getTitle().equalsIgnoreCase(bookDto.getTitle())) {
                    int availableCount = bookEntity.getCount();
                    bookEntity.setCount(availableCount + 1);
                    bookRepository.save(bookEntity);
                }
            } else {
                bookEntity = bookRepository.save(new BookEntity(bookDto.getTitle(), bookDto.getAuthor(),
                        bookDto.getIsbn(), bookDto.getCount()));
            }
            return new BookDto(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(),
                    bookEntity.getIsbn(), bookEntity.getCount());
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to register book", e);
        }
    }

    public List<BookDto> getAllBooks() {

        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList.stream()
                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getCount()))
                .collect(Collectors.toList());
    }
}
