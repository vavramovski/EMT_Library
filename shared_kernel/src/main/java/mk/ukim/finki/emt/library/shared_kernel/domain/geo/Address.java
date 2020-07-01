package mk.ukim.finki.emt.library.shared_kernel.domain.geo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
@Getter
@EqualsAndHashCode
public class Address implements ValueObject {

    @Embedded
    private CountryName country;

    @Embedded
    private CityName city;

    private String street;

    private int streetNumber;

    public Address() {
    }

    private Address(@NonNull CountryName country, @NonNull CityName city, @NonNull String street, @NonNull int streetNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    static public Address valueOf(CountryName country, CityName city, String street, int streetNumber) {
        return new Address(country, city, street, streetNumber);
    }

}
