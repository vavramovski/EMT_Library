package mk.ukim.finki.emt.library.shared_kernel.domain.address;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Address implements ValueObject {

    private String country;
    private String city;
    private String municipality;
    private String street;
    private int streetNumber;

    public Address() {
    }

    public Address(@NonNull String country, @NonNull String city, @NonNull String municipality, @NonNull String street, @NonNull int streetNumber) {
        this.country = country;
        this.city = city;
        this.municipality = municipality;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    static public Address valueOf(String country, String city, String municipality, String street, int streetNumber) {
        return new Address(country, city, municipality, street, streetNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber &&
                country.equals(address.country) &&
                city.equals(address.city) &&
                municipality.equals(address.municipality) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, municipality, street, streetNumber);
    }
}
