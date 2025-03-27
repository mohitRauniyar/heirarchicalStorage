package resumeselector.Resume.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import resumeselector.Resume.models.Candidate;

public interface CandidateRespositiory extends MongoRepository<Candidate, ObjectId> {
    Candidate findByUsername(String username);
}
