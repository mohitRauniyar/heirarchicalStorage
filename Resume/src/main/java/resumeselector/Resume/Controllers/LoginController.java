package resumeselector.Resume.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import resumeselector.Resume.Services.loginService;
import resumeselector.Resume.models.LoginModel;

import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private loginService loginService;
    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(LoginModel loginModel, Model model){
        model.addAttribute("loginModel", loginModel);

        if(Objects.equals(loginService.findUserByUsername(loginModel.getUsername()), loginModel.getPassword())){

            if(Objects.equals(loginService.findUserTypeByUsername(loginModel.getUsername()), "candidate"))
                return "redirect:/candidate/dashboard/"+ loginModel.getUsername();
            else if (Objects.equals(loginService.findUserTypeByUsername(loginModel.getUsername()), "company")){
                System.out.println(loginService.findUserByUsername(loginModel.getUsername()));
                System.out.println(loginModel.getPassword());
                return "redirect:/company/" + loginModel.getUsername();
            }
        }
            return "redirect:/login";
    }
}
