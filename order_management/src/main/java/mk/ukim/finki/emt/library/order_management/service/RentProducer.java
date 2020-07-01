package mk.ukim.finki.emt.library.order_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RentProducer {

    private final KafkaTemplate<Object, String> kafkaTemplate;

    private String rentCreatedTopic = "rentCreatedTopic";
    private String rentFinishedTopic = "rentFinishedTopic";

    public void sendRentCreatedEvent(String message) {

        kafkaTemplate.send(rentCreatedTopic,message);
        this.kafkaTemplate.flush();
        System.out.println("Event sent: RentCreated");
    }

    public void sendRentFinishedEvent(String message) {

        kafkaTemplate.send(rentFinishedTopic,message);
        this.kafkaTemplate.flush();
        System.out.println("Event sent: RentFinished");
    }
}
