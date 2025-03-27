package resumeselector.Resume.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resumeselector.Resume.Repositories.JobRepositiory;
import resumeselector.Resume.models.Jobs;
import resumeselector.Resume.models.Scores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JobService {
    @Autowired
    private JobRepositiory jobRepositiory;
    public List<Jobs> allJobs(){
        return jobRepositiory.findAll();
    }

    public Jobs findJobByJobId(String jobId){
            return jobRepositiory.findByJobId(jobId);
    }

    public Jobs saveJob(Jobs job) {
        return jobRepositiory.save(job);
    }
    public List<Jobs> getAllJobsByCompanyName(String companyName){return jobRepositiory.findByCompanyName(companyName);}
    public void addCandidateToApplicants(String username, String jobId) {
        Jobs job = jobRepositiory.findByJobId(jobId);
        if (job != null) {
            if(job.getApplicants()!=null){
                job.getApplicants().add(username);
            }else{
                List<String> a = new ArrayList<String>();
                a.add(username);
                job.setApplicants(a);
            }
            jobRepositiory.save(job);
        } else {
            throw new RuntimeException("Candidate not found");
        }
    }
    public void addScoresToApplicants(String username, String jobId, int score) {
        Jobs job = jobRepositiory.findByJobId(jobId);
        if (job != null) {
            if(job.getScoresList()!=null){
                job.getScoresList().add(new Scores(username, score));
            }else{
                List<Scores> a = new ArrayList<Scores>();
                a.add(new Scores(username, score));
                job.setScoresList(a);
            }
            jobRepositiory.save(job);
        } else {
            throw new RuntimeException("Candidate not found");
        }
    }
    public List<Map<String, Object>> getPrimarySkills(String jobId){
        return jobRepositiory.findByJobId(jobId).getPrimarySkills();
    }
    public List<Map<String, Object>> getHighPrioritySkills(String jobId){
        return jobRepositiory.findByJobId(jobId).getHighPrioritySkills();
    }
    public List<Map<String, Object>> getMediumPrioritySkills(String jobId){
        return jobRepositiory.findByJobId(jobId).getMediumPrioritySkills();
    }
    public List<Map<String, Object>> getLowPrioritySkills(String jobId){
        return jobRepositiory.findByJobId(jobId).getLowPrioritySkills();
    }
}
