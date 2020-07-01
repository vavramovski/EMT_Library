package mk.ukim.finki.emt.library.order_management.rest;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.order_management.service.RentProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentProducer rentProducer;

    @GetMapping(path = "/create/{bookId}")
    public void createRent(@PathVariable String bookId){
        rentProducer.sendRentCreatedEvent(bookId);
    }

    @GetMapping(path = "/finish/{bookId}")
    public void finishRent(@PathVariable String bookId){
        rentProducer.sendRentFinishedEvent(bookId);
    }
}
