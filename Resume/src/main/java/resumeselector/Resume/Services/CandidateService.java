package resumeselector.Resume.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resumeselector.Resume.Repositories.CandidateRespositiory;
import resumeselector.Resume.models.Candidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CandidateService {
    @Autowired
    private CandidateRespositiory candidateRespositiory;
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRespositiory.save(candidate);
    }
    public Candidate getCandidateNameByUsername(String username) {
        Candidate candidate = candidateRespositiory.findByUsername(username);
        return candidate;
    }
    public void addJobToAppliedJobs(String username, String jobId) {
        Candidate candidate = candidateRespositiory.findByUsername(username);
        if (candidate != null) {
            if(candidate.getAppliedJobs()!=null){
                candidate.getAppliedJobs().add(jobId);
            }else{
                List<String> a = new ArrayList<>();
                a.add(jobId);
                candidate.setAppliedJobs(a);
            }
            candidateRespositiory.save(candidate);
        } else {
            throw new RuntimeException("Candidate not found");
        }
    }
    public List<String> getSkillsOfCandidate(String username){
        Candidate candidate= candidateRespositiory.findByUsername(username);
        return candidate.getSkills();
    }
}