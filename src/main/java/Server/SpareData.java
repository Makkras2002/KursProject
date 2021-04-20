package Server;

import javax.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "data_table")
public class SpareData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "data_id")
    private Integer data_id;

    @Column(name = "amount")
    private String amount;
    @Column(name = "buyer")
    private String buyer;
    @Column(name ="date")
    private String date;

    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private SparePart part;

    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Seller seller;


    public SpareData(){
    }

    public SpareData(SparePart part, String amount, Seller seller, String buyer, String date) {
        this.part = part;
        this.amount = amount;
        this.seller = seller;
        this.buyer = buyer;
        this.date = date;
    }

    public long getData_id() {
        return data_id;
    }

    public void setData_id(Integer data_id) {
        this.data_id = data_id;
    }

    public SparePart getPart() {
        return part;
    }

    public void setPart(SparePart part) {
        this.part = part;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpareData spareData = (SpareData) o;
        return Objects.equals(part, spareData.part) && Objects.equals(amount, spareData.amount) && Objects.equals(seller, spareData.seller) && Objects.equals(buyer, spareData.buyer) && Objects.equals(date, spareData.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(part, amount, seller, buyer, date);
    }

    @Override
    public String toString() {
        return "SpareData{" +
                "data_id=" + data_id +
                ", amount='" + amount + '\'' +
                ", buyer='" + buyer + '\'' +
                ", date='" + date + '\'' +
                ", part=" + part +
                ", seller=" + seller +
                '}';
    }
}
