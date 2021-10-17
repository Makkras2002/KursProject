package Server;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "v2_data_table")
public class SpareData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "data_id")
    private Integer data_id;

    @Column(name = "amount")
    private String amount;
    @Column(name ="date")
    private String date;

    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private SparePart part;
    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @OneToOne(cascade=CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Seller seller;


    public SpareData(){
    }

    public SpareData(SparePart part,String amount,Seller seller,Buyer buyer,String date,Mark mark) {
        this.amount = amount;
        this.date = date;
        this.part = part;
        this.buyer = buyer;
        this.mark = mark;
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpareData spareData = (SpareData) o;
        return Objects.equals(amount, spareData.amount) && Objects.equals(date, spareData.date) && Objects.equals(part, spareData.part) && Objects.equals(buyer, spareData.buyer) && Objects.equals(mark, spareData.mark) && Objects.equals(seller, spareData.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date, part, buyer, mark, seller);
    }

    public Integer getData_id() {
        return data_id;
    }

    public void setData_id(Integer data_id) {
        this.data_id = data_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SparePart getPart() {
        return part;
    }

    public void setPart(SparePart part) {
        this.part = part;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpareData{");
        sb.append("data_id=").append(data_id);
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", part=").append(part);
        sb.append(", buyer=").append(buyer);
        sb.append(", mark=").append(mark);
        sb.append(", seller=").append(seller);
        sb.append('}');
        return sb.toString();
    }
}
