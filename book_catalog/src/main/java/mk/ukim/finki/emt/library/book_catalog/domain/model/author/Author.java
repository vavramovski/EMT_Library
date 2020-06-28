package mk.ukim.finki.emt.library.book_catalog.domain.model.author;

import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDate;

@Entity
@Table(name="author")
@Where(clause = "deleted=false")
public class Author extends AbstractEntity<AuthorId> {

    @Version
    private Long version;

    private boolean deleted;

    private FullName fullName;

    private LocalDate birthDate;

    public Author() {}

    public Author(AuthorId id, FullName fullName, LocalDate birthDate) {
        super(id);
        deleted = false;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }
}
