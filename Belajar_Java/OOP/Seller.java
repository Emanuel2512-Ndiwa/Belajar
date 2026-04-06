package OOP;

import java.util.ArrayList;

/**
 * Class Seller
 * Menyimpan informasi penjual dan inventori barangnya
 */
public class Seller implements Reportable {
    
    private String nama;
    private String id;
    private double rating;
    private ArrayList<Barang> inventori;

    // ==================== CONSTRUCTOR ====================
    
    public Seller(String nama, String id) {
        this.nama = nama;
        this.id = id;
        this.rating = 0.0;
        this.inventori = new ArrayList<>();
    }

    // ==================== GETTER & SETTER ====================
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getID() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public ArrayList<Barang> getInventori() {
        return inventori;
    }

    // ==================== INVENTORY MANAGEMENT METHODS ====================
    
    /**
     * Tambah barang ke inventori
     */
    public void addBarang(Barang barang) {
        if (barang != null) {
            inventori.add(barang);
            System.out.println("✓ Barang '" + barang.getNama() + "' berhasil ditambahkan");
        }
    }

    /**
     * Hapus barang dari inventori by nama
     */
    public boolean removeBarang(String namaBarang) {
        for (int i = 0; i < inventori.size(); i++) {
            if (inventori.get(i).getNama().equalsIgnoreCase(namaBarang)) {
                System.out.println("✓ Barang '" + inventori.get(i).getNama() + "' berhasil dihapus");
                inventori.remove(i);
                return true;
            }
        }
        System.out.println("✗ Barang tidak ditemukan");
        return false;
    }

    /**
     * Cari barang by nama (case-insensitive)
     */
    public Barang searchBarang(String namaBarang) {
        for (Barang b : inventori) {
            if (b.getNama().equalsIgnoreCase(namaBarang)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Update stok barang by nama
     */
    public boolean updateStok(String namaBarang, int qty) {
        Barang barang = searchBarang(namaBarang);
        if (barang != null) {
            int stokBaru = barang.getStok() + qty;
            if (stokBaru >= 0) {
                barang.setStok(stokBaru);
                System.out.println("✓ Stok barang '" + namaBarang + "' diperbarui menjadi " + stokBaru);
                return true;
            } else {
                System.out.println("✗ Stok tidak boleh negatif!");
                return false;
            }
        }
        System.out.println("✗ Barang tidak ditemukan");
        return false;
    }

    /**
     * Hitung total nilai inventori (sum dari semua barang × stok)
     */
    public double getTotalNilaiInventori() {
        double total = 0;
        for (Barang b : inventori) {
            total += b.calculateSellingPrice() * b.getStok();
        }
        return total;
    }

    /**
     * Hitung jumlah barang di inventori
     */
    public int getTotalBarang() {
        int total = 0;
        for (Barang b : inventori) {
            total += b.getStok();
        }
        return total;
    }

    // ==================== INTERFACE IMPLEMENTATION ====================
    
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n╔════════════════════════════════════════╗\n");
        report.append("║        LAPORAN SELLER\n");
        report.append("╚════════════════════════════════════════╝\n");
        report.append("Nama Seller  : ").append(nama).append("\n");
        report.append("ID           : ").append(id).append("\n");
        report.append("Rating       : ").append(String.format("%.1f/5.0", rating)).append("\n");
        report.append("Total Barang : ").append(getTotalBarang()).append(" unit\n");
        report.append("Nilai Inv.   : Rp ").append(String.format("%.2f", getTotalNilaiInventori())).append("\n");
        return report.toString();
    }

    // ==================== DISPLAY METHOD ====================
    
    /**
     * Tampilkan semua barang di inventori (dengan looping)
     */
    public void displayAllBarang() {
        if (inventori.isEmpty()) {
            System.out.println("Inventori kosong!");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  INVENTORI - " + nama);
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        // FOR LOOP dengan index (looping dengan numbering)
        for (int i = 0; i < inventori.size(); i++) {
            Barang barang = inventori.get(i);
            System.out.printf("%d. %s (%.2f %%) | Rp %.2f | Stok: %d | Total: Rp %.2f\n",
                    i + 1,
                    barang.getNama(),
                    barang.getDiskon() * 100,
                    barang.calculateSellingPrice(),
                    barang.getStok(),
                    barang.calculateSellingPrice() * barang.getStok());
        }
    }

}
