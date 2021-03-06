package at.htld.module.tracker.repo;

import at.htld.module.tracker.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jusic on 04.06.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
