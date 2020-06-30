package mk.ukim.finki.emt.library.order_management.domain.model.rent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.library.order_management.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.order_management.domain.model.user.UserId;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.library.shared_kernel.domain.rent.RentState;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "rents")
@Getter
public class Rent extends AbstractEntity<RentId> {

    @Version
    private Long version;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RentStatus rentStatus;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_sample_id", nullable = false))
    private BookSampleId bookSampleId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    public Rent() {
    }

    public Rent(RentId id, LocalDate startDate, LocalDate endDate, BookSampleId bookSampleId, UserId userId) {
        super(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentStatus = RentStatus.ACTIVE;
        this.bookSampleId = bookSampleId;
        this.userId = userId;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void endRent(){
        if (!rentStatus.equals(RentStatus.ACTIVE)){
            throw new IllegalArgumentException("The rent is already done.");
        }
        endDate = LocalDate.now();
        rentStatus = RentStatus.DONE;
    }

}
