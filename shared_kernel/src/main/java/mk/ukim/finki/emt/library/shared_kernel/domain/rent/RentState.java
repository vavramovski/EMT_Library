package mk.ukim.finki.emt.library.shared_kernel.domain.rent;

import lombok.Getter;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;


/**
 Value Object representing state of a rent containing only 1 boolean value
 - ne zaboravaj da koristis @Embedded
 * */
@Embeddable
@Getter
public class RentState implements ValueObject {

    private final boolean isRented;

    public RentState() {
        isRented=false;
    }

    private RentState(boolean isRented) {
        this.isRented = isRented;
    }


    public static RentState valueOf(boolean value){
        return new RentState(value);
    }

    public static RentState newRent(){
        return new RentState(true);
    }

    public static RentState returnedRent(){
        return new RentState(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentState rentState = (RentState) o;
        return isRented == rentState.isRented;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRented);
    }



}
