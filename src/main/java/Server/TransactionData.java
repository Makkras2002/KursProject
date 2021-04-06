package Server;

import java.util.Objects;

public class TransactionData {
    public String buyer;
    public String date;
    public TransactionData(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionData that = (TransactionData) o;
        return Objects.equals(date, that.date) && Objects.equals(buyer, that.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, buyer);
    }
}
