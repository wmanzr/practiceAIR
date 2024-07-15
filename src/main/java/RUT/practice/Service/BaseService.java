package RUT.practice.Service;

import java.util.List;

public interface BaseService<Entity> {
	Entity create(Entity entity);
	List<Entity> getAll();
	Entity getById(int id);
	Entity update(Entity entity);
}