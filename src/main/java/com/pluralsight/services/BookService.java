package com.pluralsight.services;


import com.pluralsight.models.Book;
import com.pluralsight.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {



    @Autowired
    BookRepository repository;

    @PersistenceContext
    EntityManager em ;

    public List<Book> getAllBooks(){
        return repository.findAll();
    }
    public Optional<Book> finBook(int id){
        return repository.findById(id);
    }

    @Transactional
    public void saveBook(Book book){
        repository.save(em.merge(book));
    }
}
