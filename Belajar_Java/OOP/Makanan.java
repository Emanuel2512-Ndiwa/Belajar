package OOP;

/**
 * Makanan Category:
 * - Discount: 5%
 * - Tax: 5%
 */
public class Makanan extends Barang {
    
    public static final double DISKON_RATE = 0.05;  // 5%
    public static final double TAX_RATE = 0.05;     // 5%

    public Makanan(String nama, double harga) {
        super(nama, harga);
        setDiskon(DISKON_RATE);
        setPajak(TAX_RATE);
    }

    /**
     * Calculate selling price for Makanan
     * Formula: (harga - (harga × 5%)) + 5%
     */
    @Override
    public double calculateSellingPrice() {
        double hargaSetelahDiskon = getHarga() - (getHarga() * DISKON_RATE);
        double hargaWithTax = hargaSetelahDiskon + (hargaSetelahDiskon * TAX_RATE);
        return hargaWithTax;
    }

}
