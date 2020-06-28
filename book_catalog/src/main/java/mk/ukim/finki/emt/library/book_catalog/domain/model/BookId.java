package mk.ukim.finki.emt.library.book_catalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookId extends DomainObjectId {

    public BookId() {
        super(DomainObjectId.randomId(BookId.class).toString());
    }

    @JsonCreator
    public BookId(String id) {
        super(id);
    }

}
