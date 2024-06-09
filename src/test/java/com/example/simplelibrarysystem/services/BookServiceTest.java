package com.example.simplelibrarysystem.services;

import com.example.simplelibrarysystem.dto.BookDto;
import com.example.simplelibrarysystem.entities.BookEntity;
import com.example.simplelibrarysystem.repos.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testRegisterBook_ExistingIsbn() throws Exception {
        // Mock existing book data
        BookEntity existingBook = new BookEntity(1L, "1234567890111", "Test Title", "Test Author" , 2);
        when(bookRepository.findBookEntityByIsbn("1234567890111")).thenReturn(Optional.of(existingBook));

        // BookDTO with matching ISBN
        BookDto bookDto = new BookDto("Test Title", "Test Author", "1234567890111", 1);

        // Call the method and verify results
        BookDto registeredBook = bookService.registerBook(bookDto);
        assertThat(registeredBook.getId()).isEqualTo(existingBook.getId());
        assertThat(registeredBook.getCount()).isEqualTo(3);

        // Verify repository calls
        verify(bookRepository).findBookEntityByIsbn("1234567890111");
        verify(bookRepository).save(existingBook);
    }

    @Test
    public void testRegisterBook_NewIsbn() throws Exception {
        // Mock no existing book
        when(bookRepository.findBookEntityByIsbn("1234567890111")).thenReturn(Optional.empty());

        // BookDTO with new ISBN
        BookDto bookDto = new BookDto("New Title", "New Author", "1234567890111", 5);
        BookEntity expectedBookEntity = new BookEntity(bookDto.getIsbn(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCount());
        when(bookRepository.save(argThat(book -> expectedBookEntity.getIsbn().equals("1234567890111")))).thenReturn(expectedBookEntity);

        // Call the method and verify results
        BookDto registeredBookDto = bookService.registerBook(bookDto);
        assertThat(registeredBookDto.getTitle()).isEqualTo(bookDto.getTitle());
        assertThat(registeredBookDto.getCount()).isEqualTo(bookDto.getCount());

        // Verify repository calls
        verify(bookRepository).findBookEntityByIsbn("1234567890111");
    }
}
