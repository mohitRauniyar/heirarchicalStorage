package resumeselector.Resume.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resumeselector.Resume.Repositories.UserRepositiory;
import resumeselector.Resume.models.User;
@Service
public class UserService {
    @Autowired
    private UserRepositiory userRepositiory;
    public User saveUser(User user) {
        return userRepositiory.save(user);
    }
}

