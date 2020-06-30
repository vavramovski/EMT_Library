package mk.ukim.finki.emt.library.order_management.domain.model.author;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.library.order_management.domain.model.book.BookId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AuthorId extends DomainObjectId {

    public AuthorId() {
        super(DomainObjectId.randomId(BookId.class).toString());
    }

    @JsonCreator
    public AuthorId(String id) {
        super(id);
    }

}