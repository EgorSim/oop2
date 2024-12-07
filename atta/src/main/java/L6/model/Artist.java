package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Artist implements Comparable<Artist> {

    @Override
    public int compareTo(Artist o) {
        if (this.equals(o)) {
            return 0;
        }
        return this.surname.compareTo(o.surname);
    }

    private String name;
    private String surname;
    private LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name)
                && Objects.equals(surname, artist.surname)
                && Objects.equals(birthDate, artist.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

}
