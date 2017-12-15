package ae.lesson.second.taxi.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public interface ArrayRepositoryInterface<Entity> extends RepositoryInterface<Entity> {

    Collection<Entity> findAll(Criteria<Entity> criteria);

    Entity findOne(Criteria<Entity> criteria);

}
