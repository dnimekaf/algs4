package models;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class Transaction implements Comparable<Transaction> {
    String name;
    LocalDate date;
    Double amount;

    public Transaction(String dataString) {
        if (dataString != null && dataString.isEmpty() == false) {
            String[] parts = dataString.split(" ");
            name = parts[0];
            date = LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("M/d/yyyy"));
            amount = Double.parseDouble(parts[2]);
        }
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", name, date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), amount);
    }

    @Override
    public int compareTo(Transaction o) {
        if (o == null) return -1;
        return amount.compareTo(o.amount);
    }
}
