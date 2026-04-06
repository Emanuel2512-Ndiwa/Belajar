package OOP;

public abstract class Barang  {

    private String nama;
    private double harga;
    private double diskon;
    private double pajak;
    private int stok;

    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.stok = 0;
    }

    // ==================== GETTER & SETTER ====================
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        }
    }

    public double getHarga() {
        return harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getPajak() {
        return pajak;
    }

    public void setPajak(double pajak) {
        this.pajak = pajak;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    // ==================== ABSTRACT METHOD ====================
    
    /**
     * Calculate selling price after discount and tax
     * Formula: (harga - (harga * diskon)) + pajak
     */
    public abstract double calculateSellingPrice();

    // ==================== ADDITIONAL METHODS ====================
    
    /**
     * Display info barang
     */
    public String displayInfo() {
        return String.format("Nama: %s | Harga: Rp %.2f | Stok: %d | Harga Jual: Rp %.2f",
                nama, harga, stok, calculateSellingPrice());
    }

}
