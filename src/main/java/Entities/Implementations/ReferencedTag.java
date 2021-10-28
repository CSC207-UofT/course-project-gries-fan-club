package Entities.Implementations;

import Entities.Reference.Reference;
import Entities.Tag;
import Storages.Exceptions.NoSuchEntity;

/**
 * A facade over a reference to a tag.
 */
public class ReferencedTag extends ReferencedEntity<Tag> implements Tag {
	public ReferencedTag(Reference<Tag> reference) {
		super(reference);
	}

	/**
	 * Return the name of the tag.
	 *
	 * If the reference cannot get our entity, then the tag's ID is returned.
	 *
	 * @return The tag's name.
	 */
	@Override
	public String name() {
		try {
			return this.entityReference.get().name();
		} catch (NoSuchEntity e) {
			return this.entityReference.id().toString();
		}
	}
}
