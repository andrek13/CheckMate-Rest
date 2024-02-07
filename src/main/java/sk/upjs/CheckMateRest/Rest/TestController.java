package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.dao.TestDao;
import sk.upjs.CheckMateRest.storage.triedy.Test;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    private final TestDao testDao;

    public TestController(TestDao testDao) {
        this.testDao = testDao;
    }

    @PostMapping("/tests")
    public void save(Test test) throws EntityNotFoundException {
        testDao.save(test);
    }

    @GetMapping("/tests/{user_id}")
    public List<Test> getAllUserTests(@PathVariable int user_id) throws EntityNotFoundException {
        List<Test> allUserTests = testDao.getAllUserTests(user_id);
        return allUserTests;
    }

    @GetMapping("/tests/testsOnTime/{time}/{date}")
    public int testsOnTime(@PathVariable Time time, @PathVariable Date date){
        return testDao.testsOnTime(time, date);
    }

    @GetMapping("/tests/getTestById/{testId}")
    public Test getTestById(@PathVariable long testId){
        return  testDao.getTestById(testId);
    }

    @PostMapping("/tests/updateTestResultById/{testId}/{newResult}")
    public void updateTestResultById(@PathVariable int testId, @PathVariable int newResult) throws EntityNotFoundException {
        testDao.updateTestResultById(testId, newResult);
    }

    @GetMapping("/tests/getUsersPCRTest/{userId}")
    public Test getUsersPCRTest(@PathVariable int userId){
        return testDao.getUsersPCRTest(userId);
    }

    @GetMapping("/tests/getUsersNAATsTest/{userId}")
    public Test getUsersNAATsTest(@PathVariable int userId){
        return testDao.getUsersNAATsTest(userId);
    }

    @GetMapping("/tests/getTestsOlderThanTenMinutes/{userId}")
    public List<Test> getTestsOlderThanTenMinutes(@PathVariable int userId){
        return testDao.getTestsOlderThanTenMinutes(userId);
    }

}
