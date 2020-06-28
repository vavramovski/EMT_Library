package mk.ukim.finki.emt.library.book_catalog.domain.repository;

import mk.ukim.finki.emt.library.book_catalog.domain.model.BookSample;
import mk.ukim.finki.emt.library.book_catalog.domain.model.BookSampleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSamplesRepository extends JpaRepository<BookSample, BookSampleId> {
}

