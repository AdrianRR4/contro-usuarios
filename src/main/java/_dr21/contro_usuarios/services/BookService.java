package _dr21.contro_usuarios.services;

import _dr21.contro_usuarios.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll();

  Optional<Book> getByNameBook(String nameBook);

  Page<Book> getPagination(int page, int size);
}
