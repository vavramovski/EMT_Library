package mk.ukim.finki.emt.library.book_catalog.domain.model.book;



import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.library.book_catalog.domain.model.author.Author;
import mk.ukim.finki.emt.library.book_catalog.domain.model.bookSample.BookSample;
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

    //todo: ako mozhesh sredi bez posebna join tabela
    @OneToMany
    @JoinColumn(name = "bookid")
    private Set<BookSample> bookSamples;

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Author> authors;

    public Book() {

    }

    public Book(BookId id, String title, int pages, Set<BookSample> bookSamples, Set<Author> authors) {
        super(id);
        this.title=title;
        this.pages=pages;
        deleted = false;
        this.bookSamples = bookSamples;
        this.authors = authors;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public int getPages() {
        return pages;
    }

    public void delete(){
        deleted=true;
    }
}
