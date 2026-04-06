package OOP;

import java.util.ArrayList;

/**
 * Class InventoryManager
 * Mengelola inventori dari semua seller
 * Menerapkan: Polymorphism, Interface, Looping, Encapsulation
 */
public class InventoryManager implements Reportable {
    
    private ArrayList<Seller> sellers;

    // ==================== CONSTRUCTOR ====================
    
    public InventoryManager() {
        this.sellers = new ArrayList<>();
    }

    // ==================== SELLER MANAGEMENT ====================
    
    /**
     * Tambah seller baru
     */
    public void addSeller(Seller seller) {
        if (seller != null && !isSellersExists(seller.getID())) {
            sellers.add(seller);
            System.out.println("✓ Seller '" + seller.getNama() + "' berhasil ditambahkan");
        } else if (isSellersExists(seller.getID())) {
            System.out.println("✗ Seller dengan ID '" + seller.getID() + "' sudah ada!");
        }
    }

    /**
     * Cek apakah seller sudah ada by ID
     */
    private boolean isSellersExists(String id) {
        for (Seller s : sellers) {
            if (s.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cari seller by ID
     */
    public Seller searchSeller(String id) {
        for (Seller s : sellers) {
            if (s.getID().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // ==================== BARANG MANAGEMENT ====================
    
    /**
     * Tambah barang untuk seller tertentu
     */
    public boolean addBarangToSeller(String sellerID, Barang barang) {
        Seller seller = searchSeller(sellerID);
        if (seller != null) {
            seller.addBarang(barang);
            return true;
        }
        System.out.println("✗ Seller dengan ID '" + sellerID + "' tidak ditemukan");
        return false;
    }

    /**
     * Cari barang di semua seller
     */
    public Barang searchBarangGlobal(String namaBarang) {
        // FOR-EACH LOOP → iterate semua seller
        for (Seller seller : sellers) {
            Barang barang = seller.searchBarang(namaBarang);
            if (barang != null) {
                return barang;
            }
        }
        return null;
    }

    /**
     * Update stok barang (cari di mana saja)
     */
    public boolean updateStokGlobal(String namaBarang, int qty) {
        // FOR-EACH LOOP dengan condition
        for (Seller seller : sellers) {
            if (seller.updateStok(namaBarang, qty)) {
                return true;
            }
        }
        System.out.println("✗ Barang '" + namaBarang + "' tidak ditemukan di semua seller");
        return false;
    }

    // ==================== DISPLAY METHODS ====================
    
    /**
     * Tampilkan semua barang dari semua seller
     */
    public void displayAllBarang() {
        if (sellers.isEmpty()) {
            System.out.println("Tidak ada seller terdaftar");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         DAFTAR SEMUA BARANG - SEMUA SELLER");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        int no = 1;
        
        // NESTED LOOP: FOR dengan index (seller) + FOR-EACH (barang)
        for (int i = 0; i < sellers.size(); i++) {
            Seller seller = sellers.get(i);
            System.out.println("\n[" + (i + 1) + "] Seller: " + seller.getNama() + " (Rating: " + 
                             String.format("%.1f", seller.getRating()) + "/5.0)");
            System.out.println("─".repeat(68));

            ArrayList<Barang> inventori = seller.getInventori();
            
            if (inventori.isEmpty()) {
                System.out.println("   Inventori kosong");
                continue;
            }

            // FOR-EACH LOOP untuk iterate barang (Polymorphism!)
            for (Barang barang : inventori) {
                System.out.printf("    %d. %s | Harga Asli: Rp %.2f | Harga Jual: Rp %.2f | Stok: %d\n",
                        no,
                        barang.getNama(),
                        barang.getHarga(),
                        barang.calculateSellingPrice(),  // POLYMORPHISM!
                        barang.getStok());
                no++;
            }
        }
    }

    /**
     * Tampilkan seller tertentu
     */
    public void displaySeller(String sellerID) {
        Seller seller = searchSeller(sellerID);
        if (seller != null) {
            seller.displayAllBarang();
        } else {
            System.out.println("✗ Seller tidak ditemukan");
        }
    }

    // ==================== REPORT METHODS ====================
    
    /**
     * Laporan nilai inventori total
     */
    public void generateReport() {
        if (sellers.isEmpty()) {
            System.out.println("Tidak ada seller terdaftar");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║           LAPORAN NILAI INVENTORI TOTAL");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        double totalNilai = 0;
        
        // FOR LOOP dengan index untuk numbering
        for (int i = 0; i < sellers.size(); i++) {
            Seller seller = sellers.get(i);
            double nilaiSeller = seller.getTotalNilaiInventori();
            totalNilai += nilaiSeller;
            
            System.out.printf("[%d] Seller: %-20s | Nilai: Rp %,15.2f | Total Barang: %d unit\n",
                    i + 1,
                    seller.getNama(),
                    nilaiSeller,
                    seller.getTotalBarang());
        }

        System.out.println("─".repeat(68));
        System.out.printf("TOTAL NILAI INVENTORI SELURUH SELLER: Rp %,15.2f\n", totalNilai);
    }

    /**
     * Laporan per kategori (NESTED LOOP)
     */
    public void generateReportByCategory() {
        if (sellers.isEmpty()) {
            System.out.println("Tidak ada seller terdaftar");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║      LAPORAN NILAI INVENTORI BERDASARKAN KATEGORI");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        // NESTED LOOP untuk setiap kategori
        for (kategory kat : kategory.values()) {
            double totalNilaiKategori = 0;
            int totalBarangKategori = 0;
            int jumlahBarang = 0;

            System.out.println("\n📦 KATEGORI: " + kat.toString().toUpperCase());
            System.out.println("─".repeat(68));

            // Loop semua seller, kemudian semua barang mereka
            for (Seller seller : sellers) {
                for (Barang barang : seller.getInventori()) {
                    // Cek kategori barang
                    if ((kat == kategory.Elektronik && barang instanceof Elektronik) ||
                        (kat == kategory.Fashion && barang instanceof Fashion) ||
                        (kat == kategory.Makanan && barang instanceof Makanan)) {
                        
                        double nilaiBarang = barang.calculateSellingPrice() * barang.getStok();
                        totalNilaiKategori += nilaiBarang;
                        totalBarangKategori += barang.getStok();
                        jumlahBarang++;

                        System.out.printf("  %-25s (Seller: %-15s) | Rp %,15.2f\n",
                                barang.getNama(),
                                seller.getNama(),
                                nilaiBarang);
                    }
                }
            }

            if (jumlahBarang > 0) {
                System.out.println("─".repeat(68));
                System.out.printf("  Total Barang: %d | Total Nilai: Rp %,15.2f\n", 
                        totalBarangKategori, totalNilaiKategori);
            } else {
                System.out.println("  (Tidak ada barang dalam kategori ini)");
            }
        }
    }

    /**
     * Tampilkan daftar seller
     */
    public void displayAllSellers() {
        if (sellers.isEmpty()) {
            System.out.println("Tidak ada seller terdaftar");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   DAFTAR SELLER");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        // FOR LOOP dengan index
        for (int i = 0; i < sellers.size(); i++) {
            Seller seller = sellers.get(i);
            System.out.printf("[%d] ID: %-10s | Nama: %-20s | Rating: %.1f/5.0 | Total Barang: %d\n",
                    i + 1,
                    seller.getID(),
                    seller.getNama(),
                    seller.getRating(),
                    seller.getTotalBarang());
        }
    }

    // ==================== INTERFACE IMPLEMENTATION ====================
    
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n╔════════════════════════════════════════════════════════════════════╗\n");
        report.append("║          LAPORAN INVENTORY MANAGER\n");
        report.append("╚════════════════════════════════════════════════════════════════════╝\n");
        report.append("Total Seller : ").append(sellers.size()).append("\n");
        
        double totalNilai = 0;
        int totalBarang = 0;
        for (Seller s : sellers) {
            totalNilai += s.getTotalNilaiInventori();
            totalBarang += s.getTotalBarang();
        }
        
        report.append("Total Barang : ").append(totalBarang).append(" unit\n");
        report.append("Nilai Total  : Rp ").append(String.format("%.2f", totalNilai)).append("\n");
        return report.toString();
    }

}
