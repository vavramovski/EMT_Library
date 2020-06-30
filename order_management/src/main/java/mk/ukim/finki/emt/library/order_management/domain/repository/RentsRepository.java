package mk.ukim.finki.emt.library.order_management.domain.repository;

import mk.ukim.finki.emt.library.order_management.domain.model.rent.Rent;
import mk.ukim.finki.emt.library.order_management.domain.model.rent.RentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentsRepository extends JpaRepository<Rent, RentId> {
}
