package com.codingdojo.updateanddelete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PutMapping;

//import com.codingdojo.updateanddelete.controllers.BooksAPI;
import com.codingdojo.updateanddelete.models.Book;
import com.codingdojo.updateanddelete.repositories.BookRepository;

@Service
public class BookService {
	
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    
    // updates a book from the API
    //    @PutMapping("/api/books/{id}")
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book book = this.findBook(id);
    	
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	
    	bookRepository.save(book);
    	return book;
    }
    
    
    // updates a book from the booksController
    
    public Book updateBook(Book book) {

    	bookRepository.save(book);
    	return book;
    }
    
    // Deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
