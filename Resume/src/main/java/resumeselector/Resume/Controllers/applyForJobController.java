package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.Services.CandidateService;
import resumeselector.Resume.Services.JobService;
import resumeselector.Resume.Tree;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/apply")
public class applyForJobController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobService jobService;

    @GetMapping("/{username}/{jobId}")
    public String applyForJob(@PathVariable String username, @PathVariable String jobId){
        candidateService.addJobToAppliedJobs(username, jobId);
        jobService.addCandidateToApplicants(username, jobId);
        List<String> skills = candidateService.getSkillsOfCandidate(username);
        List<Map<String, Object>> primarySkills = jobService.getPrimarySkills(jobId);
        List<Map<String, Object>> highPrioritySkills = jobService.getHighPrioritySkills(jobId);
        List<Map<String, Object>> mediumPrioritySkills = jobService.getMediumPrioritySkills(jobId);
        List<Map<String, Object>> lowPrioritySkills = jobService.getLowPrioritySkills(jobId);

        int score = 0;
        for(int i = 0; i<skills.size(); i++){
            if(Tree.searchNode(primarySkills.get(0), skills.get(i))){
                score+=10;
            }
        }
        for(int i = 0; i<skills.size(); i++){
            if(Tree.searchNode(highPrioritySkills.get(0), skills.get(i))){
                score+=5;
            }
        }
        for(int i = 0; i<skills.size(); i++){
            if(Tree.searchNode(mediumPrioritySkills.get(0), skills.get(i))){
                score+=3;
            }
        }
        for(int i = 0; i<skills.size(); i++){
            if(Tree.searchNode(lowPrioritySkills.get(0), skills.get(i))){
                score+=1;
            }
        }
        jobService.addScoresToApplicants(username, jobId, score);

        return "redirect:/candidate/dashboard/" +username;
    }
}
