package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.RestController;
import sk.upjs.CheckMateRest.storage.dao.UserDao;

@RestController
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }
}
