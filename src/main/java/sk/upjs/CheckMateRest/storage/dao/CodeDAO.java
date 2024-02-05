package sk.upjs.CheckMateRest.storage.dao;

public interface CodeDAO {



    void addNewWorkerCode(String newCode);

    void disableWorkerCode(String worker_code);
}
