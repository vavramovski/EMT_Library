package mk.ukim.finki.emt.library.users.domain.model.user;

import mk.ukim.finki.emt.library.shared_kernel.domain.geo.Address;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;
import org.hibernate.annotations.Where;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "users")
@Where(clause = "active=true")
public class User extends AbstractEntity<UserId> {

    @Version
    private Long version;

    private boolean active;

    @Embedded
    private FullName fullName;

    @Embedded
    private Address address;

    public User() {
    }

    public User(UserId id, FullName fullName, Address address) {
        super(id);
        this.active = true;
        this.fullName = fullName;
        this.address = address;
    }

}
