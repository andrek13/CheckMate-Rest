package sk.upjs.CheckMateRest.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.dao.CardDao;
import sk.upjs.CheckMateRest.storage.triedy.Card;

@RestController
public class CardController {

    private final CardDao cardDao;

    public CardController(CardDao cardDao){
        this.cardDao = cardDao;
    }

    @GetMapping("/card/getCardById/{id}")
    public Card getCardById(@PathVariable int id) throws EntityNotFoundException {
        return cardDao.getCardById(id);
    }

    @PostMapping("/card/saveCard/{card}")
    public int saveCard(@PathVariable Card card) throws EntityNotFoundException {
        int result = cardDao.saveCard(card);
        return result;
    }
}
