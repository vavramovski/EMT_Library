package mk.ukim.finki.emt.library.users.domain.model.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    public UserId() {
        super(DomainObjectId.randomId(UserId.class).toString());
    }

    @JsonCreator
    public UserId(String id) {
        super(id);
    }

}
