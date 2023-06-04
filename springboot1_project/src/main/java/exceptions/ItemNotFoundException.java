package exceptions;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException(Long id) {
		super("Item with id" + id + "not found");
	}

	public ItemNotFoundException(String name) {
		super("Item with name" + name + "not found");
	}
}
