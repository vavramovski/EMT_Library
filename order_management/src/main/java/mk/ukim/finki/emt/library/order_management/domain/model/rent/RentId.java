package mk.ukim.finki.emt.library.order_management.domain.model.rent;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RentId extends DomainObjectId {

    public RentId() {
        super(DomainObjectId.randomId(RentId.class).toString());
    }

    @JsonCreator
    public RentId(String id) {
        super(id);
    }

}