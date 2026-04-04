package ECommerce;

import java.util.ArrayList;

import CLI.Actionable;
import CLI.AddCategory;
import CLI.AddProduct;
import CLI.Explore;

/**
 * KELAS TURUNAN (SUBCLASS): Seller
 * Fungsi: Merepresentasikan pengguna tipe Seller (penjual) dalam sistem e-commerce
 * 
 * Konsep OOP - INHERITANCE (Pewarisan):
 *   - Seller extends User: mewarisi semua atribut dan method dari User
 *   - Seller mewarisi: ID, firstName, lastName, email, password, phoneNumber, actions
 *   - Seller MENAMBAH atribut spesifik: SoldItemCount, profit, sellerComp, products, orders
 * 
 * Mengapa perlu di-inherit dari User?
 *   - Menghindari duplikasi kode (DRY principle)
 *   - Semua user (Client/Seller) memiliki data dasar yang sama (nama, email, password)
 *   - Seller adalah spesialisasi dari User dengan perilaku dan data bisnis yang berbeda
 * 
 * Konsep OOP - POLYMORPHISM:
 *   - actions ArrayList menyimpan berbagai Actionable items
 *   - Seller memiliki berbagai actions seperti Explore, AddCategory, AddProduct
 * 
 * Konsep OOP - KOMPOSISI:
 *   - Seller memiliki products (ArrayList<Product>): One-to-Many relationship
 *   - Seller memiliki orders (ArrayList<Order>): One-to-Many relationship
 */
public class Seller extends User {
    // ======================== ATRIBUT SPESIFIK SELLER ========================
    
    // ATRIBUT: Jumlah item yang telah terjual dari seller ini
    // Fungsi: Tracking statistik penjualan seller
    private int SoldItemCount;
    
    // ATRIBUT: Total keuntungan (profit) yang telah didapatkan seller
    // Fungsi: Tracking revenue/income seller
    private double profit;
    
    // ATRIBUT: Nama perusahaan atau nama seller yang ditampilkan
    // Fungsi: Identitas bisnis seller di marketplace
    private String sellerComp;
    
    // KOMPOSISI: Seller memiliki daftar produk yang dijual
    // Relasi: One Seller memiliki banyak Products (One-to-Many)
    // Fungsi: Menyimpan semua produk yang dijual oleh seller ini
    private ArrayList<Product> products;
    
    // KOMPOSISI: Seller memiliki daftar pesanan
    // Relasi: One Seller dapat menerima banyak Orders (One-to-Many)
    // Fungsi: Menyimpan semua pesanan yang diterima seller ini
    private ArrayList<Order> orders;

    // ======================== CONSTRUCTOR 1 (Default Constructor) ========================
    
    /**
     * CONSTRUCTOR: Inisialisasi Seller dengan nilai default
     * Fungsi: Membuat object Seller baru dengan state awal
     */
    public Seller() {
        // KOMPOSISI: Inisialisasi ArrayList untuk menyimpan Products
        // Seller dimulai dengan daftar produk kosong
        products = new ArrayList<Product>();
        
        // KOMPOSISI: Inisialisasi ArrayList untuk menyimpan Actionable items
        // actions dideklarasikan di User (parent class), tapi diinisialisasi di sini
        actions = new ArrayList<Actionable>();
        
        // POLYMORPHISM: Menambahkan Explore action
        // Seller juga bisa explore seperti Client
        actions.add(new Explore());
        
        // POLYMORPHISM: Menambahkan AddCategory action
        // Khusus Seller, dapat menambah kategori produk
        // AddCategory adalah implementasi Actionable yang berbeda dari Client
        actions.add(new AddCategory());
        
        // NOTE: AddProduct akan ditambahkan secara dinamis di CLI saat seller memilih category
    }

    // ======================== CONSTRUCTOR 2 (Parameterized Constructor) ========================
    
    /**
     * CONSTRUCTOR: Inisialisasi Seller dengan data lengkap
     * Parameter SoldItemCount: jumlah item yang sudah terjual
     * Parameter profit: total keuntungan
     * Parameter sellerComp: nama perusahaan seller
     * Parameter products: daftar produk seller
     * Parameter orders: daftar pesanan seller
     */
    public Seller(int SoldItemCount, double profit, String sellerComp, ArrayList<Product> products,
            ArrayList<Order> orders) {
        // KOMPOSISI: Menyimpan referensi ArrayList Orders yang diterima
        this.orders = orders;
        
        // ATRIBUT: Menyimpan jumlah item terjual
        this.SoldItemCount = SoldItemCount;
        
        // ATRIBUT: Menyimpan profit seller
        this.profit = profit;
        
        // ATRIBUT: Menyimpan nama perusahaan seller
        this.sellerComp = sellerComp;
        
        // KOMPOSISI: Menyimpan referensi ArrayList Products yang diterima
        this.products = products;
    }

    // ======================== GETTER METHODS ========================
    
    /**
     * GETTER: Mengambil jumlah item terjual
     * Return: int jumlah item yang sudah terjual
     */
    public int getSoldItemCount() {
        return SoldItemCount;  // Mengembalikan jumlah item terjual
    }

    /**
     * GETTER: Mengambil total profit seller
     * Return: double total keuntungan seller
     */
    public double getProfit() {
        return profit;  // Mengembalikan profit yang sudah diraih
    }

    /**
     * GETTER: Mengambil nama perusahaan seller
     * Return: String nama perusahaan/seller
     */
    public String getSellerComp() {
        return sellerComp;  // Mengembalikan nama perusahaan seller
    }

    /**
     * GETTER: Mengambil daftar produk seller
     * KOMPOSISI: Mengembalikan referensi ArrayList<Product>
     * Fungsi: Mengakses semua produk yang dijual seller ini
     * Return: ArrayList berisi Product objects
     */
    public ArrayList<Product> getProducts() {
        return products;  // Mengembalikan daftar produk seller
    }

    /**
     * GETTER: Mengambil daftar pesanan seller
     * KOMPOSISI: Mengembalikan referensi ArrayList<Order>
     * Fungsi: Mengakses semua pesanan yang diterima seller
     * Return: ArrayList berisi Order objects
     */
    public ArrayList<Order> getOrders() {
        return orders;  // Mengembalikan daftar pesanan seller
    }

    // ======================== SETTER METHODS ========================
    
    /**
     * SETTER: Mengubah jumlah item terjual
     * Parameter SoldItemCount: jumlah item baru
     */
    public void setSoldItemCount(int SoldItemCount) {
        this.SoldItemCount = SoldItemCount;  // Menyimpan jumlah item terjual baru
    }

    /**
     * SETTER: Mengubah profit seller
     * Parameter profit: profit baru
     */
    public void setProfit(double profit) {
        this.profit = profit;  // Menyimpan profit baru
    }

    /**
     * SETTER: Mengubah nama perusahaan seller
     * Parameter sellerComp: nama perusahaan baru
     */
    public void setSellerComp(String sellerComp) {
        this.sellerComp = sellerComp;  // Menyimpan nama perusahaan baru
    }

    /**
     * SETTER: Mengubah daftar produk seller
     * KOMPOSISI: Mengubah referensi ArrayList<Product>
     * Parameter products: ArrayList Product baru
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;  // Menyimpan referensi ArrayList Product baru
    }

    /**
     * SETTER: Mengubah daftar pesanan seller
     * KOMPOSISI: Mengubah referensi ArrayList<Order>
     * Parameter orders: ArrayList Order baru
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;  // Menyimpan referensi ArrayList Order baru
    }

}
