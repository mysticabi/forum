package net.abi.projects.forum.data.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.abi.projects.forum.data.dao.User;;

public interface UserRepository extends CrudRepository<User, String> {
	
	@Override
	Optional<User> findById(String id);

    @Override
    void delete(User deleted);

}
