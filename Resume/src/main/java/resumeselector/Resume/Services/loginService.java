package resumeselector.Resume.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resumeselector.Resume.models.Users;

import java.util.Optional;

@Service
public class loginService {
    @Autowired
    private resumeselector.Resume.Repositories.loginRepositiory loginRepositiory;


    public String findUserByUsername(String username) {
        Optional<Users> userOptional = loginRepositiory.findByUsername(username);

        return userOptional
                .map(Users::getPassword) // Extract the password if User is present
                .orElse(null);
//        return loginRepositiory.findByUsername(username);
    }
    public String findUserTypeByUsername(String username){
        Optional<Users> userOptional = loginRepositiory.findByUsername(username);

        return userOptional
                .map(Users::getUserType) // Extract the password if User is present
                .orElse(null);
//        return loginRepositiory.findByUsername(username);
    }
}
