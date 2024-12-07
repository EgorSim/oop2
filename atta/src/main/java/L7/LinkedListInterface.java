package L7;

public interface LinkedListInterface<T> {
    void add(T value);

    Entity<T> delete();

    Entity<T> delete(T value);

    Entity<T> findByValue(T value);

    int size();

    Entity<T> getHead();

    Entity<T> getTail();
}

