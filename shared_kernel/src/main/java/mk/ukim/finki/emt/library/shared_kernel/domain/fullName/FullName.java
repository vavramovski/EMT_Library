package mk.ukim.finki.emt.library.shared_kernel.domain.fullName;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.library.shared_kernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class FullName implements ValueObject {

    private String name;

    private String surname;

    public FullName() {
    }

    private FullName(@NonNull String name, @NonNull String surname) {
        this.name=name;
        this.surname=surname;
    }

    static public FullName valueOf(String name, String surname) {
        return new FullName(name, surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(name, fullName.name) &&
                Objects.equals(surname, fullName.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}

