package at.review.users.validator;

public interface Validator<E> {
	void validate(E object);
}
