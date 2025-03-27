package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.Services.CandidateService;
import resumeselector.Resume.Services.JobService;
import resumeselector.Resume.models.Jobs;
import resumeselector.Resume.models.Candidate;

import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateDashboardController {
    @Autowired
    private JobService jobService;
    @Autowired
    private CandidateService candidateService;
    @GetMapping("/dashboard/{username}")
    public String getCandidateDashboardPage(@PathVariable String username, Model model){
        List<Jobs> jobOpenings = jobService.allJobs();
        System.out.println(jobOpenings);
        model.addAttribute("jobOpenings", jobOpenings);
        Candidate candidate = candidateService.getCandidateNameByUsername(username);
        model.addAttribute("candidate", candidate);
        return "candidateDashboard";
    }
    @GetMapping("/job/{username}/{jobId}")
    public String getJobShowPage(@PathVariable String username, @PathVariable String jobId, Model model){
        Jobs job = jobService.findJobByJobId(jobId);
        model.addAttribute("job", job);
        Candidate candidate = candidateService.getCandidateNameByUsername(username);
        model.addAttribute("candidate", candidate);
        return "jobDescriptionPage";
    }
}
