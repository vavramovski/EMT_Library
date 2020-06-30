package mk.ukim.finki.emt.library.order_management;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.order_management.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.order_management.domain.model.rent.Rent;
import mk.ukim.finki.emt.library.order_management.domain.model.rent.RentId;
import mk.ukim.finki.emt.library.order_management.domain.model.user.UserId;
import mk.ukim.finki.emt.library.order_management.domain.repository.RentsRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataCreator {

    private final RentsRepository rentsRepository;

    @PostConstruct
    @Transactional
    public void generateData() {

        Rent rent1 = addRent(new RentId("1"),
                LocalDate.now(),
                null,
                new BookSampleId("1"),
                new UserId("1"));
        Rent rent2 = addRent(new RentId("2"),
                LocalDate.now(),
                LocalDate.of(2020, 7, 10),
                new BookSampleId("2"),
                new UserId("2"));


        rentsRepository.save(rent1);
        rentsRepository.save(rent2);
        rent1.endRent();
        rentsRepository.save(rent1);

    }

    private Rent addRent(RentId id, LocalDate startDate, LocalDate endDate, BookSampleId bookSampleId, UserId userId) {
        return new Rent(id, startDate, endDate, bookSampleId, userId);
    }
}
