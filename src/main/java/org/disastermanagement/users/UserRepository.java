package org.disastermanagement.users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<AppUser, String> {
  Optional<AppUser> findByUsername(String username);
}
