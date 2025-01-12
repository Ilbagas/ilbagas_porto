public class Product {
    private String namaProd;
    private int price;
    private int stok;

    public Product(String namaProd, int price, int stok) {
        this.namaProd = namaProd;
        this.price = price;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNamaProd() {
        return namaProd;
    }

    public void setNamaProd(String namaProd) {
        this.namaProd = namaProd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void showInfo() {
        System.out.println("Product: " + namaProd + " | Price: " + price + " | Stock: " + stok);
    }
}
