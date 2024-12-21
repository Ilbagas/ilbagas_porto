public class ProductTask {
    private String namaProd,brandProd,kategoriProd;
    private int stok;
    private int price;

    public ProductTask(String namaProd, String brandProd, String kategoriProd, int price, int stok){
        this.namaProd = namaProd;
        this.brandProd = brandProd;
        this.kategoriProd = kategoriProd;
        this.price = price;
        this.stok = stok;
    }
    public String getNamaProd() {
        return namaProd;
    }

    public String getBrandProd() {
        return brandProd;
    }

    public String getKategoriProd() {
        return kategoriProd;
    }

    public double getPrice() {
        return price;
    }

    public int getStok() {
        return stok;
    }
    public void setNamaProd(String namaProd) {
        this.namaProd = namaProd;
    }
    public void setBrandProd(String brandProd) {
        this.brandProd = brandProd;
    }
    public void setKategori(String kategori){
        this.kategoriProd = kategori;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
}
