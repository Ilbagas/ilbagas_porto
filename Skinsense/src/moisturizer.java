public class moisturizer extends ProductTask {
    private String hydrationLevel;

    public moisturizer(String namaProd, String brandProd, String kategoriProd, int price, int stok, String hydrationLevel) {
        super(namaProd, brandProd, kategoriProd, price, stok);
        this.hydrationLevel = hydrationLevel;
    }

    public String getHydrationLevel() {
        return hydrationLevel;
    }

    public void setHydrationLevel(String hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }
}
