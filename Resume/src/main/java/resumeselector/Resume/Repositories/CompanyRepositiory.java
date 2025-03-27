package resumeselector.Resume.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import resumeselector.Resume.models.Candidate;
import resumeselector.Resume.models.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepositiory extends MongoRepository<Company, ObjectId> {
    Company findByUsername(String username);

}