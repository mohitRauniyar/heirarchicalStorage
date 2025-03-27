package resumeselector.Resume.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import resumeselector.Resume.models.User;

@Repository
public interface UserRepositiory extends MongoRepository<User, ObjectId> {
}
