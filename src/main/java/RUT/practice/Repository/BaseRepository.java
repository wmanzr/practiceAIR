package RUT.practice.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseRepository<Entity, T> {

    private final Class<Entity> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public void create(Entity entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public Entity getById(Class<Entity> entityClass, Integer id) {
        return entityManager.find(entityClass, id);
    }

    @Transactional
    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }
}