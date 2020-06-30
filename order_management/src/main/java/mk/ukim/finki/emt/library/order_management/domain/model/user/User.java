package mk.ukim.finki.emt.library.order_management.domain.model.user;

import lombok.Getter;
import mk.ukim.finki.emt.library.shared_kernel.domain.geo.Address;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;

@Getter
public class User {

    private UserId id;

    private FullName fullName;

    private Address address;

}
