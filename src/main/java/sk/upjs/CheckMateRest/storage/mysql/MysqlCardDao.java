package sk.upjs.CheckMateRest.storage.mysql;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import sk.upjs.CheckMateRest.storage.EntityNotFoundException;
import sk.upjs.CheckMateRest.storage.dao.CardDao;
import sk.upjs.CheckMateRest.storage.triedy.Card;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class MysqlCardDao implements CardDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlCardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Card> cardRM() {
        return (rs, rowNum) -> {
            int id = rs.getInt("id");
            String cardNumber = rs.getString("cardNumber");
            int cvv = rs.getInt("cvv");
            int date = rs.getInt("date");
            return new Card(id, cardNumber, cvv, date);
        };
    }

    @Override
    public Card getCardById(int id) throws EntityNotFoundException {
        String sql = "SELECT * FROM card WHERE id = ?";
        List<Card> cards = jdbcTemplate.query(sql, cardRM(), id);
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(0);
    }

    @Override
    public int saveCard(Card card) throws EntityNotFoundException {
        String query = "INSERT INTO card (cardNumber, cvv, date) VALUES (?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((PreparedStatementCreator) con -> {
            PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, card.getCardNumber());
            statement.setInt(2, card.getCvv());
            statement.setInt(3, card.getDate());
            return statement;
        }, keyHolder);

        // Retrieve the generated key
        Number key = keyHolder.getKey();
        if (key == null) {
            throw new EntityNotFoundException("Failed to retrieve generated key");
        }

        // The key could be a Long or an Integer, depending on the database
        // Convert it to an int, assuming it's an Integer for simplicity
        return key.intValue();
    }
//    @Override
//    public Card getCardByUserId(int id) throws EntityNotFoundException {
//        String sql = "SELECT * FROM card WHERE id = ?";
//        List<Card> cards = jdbcTemplate.query(sql, cardRM(), id);
//        if (cards.isEmpty()) {
//            return null;
//        }
//        return cards.get(0);
//    }
}
