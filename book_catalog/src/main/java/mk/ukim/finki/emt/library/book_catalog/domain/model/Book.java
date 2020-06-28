package mk.ukim.finki.emt.library.book_catalog.domain.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="books")
@Where(clause = "deleted=false")
public class Book extends AbstractEntity<BookId> {

    @Version
    private Long version;

    private boolean deleted;


    private String title;

    private int pages;


    public Book() {

    }

    public Book(BookId id, String title, int pages, Set<BookSample> bookSamples) {
        super(id);
        this.title=title;
        this.pages=pages;
        deleted = false;
        this.bookSamples = bookSamples;
    }

    //todo: dodadi vrska do [BookSample]

    @OneToMany
    private Set<BookSample> bookSamples;

    public boolean isDeleted() {
        return deleted;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}
