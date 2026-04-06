package OOP;

import java.util.Scanner;

/**
 * Class Main - User Interface & Menu
 * Project: Sistem Manajemen Inventori Toko
 * 
 * Konsep OOP yang diterapkan:
 * - Inheritance: Elektronik, Fashion, Makanan extends Barang
 * - Polymorphism: calculateSellingPrice() override per kategori
 * - Interface: Barang & Seller implements Reportable
 * - Encapsulation: private fields, public getter/setter
 * - Abstraction: abstract class Barang, abstract method
 * - Looping: for, for-each, do-while, nested loop
 */
public class Main {
    
    static Scanner input = new Scanner(System.in);
    static InventoryManager manager = new InventoryManager();
    static boolean running = true;

    public static void main(String[] args) {
        init();
        
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║      SELAMAT DATANG DI SISTEM INVENTORI TOKO ONLINE");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        // DO-WHILE LOOP untuk main menu
        do {
            displayMenu();
            int pilihan = getMenuInput();
            handleMenuChoice(pilihan);
        } while (running);

        System.out.println("\n✓ Terima kasih telah menggunakan sistem ini!");
        input.close();
    }

    // ==================== INITIALIZATION DATA ====================
    
    /**
     * Initialize dengan sample data
     */
    static void init() {
        // Buat seller
        Seller seller1 = new Seller("Toko Ahmad", "S001");
        seller1.setRating(4.5);
        
        Seller seller2 = new Seller("Toko Budi", "S002");
        seller2.setRating(4.8);

        // Tambah barang untuk seller1
        Barang elec1 = new Elektronik("Laptop Dell", 8000000);
        elec1.setStok(5);
        seller1.addBarang(elec1);

        Barang elec2 = new Elektronik("Monitor 24 inch", 2500000);
        elec2.setStok(12);
        seller1.addBarang(elec2);

        Barang fashion1 = new Fashion("Kaos Premium", 150000);
        fashion1.setStok(50);
        seller1.addBarang(fashion1);

        Barang food1 = new Makanan("Mie Instan", 3000);
        food1.setStok(200);
        seller1.addBarang(food1);

        // Tambah barang untuk seller2
        Barang elec3 = new Elektronik("Smartphone Samsung", 5000000);
        elec3.setStok(8);
        seller2.addBarang(elec3);

        Barang fashion2 = new Fashion("Sepatu Sport", 450000);
        fashion2.setStok(20);
        seller2.addBarang(fashion2);

        Barang food2 = new Makanan("Beras 5kg", 75000);
        food2.setStok(30);
        seller2.addBarang(food2);

        // Tambah seller ke manager
        manager.addSeller(seller1);
        manager.addSeller(seller2);

        System.out.println("\n✓ Data sample telah dimuat!");
    }

    // ==================== MENU DISPLAY ====================
    
