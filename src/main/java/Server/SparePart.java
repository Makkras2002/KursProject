package Server;

import javax.persistence.*;
import java.util.Objects;


@Entity()
@Table(name = "part_table")
public class SparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_id")
    private Integer part_id;

    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SparePart(String name, String category, String price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public SparePart(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparePart sparePart = (SparePart) o;
        return Objects.equals(name, sparePart.name) && Objects.equals(category, sparePart.category) && Objects.equals(price, sparePart.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "part_id=" + part_id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
