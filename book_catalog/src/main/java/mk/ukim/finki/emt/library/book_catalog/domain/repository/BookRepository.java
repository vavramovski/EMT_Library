package mk.ukim.finki.emt.library.book_catalog.domain.repository;

import mk.ukim.finki.emt.library.book_catalog.domain.model.Book;
import mk.ukim.finki.emt.library.book_catalog.domain.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
}

