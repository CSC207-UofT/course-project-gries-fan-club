package Storages.Implementations;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractStorage<T> {

	protected final Collection<T> entities = new ArrayList<>();

	public abstract String type();

	public void add(T entity) {
		this.entities.add(entity);
	}

	public void addAll(Collection<T> entities) {
		for(T entity : entities) {
			this.add(entity);
		}
	}

}
