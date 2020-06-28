package mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.library.book_catalog.domain.model.book.BookId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookSampleId extends DomainObjectId {

    public BookSampleId() {
        super(DomainObjectId.randomId(BookId.class).toString());
    }

    @JsonCreator
    public BookSampleId(String id) {
        super(id);
    }

}
