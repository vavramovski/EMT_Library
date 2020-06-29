package mk.ukim.finki.emt.library.users.domain.model.user;

import mk.ukim.finki.emt.library.shared_kernel.domain.address.Address;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.library.shared_kernel.domain.fullName.FullName;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "users")
@Where(clause = "deleted=false")
public class User extends AbstractEntity<UserId> {

    @Version
    private Long version;

    private boolean deleted;

    private FullName fullName;

    private Address address;

    public User() {
    }

    public User(UserId id, FullName fullName, Address address) {
        super(id);
        this.deleted = false;
        this.fullName = fullName;
        this.address = address;
    }

}
