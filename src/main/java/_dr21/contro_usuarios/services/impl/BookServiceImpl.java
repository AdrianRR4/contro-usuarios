package _dr21.contro_usuarios.services.impl;

import _dr21.contro_usuarios.entities.Book;
import _dr21.contro_usuarios.repositories.BookRepository;
import _dr21.contro_usuarios.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
     this.bookRepository= bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Page<Book> getPagination(int page, int size){
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Book>getByNameBook(String nameBook) {

if(!nameBook.isEmpty()){
    Optional<Book> getBook=   bookRepository.findByName(nameBook);

}else {

}
        return null;
    }
}
