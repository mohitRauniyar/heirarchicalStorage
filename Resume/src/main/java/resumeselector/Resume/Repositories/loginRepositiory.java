package resumeselector.Resume.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import resumeselector.Resume.models.Users;

import java.util.Optional;

@Repository
public interface loginRepositiory extends MongoRepository<Users, ObjectId> {
    Optional<Users> findByUsername(String username);
}
