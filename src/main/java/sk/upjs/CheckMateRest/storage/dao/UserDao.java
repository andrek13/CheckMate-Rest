package sk.upjs.CheckMateRest.storage.dao;



import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.triedy.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    User getById(int id) throws EntityNotFoundException;

    void save(User user) throws EntityNotFoundException;
    boolean checkIfLoginExist(String login)throws EntityNotFoundException;
    boolean checkIfWorkerCodeIsReal(String code) throws EntityNotFoundException;
    boolean checkIfUserExists(String login, String password) throws EntityNotFoundException;

    User getUserByLoginAndPassword(String login, String password);

    int workersOnTime(Date date,int stationId, boolean isFirst);

    boolean isUserEmployee(int userId);

    List<User> returnEmployees();

    void deleteUserById(int userId) throws EntityNotFoundException;

    boolean checkIfUserExistsById(int userId);

    List<User> searchUserByNameSurnameOrId(String nameSurnameOrId);

    boolean hasUpcomingShifts(int userId);

    void updateBalance(int userId, double amountToAdd) throws EntityNotFoundException;

    int deductFromBalance(int userId, double amountToDeduct) throws EntityNotFoundException;

    void setCardId(int userId, int cardId) throws EntityNotFoundException;
}
