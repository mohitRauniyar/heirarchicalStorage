package resumeselector.Resume.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/skilllist")
public class skilllist {
    @GetMapping
    public ResponseEntity<String[]> getAllSkills(){
        String[] abc = {"Java", "C++", "Python", "Web Development"};
        return new ResponseEntity<String[]>(abc, HttpStatus.OK);
    }
}
