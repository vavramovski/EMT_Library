package mk.ukim.finki.emt.library.book_catalog.domain.repository;

import mk.ukim.finki.emt.library.book_catalog.domain.model.book.Book;
import mk.ukim.finki.emt.library.book_catalog.domain.model.book.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
}

