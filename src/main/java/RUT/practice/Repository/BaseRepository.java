package RUT.practice.Repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseRepository<Entity> {

    private final Class<Entity> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public Entity create(Entity entity) {
        try {
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Entity> getAll() {
        try {
            return entityManager.createQuery("from " + entityClass.getName(), entityClass).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Entity getById(int id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Entity update(Entity entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
