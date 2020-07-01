package mk.ukim.finki.emt.library.book_catalog.domain.events;

import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;


public class RentCreatedEvent  implements DomainEvent {

    private final Instant timeOccurred;

    private final BookSampleId bookSampleId;

    public RentCreatedEvent(@NonNull BookSampleId bookSampleId) {
        this.bookSampleId = bookSampleId;
        this.timeOccurred = Instant.now();
    }

    @Override
    public Instant occurredOn() {
        return timeOccurred;
    }

    public BookSampleId getBookSampleId() {
        return bookSampleId;
    }
}
