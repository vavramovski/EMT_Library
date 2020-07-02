package mk.ukim.finki.emt.library.order_management.service;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.order_management.domain.model.bookSample.BookSampleId;
import mk.ukim.finki.emt.library.order_management.domain.model.rent.Rent;
import mk.ukim.finki.emt.library.order_management.domain.model.rent.RentId;
import mk.ukim.finki.emt.library.order_management.domain.model.user.UserId;
import mk.ukim.finki.emt.library.order_management.domain.repository.RentsRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class RentService {

    private final KafkaTemplate<Object, String> kafkaTemplate;
    private final RentsRepository rentsRepository;
    private String rentCreatedTopic = "rentCreatedTopic";
    private String rentFinishedTopic = "rentFinishedTopic";

    public void createRent(String message, UserId userId) {
        kafkaTemplate.send(rentCreatedTopic,message);
        this.kafkaTemplate.flush();

        RentId rentId = new RentId(RandomString.make(8));
        Rent rent = new Rent(rentId, LocalDate.now(), null, new BookSampleId(message), userId);
        rentsRepository.save(rent);
        System.out.println("Event sent: RentCreated");
    }

    public void finishRent(String message, UserId userId) {

        kafkaTemplate.send(rentFinishedTopic,message);
        this.kafkaTemplate.flush();
        BookSampleId bookSampleId = new BookSampleId(message);
        Rent rent = rentsRepository.findByBookSampleIdAndUserIdAndEndDateNull(bookSampleId,userId);
        rent.endRent();
        rentsRepository.save(rent);
        System.out.println("Event sent: RentFinished");
    }
}
