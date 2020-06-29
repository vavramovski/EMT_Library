package mk.ukim.finki.emt.library.users;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.library.shared_kernel.domain.address.Address;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;
import mk.ukim.finki.emt.library.users.domain.model.user.User;
import mk.ukim.finki.emt.library.users.domain.model.user.UserId;
import mk.ukim.finki.emt.library.users.domain.repository.UsersRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class DataCreator {

    private final UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void generateData() {

        //User user1 = new User(new UserId("1"), FullName.valueOf("Jovan", "Velkovski"), Address.valueOf("N. Macedonia", "Skopje", "Spiro Crne", 34));
        //User user2 = new User(new UserId("2"), FullName.valueOf("Viktor", "Avramovski"), Address.valueOf("N. Macedonia", "Skopje", "Konstantin Petkovikj", 24));
        User user1 = registerUser(new UserId("1"),
                FullName.valueOf("Jovan", "Velkovski"),
                Address.valueOf("N. Macedonia", "Skopje", "Gazi Baba", "Spiro Crne", 34));
        User user2 = registerUser(new UserId("2"),
                FullName.valueOf("Viktor", "Avramovski"),
                Address.valueOf("N. Macedonia", "Skopje", "Gazi Baba", "Konstantin Petkovikj", 24));
        usersRepository.save(user1);
        usersRepository.save(user2);

    }

    private User registerUser(UserId userId, FullName fullName, Address address) {
        return new User(userId, fullName, address);
    }
}
