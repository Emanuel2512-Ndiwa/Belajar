package OOP;

/**
 * Elektronik Category:
 * - Discount: 15%
 * - Tax: 10%
 */
public class Elektronik extends Barang {
    
    public static final double DISKON_RATE = 0.15;  // 15%
    public static final double TAX_RATE = 0.10;     // 10%

    public Elektronik(String nama, double harga) {
        super(nama, harga);
        setDiskon(DISKON_RATE);
        setPajak(TAX_RATE);
    }

    /**
     * Calculate selling price for Elektronik
     * Formula: (harga - (harga × 15%)) + 10%
     */
    @Override
    public double calculateSellingPrice() {
        double hargaSetelahDiskon = getHarga() - (getHarga() * DISKON_RATE);
        double hargaWithTax = hargaSetelahDiskon + (hargaSetelahDiskon * TAX_RATE);
        return hargaWithTax;
    }

}
