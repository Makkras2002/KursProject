package Server;

import javax.persistence.*;
import java.util.Objects;


@Entity()
@Table(name = "seller_table")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private Integer seller_id;

    @Column(name = "sirname")
    private String sirname;
    @Column(name = "name")
    private String name;

    public Seller(String sirname, String name) {
        this.sirname = sirname;
        this.name = name;
    }
    public Seller(){
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(sirname, seller.sirname) && Objects.equals(name, seller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sirname, name);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "seller_id=" + seller_id +
                ", sirname='" + sirname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
