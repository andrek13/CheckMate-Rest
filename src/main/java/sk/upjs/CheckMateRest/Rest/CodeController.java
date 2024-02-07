package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.CheckMateRest.storage.dao.CodeDAO;

@RestController
public class CodeController {

    private final CodeDAO codeDAO;

    public CodeController(CodeDAO codeDAO){
        this.codeDAO = codeDAO;
    }

    @PostMapping("/code/addNewWorkerCode/{newCode}")
    public void addNewWorkerCode(@PathVariable String newCode){
        codeDAO.addNewWorkerCode(newCode);
    }

    @GetMapping("/code/disableWorkerCode/{worker_code}")
    public void disableWorkerCode(@PathVariable String worker_code){
        codeDAO.disableWorkerCode(worker_code);
    }

}
