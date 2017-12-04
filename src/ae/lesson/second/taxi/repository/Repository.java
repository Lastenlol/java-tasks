package ae.lesson.second.taxi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<Entity> implements RepositoryInterface<Entity>, Serializable {

    protected List<Entity> items = new ArrayList<>();

    public void add(Entity item) {
        items.add(item);
    }

    public void add(Collection<Entity> items) {
        this.items.addAll(items);
    }

    public List<Entity> findAll() {
        return items;
    }

    public List<Entity> findAll(Predicate<Entity> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Entity> findAll(Comparator<Entity> comparator) {
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    public Entity findOne(Predicate<Entity> predicate) {
        return items.stream().filter(predicate).findFirst().orElse(null);
    }

}
