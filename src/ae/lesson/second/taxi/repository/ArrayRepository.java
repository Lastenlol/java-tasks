package ae.lesson.second.taxi.repository;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayRepository<Entity> implements ArrayRepositoryInterface<Entity>, Serializable {

    protected ArrayCollection<Entity> items;

    public void add(Entity item) {
        items.add(item);
    }

    public void add(Collection<Entity> items) {
        this.items.addAll(items);
    }

    public Collection<Entity> findAll() {
        return items;
    }

    public Collection<Entity> findAll(Predicate<Entity> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public Collection<Entity> findAll(Comparator<Entity> comparator) {
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    public Entity findOne(Predicate<Entity> predicate) {
        return items.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public Collection<Entity> findAll(Criteria<Entity> criteria) {
        Collection<Entity> results = new ArrayCollection<>();
        for (Entity item : items) {
            if (criteria.test(item)) results.add(item);
        }
        return results;
    }

    @Override
    public Entity findOne(Criteria<Entity> criteria) {
        for (Entity item : items) {
            if (criteria.test(item)) return item;
        }
        return null;
    }

}
