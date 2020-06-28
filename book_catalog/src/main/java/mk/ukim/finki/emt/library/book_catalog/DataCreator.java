package mk.ukim.finki.emt.library.book_catalog;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.book_catalog.domain.model.Book;
import mk.ukim.finki.emt.library.book_catalog.domain.model.BookId;
import mk.ukim.finki.emt.library.book_catalog.domain.model.BookSample;
import mk.ukim.finki.emt.library.book_catalog.domain.model.BookSampleId;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.BookSamplesRepository;
import mk.ukim.finki.emt.library.shared_kernel.domain.rent.RentState;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataCreator {

    private final BookRepository bookRepository;
    private final BookSamplesRepository samplesRepository;

    @PostConstruct
    @Transactional
    public void generateData() {
        Set<BookSample>bookSamples1 = new HashSet<>();
        Set<BookSample>bookSamples2 = new HashSet<>();

        if(samplesRepository.findAll().size()==0){
            bookSamples1.add(new BookSample(new BookSampleId("A1"),false,RentState.valueOf(false)));
            bookSamples1.add(new BookSample(new BookSampleId("A2"),false,RentState.valueOf(false)));
            bookSamples1.add(new BookSample(new BookSampleId("A3"),false,RentState.valueOf(false)));

            bookSamples1.add(new BookSample(new BookSampleId("B1"),false,RentState.valueOf(false)));
            bookSamples1.add(new BookSample(new BookSampleId("B2"),false,RentState.valueOf(false)));

            bookSamples1.forEach(samplesRepository::save);
            bookSamples2.forEach(samplesRepository::save);
        }

        if (bookRepository.findAll().size()==0) {
            var products = new ArrayList<Book>();
            products.add(createProduct(new BookId("1"),"Ali baba i 40 razbojnici", 100,bookSamples1));
            products.add(createProduct(new BookId("2"),"Zoki poki", 30,bookSamples2));
            bookRepository.saveAll(products);
        }

    }

    private Book createProduct(BookId bookId, String title, int pages, Set<BookSample> bookSamples) {

        return new Book(bookId,title,pages,bookSamples);
    }
}
