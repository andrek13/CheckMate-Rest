package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.CheckMateRest.storage.dao.ShiftDao;
import sk.upjs.CheckMateRest.storage.triedy.Shift;

import java.util.Date;
import java.util.List;

@RestController
public class ShiftController {

    private final ShiftDao shiftDao;

    public ShiftController(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }

    @PostMapping("/shift/createShiftIfItDoesentExist/{ShiftID}/{date}/{isFirst}")
    public void createShiftIfItDoesentExist(@PathVariable int ShiftID, @PathVariable Date date, @PathVariable boolean isFirst){
        shiftDao.createShiftIfItDoesentExist(ShiftID, date, isFirst);
    }

    @GetMapping("/shift/getShiftByDateAndIsFirst/{date}/{isFirst}")
    public Shift getShiftByDateAndIsFirst(@PathVariable Date date, @PathVariable boolean isFirst){
        return shiftDao.getShiftByDateAndIsFirst(date, isFirst);
    }

    @GetMapping("/shift/getFutureShiftsForUser/{userId}")
    public List<Shift> getFutureShiftsForUser(@PathVariable int userId){
        return shiftDao.getFutureShiftsForUser(userId);
    }

    @GetMapping("/shift/getPastShiftsForUser/{userId}")
    public List<Shift> getPastShiftsForUser(@PathVariable int userId){
        return shiftDao.getPastShiftsForUser(userId);
    }

    @GetMapping("/shift/getShiftByShiftID/{shiftId}")
    public Shift getShiftByShiftID(@PathVariable int shiftId){
        return shiftDao.getShiftByShiftID(shiftId);
    }
}