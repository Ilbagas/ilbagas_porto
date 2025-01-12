public class sunscreen extends ProductTask {
    private int spf;

    public sunscreen(String namaProd, String brandProd, String kategoriProd, int price, int stok, int spf) {
        super(namaProd, brandProd, kategoriProd, price, stok);
        this.spf = spf;
    }

    public int getSpf() {
        return spf;
    }

    public void setSpf(int spf) {
        this.spf = spf;
    }
}
