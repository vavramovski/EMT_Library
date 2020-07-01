package mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample;

import mk.ukim.finki.emt.library.book_catalog.domain.model.book.BookId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="book_samples")
@Where(clause = "deleted=false")
public class BookSample extends AbstractEntity<BookSampleId> {
    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="bookid",nullable = false))
    private BookId bookId;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private BookSampleState bookSampleState;

    public BookSample(){}

    public BookSample(BookSampleId id, boolean deleted, BookSampleState bookSampleState, BookId bookId) {
        super(id);
        this.deleted = deleted;
        this.bookSampleState = bookSampleState;
        this.bookId = bookId;
    }

    public void makeRent(){
        if(bookSampleState.equals(BookSampleState.OCCUPIED))
            throw new IllegalArgumentException("Sample is already rented, you can't rent it until it's returned");
        bookSampleState = BookSampleState.OCCUPIED;
    }

    public void returnRent(){
        if(bookSampleState.equals(BookSampleState.FREE))
            throw new IllegalArgumentException("Sample is already returned, you can't return until you rent it");
        bookSampleState = BookSampleState.FREE;
    }

    public void delete(){
        deleted=true;
    }

}
