package OOP;

/**
 * Fashion Category:
 * - Discount: 20%
 * - Tax: 8%
 */
public class Fashion extends Barang {
    
    public static final double DISKON_RATE = 0.20;  // 20%
    public static final double TAX_RATE = 0.08;     // 8%

    public Fashion(String nama, double harga) {
        super(nama, harga);
        setDiskon(DISKON_RATE);
        setPajak(TAX_RATE);
    }

    /**
     * Calculate selling price for Fashion
     * Formula: (harga - (harga × 20%)) + 8%
     */
    @Override
    public double calculateSellingPrice() {
        double hargaSetelahDiskon = getHarga() - (getHarga() * DISKON_RATE);
        double hargaWithTax = hargaSetelahDiskon + (hargaSetelahDiskon * TAX_RATE);
        return hargaWithTax;
    }

}
