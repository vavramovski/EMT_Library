package mk.ukim.finki.emt.library.book_catalog.service;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSample;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.book_catalog.domain.repository.BookSamplesRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentListener {

    private final BookSamplesRepository bookSamplesRepository;

    @KafkaListener(topics = "rentCreatedTopic", groupId = "foo")
    public void listenNewRent(String message) {
        System.out.println("Received Message [rentCreatedTopic]: " + message);

        BookSampleId bookSampleId= new BookSampleId(message);
        BookSample bookSample = bookSamplesRepository.findById(bookSampleId).orElseThrow(RuntimeException::new);

        bookSample.makeRent();
        bookSamplesRepository.save(bookSample);
    }

    @KafkaListener(topics = "rentFinishedTopic", groupId = "foo")
    public void listenFinishedRent(String message) {
        System.out.println("Received Message [rentFinishedTopic]: " + message);

        BookSampleId bookSampleId= new BookSampleId(message);
        BookSample bookSample = bookSamplesRepository.findById(bookSampleId).orElseThrow(RuntimeException::new);

        bookSample.returnRent();
        bookSamplesRepository.save(bookSample);
    }
}
