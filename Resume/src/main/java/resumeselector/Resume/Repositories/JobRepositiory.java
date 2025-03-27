package resumeselector.Resume.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import resumeselector.Resume.models.Jobs;

import java.util.List;

@Repository
public interface JobRepositiory extends MongoRepository<Jobs, ObjectId> {
    Jobs findByJobId(String jobId);
    List<Jobs> findByCompanyName(String companyName);
}
