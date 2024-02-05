package sk.upjs.CheckMateRest.storage.dao;



import sk.upjs.CheckMateRest.storage.triedy.Shift;

import java.util.Date;
import java.util.List;

public interface ShiftDao {

    void createShiftIfItDoesentExist(int ShiftID, Date date, boolean isFirst);
    Shift getShiftByDateAndIsFirst(Date date, boolean isFirst);

    List<Shift> getFutureShiftsForUser(int userId);

    List<Shift> getPastShiftsForUser(int userId);

    Shift getShiftByShiftID(int shiftId);
}
