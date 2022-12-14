package com.book.service;


import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    
    @Transactional
    public List<Book> searchBooks(String title) {
        List<Book> bookDtoList = bookRepository.findByTitleContaining(title);
        return bookDtoList;
    }

}
