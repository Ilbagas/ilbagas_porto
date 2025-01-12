public class ProductTask extends Product {
    private String brandProd;
    private String kategoriProd;

    // Konstruktor default (untuk kompatibilitas dengan kode lain)
    public ProductTask() {
        super("", 0, 0);  // Memanggil konstruktor Product dengan nilai default
        this.brandProd = "";
        this.kategoriProd = "";
    }

    // Konstruktor dengan parameter
    public ProductTask(String namaProd, String brandProd, String kategoriProd, int price, int stok) {
        super(namaProd, price, stok);  // Memanggil konstruktor Product
        this.brandProd = brandProd;
        this.kategoriProd = kategoriProd;
    }

    public String getBrandProd() {
        return brandProd;
    }

    public void setBrandProd(String brandProd) {
        this.brandProd = brandProd;
    }

    public String getKategoriProd() {
        return kategoriProd;
    }

    public void setKategoriProd(String kategoriProd) {
        this.kategoriProd = kategoriProd;
    }
}
