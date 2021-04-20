package CheckersAndEts;

public class CarcassForTabel {
    private Integer id;
    private String nameOfPart;
    private String category;
    private String price;
    private String sellerSirname;
    private String amount;
    private String sellerName;
    private String buyer;
    private String date;

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

    public String getSellerSirname() {
        return sellerSirname;
    }

    public void setSellerSirname(String sellerSirname) {
        this.sellerSirname = sellerSirname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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

    public CarcassForTabel(Integer id,String nameOfPart, String category, String price,String amount,String sellerSirname,
                           String sellerName, String buyer, String date) {
        this.id = id;
        this.nameOfPart = nameOfPart;
        this.category = category;
        this.price = price;
        this.sellerSirname = sellerSirname;
        this.amount = amount;
        this.sellerName = sellerName;
        this.buyer = buyer;
        this.date = date;
    }
    public CarcassForTabel(){
    }
}
