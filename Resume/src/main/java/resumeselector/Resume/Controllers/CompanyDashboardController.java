package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.*;
import resumeselector.Resume.Services.CompanyService;
import resumeselector.Resume.Services.JobService;
import resumeselector.Resume.models.Company;
import resumeselector.Resume.models.JobOpenings;
import resumeselector.Resume.models.Jobs;
import resumeselector.Resume.models.Scores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyDashboardController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobService jobService;

    @GetMapping("/{username}")
    public String getCompanyDashboardPage(@PathVariable String username, Model model, JobOpenings jobOpenings){
        Company company = companyService.getCompanyNameByUsername(username);
        model.addAttribute("company", company);
        model.addAttribute("jobOpenings", jobOpenings);
        return "companyDashboard";
    }
    @PostMapping("/jobs/{username}")
    public String processNewJob(@PathVariable String username, JobOpenings jobOpenings, Model model){
        Company company = companyService.getCompanyNameByUsername(username);
        model.addAttribute("company", company);
        jobOpenings.setCompanyName(company.getCompanyName());
        model.addAttribute("jobOpenings", jobOpenings);
        List<Map<String, Object>> primarySkills = Tree.treefy(jobOpenings.getPrimarySkills());
        List<Map<String, Object>> highPrioritySkills = Tree.treefy(jobOpenings.getHighPrioritySkills());
        List<Map<String, Object>> mediumPrioritySkills = Tree.treefy(jobOpenings.getMediumPrioritySkills());
        List<Map<String, Object>> lowPrioritySkills = Tree.treefy(jobOpenings.getLowPrioritySkills());
        Jobs jobs = new Jobs(jobOpenings.getJobId(), jobOpenings.getCompanyName(), jobOpenings.getDescription(), jobOpenings.getPosition(), jobOpenings.getSalary(), jobOpenings.getNumberOfOpenPositions(), jobOpenings.getExperienceRequiredInYears(),jobOpenings.getQualificationRequired(), primarySkills, highPrioritySkills, mediumPrioritySkills,lowPrioritySkills, new ArrayList<String>(), new ArrayList<Scores>());
        jobService.saveJob(jobs);
        return "redirect:/company/"+username;
    }
}
