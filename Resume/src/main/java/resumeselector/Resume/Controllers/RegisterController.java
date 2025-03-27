package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.Services.CandidateService;
import resumeselector.Resume.Services.CompanyService;
import resumeselector.Resume.Services.UserService;
import resumeselector.Resume.models.Candidate;
import resumeselector.Resume.models.Company;
import resumeselector.Resume.models.Jobs;
import resumeselector.Resume.models.User;

import java.util.ArrayList;


@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private CandidateService candidateService;
    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("company", new Company());
        model.addAttribute("candidate", new Candidate());
        return "register";
    }

    @PostMapping("/company")
    public String registerCompany(Company company, Model model){
        model.addAttribute("company", company);
        Company company1 = new Company(company.getCompanyName(), company.getUsername(), company.getPassword(), company.getLocation(), new ArrayList<Jobs>());
        companyService.saveCompany(company1);
        System.out.println(company);
        userService.saveUser(new User(company.getUsername(), company.getPassword(), "company"));
        return "redirect:/login";
    }
    @PostMapping("/candidate")
    public String registerCandidate(Candidate candidate, Model model){
        model.addAttribute("candidate", candidate);

        Candidate candidate1 = new Candidate(candidate.getUsername(), candidate.getCandidateName(), candidate.getPassword(), new ArrayList<String>(candidate.getSkills()), new ArrayList<String>(), candidate.getExperience());
        candidateService.saveCandidate(candidate1);
        userService.saveUser(new User(candidate.getUsername(), candidate.getPassword(), "candidate"));
        return "redirect:/login";
    }

}