package sk.upjs.CheckMateRest.storage.dao;



import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.triedy.Test;

import java.sql.Time;
import java.util.List;

public interface TestDao {
    void save(Test test) throws EntityNotFoundException;

    List<Test> getAllUserTests(int user_id) throws EntityNotFoundException;

    int testsOnTime(Time time, java.util.Date date);

    Test getTestById(long testId);

    void updateTestResultById(long testId, int newResult) throws EntityNotFoundException;

    Test getUsersPCRTest(int userId);

    Test getUsersNAATsTest(int userId);

    List<Test> getTestsOlderThanTenMinutes(int userId);
}
