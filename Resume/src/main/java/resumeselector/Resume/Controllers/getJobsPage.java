package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.Services.CandidateService;
import resumeselector.Resume.Services.CompanyService;
import resumeselector.Resume.Services.JobService;
import resumeselector.Resume.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/company")
public class getJobsPage {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobService jobService;
    @Autowired
    private CandidateService candidateService;


    @GetMapping("/{username}/jobs")
    public String getAllJobsPage(@PathVariable String username, Model model){
        Company company = companyService.getCompanyNameByUsername(username);
        model.addAttribute("company", company);
        List<Jobs> jobs = jobService.getAllJobsByCompanyName(company.getCompanyName());
        model.addAttribute("jobs", jobs);
        return "CompanyJobsPage";
    }
    @GetMapping("/{username}/job/{jobId}")
    public String getJobPage(@PathVariable String username, @PathVariable String jobId, Model model){
        Company company = companyService.getCompanyNameByUsername(username);
        model.addAttribute("company", company);
        Jobs job = jobService.findJobByJobId(jobId);
        model.addAttribute("job", job);
        List<DisplayCandidateWithScore> candidateList = new ArrayList<DisplayCandidateWithScore>();


        List<Scores> s = job.getScoresList();
        s.sort(Comparator.comparingInt(Scores::getScore).reversed());



        for(int i = 0; i< 5 && i<s.size(); i++){
            Candidate candidate = candidateService.getCandidateNameByUsername(s.get(i).getUsername());
            candidateList.add(new DisplayCandidateWithScore(candidate, s.get(i).getScore()));
        }
        model.addAttribute("candidateList", candidateList);
        return "ViewApplicantsPage";
    }


}
