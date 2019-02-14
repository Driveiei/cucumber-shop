package ku.shop;

public class Product {
    private double price;
    private String name;
    private int left;

    public Product(String name, double price, int left) {
        this.name = name;
        this.price = price;
        this.left = left;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getRemain() {return left;}

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }

    public void updateQuantity(int boughtQaunt){
        if(this.left - boughtQaunt >= 0){
            this.left -= boughtQaunt;
        }
        else System.out.printf("%s is not enough. %s remains %d left.", name, name, this.left);
    }
}