package Server;

import java.util.Objects;


public class SparePartSaleData extends TransactionData{
    private Integer id;
    private String nameOfPart;
    private String category;
    private String price;
    private String amount;
    private String sellerSirname;
    private String sellerName;

    public SparePartSaleData(){}

    public SparePartSaleData(String nameOfPart, String category,
                             String price, String amount,
                             String sellerSirname,
                             String sellerName,String buyer,String date) {
        this.nameOfPart = nameOfPart;
        this.category = category;
        this.price = price;
        this.amount = amount;
        this.sellerSirname = sellerSirname;
        this.sellerName = sellerName;
        this.buyer = buyer;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfPart() {
        return nameOfPart;
    }

    public void setNameOfPart(String nameOfPart) {
        this.nameOfPart = nameOfPart;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSellerSirname() {
        return sellerSirname;
    }

    public void setSellerSirname(String sellerSirname) {
        this.sellerSirname = sellerSirname;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SparePartSaleData that = (SparePartSaleData) o;
        return Objects.equals(id, that.id) && Objects.equals(nameOfPart, that.nameOfPart) && Objects.equals(category, that.category) && Objects.equals(price, that.price) && Objects.equals(amount, that.amount) && Objects.equals(sellerSirname, that.sellerSirname) && Objects.equals(sellerName, that.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nameOfPart, category, price, amount, sellerSirname, sellerName);
    }

    @Override
    public String toString() {
        return "SparePartSaleData{" +
                "id=" + id +
                ", nameOfPart='" + nameOfPart + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", sellerSirname='" + sellerSirname + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", buyer='" + buyer + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
