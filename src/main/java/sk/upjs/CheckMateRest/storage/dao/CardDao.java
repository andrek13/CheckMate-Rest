package sk.upjs.CheckMateRest.storage.dao;


import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.triedy.Card;

public interface CardDao {
    Card getCardById(int id) throws EntityNotFoundException;

    int saveCard(Card card) throws EntityNotFoundException;

 //   Card getCardByUserId(int userId) throws EntityNotFoundException;
}
