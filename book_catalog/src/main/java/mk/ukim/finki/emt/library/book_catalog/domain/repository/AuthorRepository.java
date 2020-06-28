package mk.ukim.finki.emt.library.book_catalog.domain.repository;

import mk.ukim.finki.emt.library.book_catalog.domain.model.author.Author;
import mk.ukim.finki.emt.library.book_catalog.domain.model.author.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, AuthorId> {
}
