package mk.ukim.finki.emt.library.book_catalog.domain.repository;

import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSample;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSampleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSamplesRepository extends JpaRepository<BookSample, BookSampleId> {
}

