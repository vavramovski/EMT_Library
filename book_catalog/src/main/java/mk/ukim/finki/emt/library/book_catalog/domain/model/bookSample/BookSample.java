package mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample;

import mk.ukim.finki.emt.library.book_catalog.domain.model.book.BookId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.library.shared_kernel.domain.rent.RentState;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="book_samples")
@Where(clause = "deleted=false")
public class BookSample extends AbstractEntity<BookSampleId> {
    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="book_id",nullable = false))
    private BookId bookId;

    private boolean deleted;

    @Embedded
    private RentState rentState;

    public BookSample(){}

    public BookSample(BookSampleId id, boolean deleted, RentState rentState, BookId bookId) {
        super(id);
        this.deleted = deleted;
        this.rentState = rentState;
        this.bookId = bookId;
    }

    public void makeRent(){
        if(rentState.isRented())
            throw new IllegalArgumentException("Sample is already rented, you can't rent it until it's returned");
        rentState = RentState.newRent();
    }

    public void returnRent(){
        if(!rentState.isRented())
            throw new IllegalArgumentException("Sample is already returned, you can't return until you rent it");
        rentState = RentState.returnedRent();
    }

    public void delete(){
        deleted=true;
    }

}
