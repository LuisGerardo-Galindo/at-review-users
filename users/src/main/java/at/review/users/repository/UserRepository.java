package at.review.users.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import at.review.users.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	List<User> findAll();

	boolean existsByEmail(String email);
}