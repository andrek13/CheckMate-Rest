package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.*;
import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.dao.UserDao;
import sk.upjs.CheckMateRest.storage.triedy.User;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @PostMapping("/user/save")
    public void saveUser(User user) throws EntityNotFoundException {
        userDao.save(user);
    }

    @GetMapping("/user/getUserByLoginAndPassword/{login}/{password}")
    public User getUserByLoginAndPassword(@PathVariable String login, @PathVariable String password){
        return userDao.getUserByLoginAndPassword(login, password);
    }

    @GetMapping("/user/searchUserByNameSurnameOrId/{nameSurnameOrId}")
    public List<User> searchUserByNameSurnameOrId(@PathVariable String nameSurnameOrId){
        return userDao.searchUserByNameSurnameOrId(nameSurnameOrId);
    }

    @GetMapping("/user/checkIfLoginExist/{login}")
    public boolean checkIfLoginExist(@PathVariable String login) throws EntityNotFoundException {
        boolean result = userDao.checkIfLoginExist(login);
        return result;
    }

    @GetMapping("/user/checkIfWorkerCodeIsReal/{code}")
    public boolean checkIfWorkerCodeIsReal(@PathVariable String code) throws EntityNotFoundException {
        boolean result = userDao.checkIfWorkerCodeIsReal(code);
        return result;
    }

    @GetMapping("/user/workersOnTime/{date}/{stationId}/{isFirst}")
    public int workersOnTime(@PathVariable Date date, @PathVariable int stationId, @PathVariable boolean isFirst){
        return userDao.workersOnTime(date, stationId, isFirst);
    }

    @GetMapping("/user/isUserEmployee/{idUser}")
    public boolean isUserEmployee(@PathVariable int idUser){
        boolean result = userDao.isUserEmployee(idUser);
        return result;
    }

    @GetMapping("/user/returnEmployees/")
    public List<User> returnEmployees(){
        return userDao.returnEmployees();
    }

    @GetMapping("/user/hasUpcomingShifts/{userId}")
    public boolean hasUpcomingShifts(@PathVariable int userId){
        boolean result = userDao.hasUpcomingShifts(userId);
        return result;
    }

    @GetMapping("/user/updateBalance/{userId}/{amountToAdd}")
    public void updateBalance(@PathVariable int userId, @PathVariable double amountToAdd) throws EntityNotFoundException {
        userDao.updateBalance(userId, amountToAdd);
    }

    @GetMapping("/user/deductFromBalance/{userId}/{amountToDeduct}")
    public int deductFromBalance(@PathVariable int userId, @PathVariable double amountToDeduct) throws EntityNotFoundException {
        return userDao.deductFromBalance(userId, amountToDeduct);
    }

    @GetMapping("/user/setCardId/{userId}/{cardId}")
    public void setCardId(@PathVariable int userId, int cardId) throws EntityNotFoundException {
        userDao.setCardId(userId, cardId);
    }

    @GetMapping("/user/getById/{id}")
    public User getById(@PathVariable int id) throws EntityNotFoundException {
        return userDao.getById(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable int id) throws EntityNotFoundException {
        userDao.deleteUserById(id);
    }
}