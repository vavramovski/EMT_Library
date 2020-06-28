package mk.ukim.finki.emt.library.book_catalog;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.book_catalog.domain.model.author.Author;
import mk.ukim.finki.emt.library.book_catalog.domain.model.author.AuthorId;
import mk.ukim.finki.emt.library.book_catalog.domain.model.book.Book;
import mk.ukim.finki.emt.library.book_catalog.domain.model.book.BookId;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSample;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.AuthorRepository;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.BookSamplesRepository;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;
import mk.ukim.finki.emt.library.shared_kernel.domain.rent.RentState;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataCreator {

    private final BookRepository bookRepository;
    private final BookSamplesRepository samplesRepository;
    private final AuthorRepository authorRepository;

    @PostConstruct
    @Transactional
    public void generateData() {
        Set<BookSample>bookSamples1 = new HashSet<>();
        Set<BookSample>bookSamples2 = new HashSet<>();
        Author author1 = new Author(new AuthorId("1"), FullName.valueOf("Petre ","M. Andreevski"),
                LocalDate.of(1925,2,2));
        Author author2 = new Author(new AuthorId("2"), FullName.valueOf("Kosta ","Solev"),
                LocalDate.of(1920,1,1));

        authorRepository.save(author1);
        authorRepository.save(author2);

        bookSamples1.add(new BookSample(new BookSampleId("A1"),false,RentState.valueOf(false),new BookId("1")));
        bookSamples1.add(new BookSample(new BookSampleId("A2"),false,RentState.valueOf(false),new BookId("1")));
        bookSamples1.add(new BookSample(new BookSampleId("A3"),false,RentState.valueOf(false),new BookId("1")));
        bookSamples2.add(new BookSample(new BookSampleId("B1"),false,RentState.valueOf(false),new BookId("2")));
        bookSamples2.add(new BookSample(new BookSampleId("B2"),false,RentState.valueOf(false),new BookId("2")));


        if (bookRepository.findAll().size()==0) {
            var products = new ArrayList<Book>();
            var authors1 = Set.of(author1);
            var authors2 = Set.of(author1,author2);
            products.add(createProduct(new BookId("1"),"Ali baba i 40 razbojnici", 100,bookSamples1,authors1));
            products.add(createProduct(new BookId("2"),"Zoki poki", 30,bookSamples2,authors2));
            bookRepository.saveAll(products);
        }

        if (samplesRepository.findAll().size() == 0){
        bookSamples1.forEach(samplesRepository::save);
        bookSamples2.forEach(samplesRepository::save);
    }

    }

    private Book createProduct(BookId bookId, String title, int pages, Set<BookSample> bookSamples, Set<Author> authors) {
        return new Book(bookId,title,pages,new HashSet<BookSample>(),authors);
    }
}
