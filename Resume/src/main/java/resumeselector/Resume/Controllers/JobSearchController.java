package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import resumeselector.Resume.Services.JobService;
import resumeselector.Resume.models.Jobs;

@Controller
@RequestMapping("/api/v1/jobs")
public class JobSearchController {
    @Autowired
    private JobService jobService;
    @GetMapping
    public  String findPage(Model model){
        model.addAttribute("message", jobService.allJobs());
        return "a";
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Jobs> findJob(@PathVariable String jobId){
        return new ResponseEntity<Jobs>(jobService.findJobByJobId(jobId), HttpStatus.OK);
    }
}
