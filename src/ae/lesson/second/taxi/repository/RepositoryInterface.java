package ae.lesson.second.taxi.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public interface RepositoryInterface<Entity> {

    void add(Entity entity);
    void add(Collection<Entity> entity);

    Collection<Entity> findAll();
    Collection<Entity> findAll(Predicate<Entity> predicate);
    Collection<Entity> findAll(Comparator<Entity> sortComparator);

    Entity findOne(Predicate<Entity> predicate);

}
