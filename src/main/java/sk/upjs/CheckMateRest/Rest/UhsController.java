package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.*;
import sk.upjs.CheckMateRest.storage.dao.UhsDao;
import sk.upjs.CheckMateRest.storage.triedy.Uhs;

import java.util.List;

@RestController
public class UhsController {

    private final UhsDao uhsDao;

    public UhsController(UhsDao uhsDao){
        this.uhsDao = uhsDao;
    }

    @GetMapping("/uhs/createUhsIfDoesntExist/{userId}/{shiftId}")
    public void createUhsIfDoesntExist(@PathVariable int userId,  @PathVariable int shiftId){
        uhsDao.createUhsIfDoesntExist(userId, shiftId);
    }

    @GetMapping("/uhs/numberOfShiftsWorked/{userId}")
    public int numberOfShiftsWorked(@PathVariable int userId){
        return uhsDao.numberOfShiftsWorked(userId);
    }

    @GetMapping("/uhs/getUhsByShiftId/{shiftId}/{userId}")
    public Uhs getUhsByShiftId(@PathVariable int shiftId, @PathVariable int userId){
        return uhsDao.getUhsByShiftId(shiftId, userId);
    }

    @DeleteMapping("/uhs/deleteUhsByShiftIdAndUserId/{shiftId}/{userId}")
    public void deleteUhsByShiftIdAndUserId(@PathVariable int shiftId, @PathVariable int userId){
        uhsDao.deleteUhsByShiftIdAndUserId(shiftId, userId);
    }

    @GetMapping("/uhs/getAllUhs")
    public List<Uhs> getAllUhs(){
        return uhsDao.getAllUhs();
    }

    @PostMapping("/uhs/updateIsConfirmed/{userId}/{shiftId}/{isConfirmed}")
    public void updateIsConfirmed(@PathVariable int userId, @PathVariable int shiftId, @PathVariable boolean isConfirmed){
        uhsDao.updateIsConfirmed(userId, shiftId, isConfirmed);
    }
}
