package ae.lesson.second.taxi.repository;

public interface Criteria<Entity> {

    public boolean test(Entity entity);

}
