package Server;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "v2_buyer_table")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyer_id")
    private Integer buyer_id;
    @Column(name = "name")
    private String buyer_name;

    public Buyer(){}

    public Buyer(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(buyer_name, buyer.buyer_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer_name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Buyer{");
        sb.append("buyer_id=").append(buyer_id);
        sb.append(", buyer_name='").append(buyer_name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }
    public String getBuyer_name() {
        return buyer_name;
    }
    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }
}
