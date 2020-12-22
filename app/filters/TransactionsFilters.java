package filters;

import models.Transaction;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class TransactionsFilters {

    public static Predicate<Transaction> byDate(String to, String from) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Timestamp start = new Timestamp(dateFormat.parse(to).getTime());
        Timestamp end = new Timestamp(dateFormat.parse(from).getTime());
        return (transaction) -> {
            return transaction.getCreatedDate().after(start) && transaction.getCreatedDate().before(end);
        };
    }
}
