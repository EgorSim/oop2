package L7;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<Entity<T>>, LinkedListInterface<T> {

    private Entity<T> head;
    private Entity<T> tail;
    private int size;

    @Override
    public void add(T value) {
        size++;
        Entity<T> entity = new Entity<>();
        entity.setValue(value).setNext(null).setPrevious(null);
        if (head == null) {
            head = entity;
            tail = entity;
            return;
        }

        Entity<T> start = head;
        while (start.getNext() != null) {
            start = start.getNext();
        }
        start.setNext(entity);
        entity.setPrevious(start);
        tail = entity;
    }

    @Override
    public Entity<T> delete() {
        if (size == 0) {
            throw new LinkedListException("Список пуст");
        }
        if (size == 1){
            Entity<T> elem = head;
            head = null;
            tail = null;
            return elem;
        }
        Entity<T> start = head;
        while (start.getNext() != null) {
            start = start.getNext();
        }
        tail = start.getPrevious();
        tail.setNext(null);
        size--;
        return start;
    }

    @Override
    public Entity<T> delete(T value) {
        if (size == 0) {
            throw new LinkedListException("Список пуст");
        }
        if (size == 1){
            Entity<T> elem = head;
            head = null;
            tail = null;
            return elem;
        }
        Entity<T> start = head;
        if (head.getValue().equals(value)) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return start;
        }
        while (start.getNext() != null) {
            if (start.getValue().equals(value)) {
                start.getPrevious().setNext(start.getNext());
                start.getNext().setPrevious(start.getPrevious());
                size--;
                return start;
            }
            start = start.getNext();
        }
        if (tail.getValue().equals(value)) {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return start;
        }
        throw new LinkedListException("Элемента нет в этом списке");
    }

    @Override
    public Entity<T> findByValue(T value) {
        for (Iterator<Entity<T>> i = iterator(); i.hasNext();){
            Entity<T> elem = i.next();
            if (elem.getValue().equals(value)) {
                return elem;
            }
        }
        throw new LinkedListException("Элемента нет в этом списке");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entity<T> getHead() {
        return head;
    }

    @Override
    public Entity<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<Entity<T>> iterator() {
        return new Iterator<Entity<T>>() {
            Entity<T> curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Entity<T> next() {
                Entity<T> elem = curr;
                curr = curr.getNext();
                return elem;
            }
        };
    }
}
