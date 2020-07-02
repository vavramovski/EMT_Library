package mk.ukim.finki.emt.library.order_management.rest;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.order_management.domain.model.user.UserId;
import mk.ukim.finki.emt.library.order_management.service.RentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;


    @GetMapping(path = "/create/{bookId}")
    public void createRent(@PathVariable String bookId, @RequestParam UserId userId){
        rentService.createRent(bookId,userId);
    }

    @GetMapping(path = "/finish/{bookId}")
    public void finishRent(@PathVariable String bookId, @RequestParam UserId userId){
        rentService.finishRent(bookId,userId);
    }
}
