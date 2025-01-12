public class cleanser extends ProductTask {
    private double phLevel;

    public cleanser(String namaProd, String brandProd, String kategoriProd, int price, int stok, double phLevel) {
        super(namaProd, brandProd, kategoriProd, price, stok);
        this.phLevel = phLevel;
    }

    public double getPhLevel() {
        return phLevel;
    }

    public void setPhLevel(double phLevel) {
        this.phLevel = phLevel;
    }
}