    static void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        MAIN MENU");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println("1. Tampilkan Semua Barang");
        System.out.println("2. Cari Barang");
        System.out.println("3. Update Stok Barang");
        System.out.println("4. Tampilkan Laporan Nilai Inventori");
        System.out.println("5. Tampilkan Laporan Per Kategori");
        System.out.println("6. Tampilkan Daftar Seller");
        System.out.println("7. Kelola Seller");
        System.out.println("8. Tampilkan Ringkasan Inventory");
        System.out.println("9. Keluar");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
    }

    static int getMenuInput() {
        System.out.print("Pilih menu (1-9): ");
        try {
            return input.nextInt();
        } catch (Exception e) {
            input.nextLine();
            return -1;
        }
    }

    // ==================== MENU HANDLERS ====================
    
    static void handleMenuChoice(int pilihan) {
        switch (pilihan) {
            case 1:
                manager.displayAllBarang();
                break;
            case 2:
                cariBarang();
                break;
            case 3:
                updateStokBarang();
                break;
            case 4:
                manager.generateReport();
                break;
            case 5:
                manager.generateReportByCategory();
                break;
            case 6:
                manager.displayAllSellers();
                break;
            case 7:
                kelolaSellerMenu();
                break;
            case 8:
                System.out.println(manager.getReport());
                break;
            case 9:
                running = false;
                break;
            default:
                System.out.println("✗ Pilihan tidak valid!");
        }
    }

    // ==================== FITUR CARI BARANG ====================
    
    /**
     * Cari barang (DO-WHILE untuk repeat search)
     */
    static void cariBarang() {
        boolean cariLagi = true;
        
        // DO-WHILE LOOP untuk repeat search
        do {
            System.out.print("\nMasukkan nama barang yang dicari: ");
            input.nextLine();
            String nama = input.nextLine();

            Barang barang = manager.searchBarangGlobal(nama);
            if (barang != null) {
                System.out.println("\n✓ Barang ditemukan!");
                System.out.println("  Nama          : " + barang.getNama());
                System.out.println("  Harga Asli    : Rp " + String.format("%.2f", barang.getHarga()));
                System.out.println("  Diskon        : " + String.format("%.0f%%", barang.getDiskon() * 100));
                System.out.println("  Pajak         : " + String.format("%.0f%%", barang.getPajak() * 100));
                System.out.println("  Harga Jual    : Rp " + String.format("%.2f", barang.calculateSellingPrice()));
                System.out.println("  Stok          : " + barang.getStok() + " unit");
            } else {
                System.out.println("✗ Barang '" + nama + "' tidak ditemukan!");
            }

            System.out.print("\nCari barang lagi? (y/n): ");
            String jawab = input.nextLine().toLowerCase();
            cariLagi = jawab.equals("y");

        } while (cariLagi);
    }

    // ==================== FITUR UPDATE STOK ====================
    
    static void updateStokBarang() {
        System.out.print("\nMasukkan nama barang: ");
        input.nextLine();
        String nama = input.nextLine();

        System.out.print("Masukkan perubahan stok (+ untuk tambah, - untuk kurang): ");
        int qty;
        try {
            qty = input.nextInt();
        } catch (Exception e) {
            System.out.println("✗ Input tidak valid!");
            input.nextLine();
            return;
        }

        manager.updateStokGlobal(nama, qty);
    }

    // ==================== SUBMENU KELOLA SELLER ====================
    
    static void kelolaSellerMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   SUBMENU KELOLA SELLER");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println("1. Lihat Inventori Seller");
        System.out.println("2. Tambah Seller Baru");
        System.out.println("3. Tambah Barang ke Seller");
        System.out.println("4. Kembali ke Menu Utama");

        System.out.print("Pilih menu (1-4): ");
        int pilihan;
        try {
            pilihan = input.nextInt();
        } catch (Exception e) {
            input.nextLine();
            return;
        }

        input.nextLine();

        switch (pilihan) {
            case 1:
                lihatInventoriSeller();
                break;
            case 2:
                tambahSellerBaru();
                break;
            case 3:
                tambahBarangKeSeller();
                break;
            case 4:
                break;
            default:
                System.out.println("✗ Pilihan tidak valid!");
        }
    }

    static void lihatInventoriSeller() {
        System.out.print("Masukkan ID Seller: ");
        String id = input.nextLine();
        manager.displaySeller(id);
    }

    static void tambahSellerBaru() {
        System.out.print("Masukkan nama seller: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID seller: ");
        String id = input.nextLine();

        Seller seller = new Seller(nama, id);
        manager.addSeller(seller);
    }

    static void tambahBarangKeSeller() {
        System.out.print("Masukkan ID seller: ");
        String sellerID = input.nextLine();

        System.out.println("\nPilih kategori barang:");
        System.out.println("1. Elektronik");
        System.out.println("2. Fashion");
        System.out.println("3. Makanan");
        System.out.print("Pilih (1-3): ");
        
        int kategori;
        try {
            kategori = input.nextInt();
        } catch (Exception e) {
            input.nextLine();
            System.out.println("✗ Input tidak valid!");
            return;
        }

        input.nextLine();
        System.out.print("Masukkan nama barang: ");
        String nama = input.nextLine();
        System.out.print("Masukkan harga barang: ");
        double harga = input.nextDouble();
        System.out.print("Masukkan stok: ");
        int stok = input.nextInt();

        Barang barang = null;
        switch (kategori) {
            case 1:
                barang = new Elektronik(nama, harga);
                break;
            case 2:
                barang = new Fashion(nama, harga);
                break;
            case 3:
                barang = new Makanan(nama, harga);
                break;
            default:
                System.out.println("✗ Kategori tidak valid!");
                return;
        }

        barang.setStok(stok);
        manager.addBarangToSeller(sellerID, barang);
    }

}
