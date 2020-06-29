package mk.ukim.finki.emt.library.users.domain.repository;

import mk.ukim.finki.emt.library.users.domain.model.user.User;
import mk.ukim.finki.emt.library.users.domain.model.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, UserId> {
}