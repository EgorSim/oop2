package L7;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Objects;


@Getter
@Setter
@Accessors(chain = true)
public class Entity<T> {
    private Entity<T> previous;
    private Entity<T> next;
    private  T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entity<T> that = (Entity<T>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return  value.toString();
    }
}
