package ECommerce;

import java.util.ArrayList;

import CLI.Actionable;
import CLI.Explore;

/**
 * KELAS TURUNAN (SUBCLASS): Client
 * Fungsi: Merepresentasikan pengguna tipe Client (pembeli) dalam sistem e-commerce
 * 
 * Konsep OOP - INHERITANCE (Pewarisan):
 *   - Client extends User: mewarisi semua atribut dan method dari User
 *   - Client mewarisi: ID, firstName, lastName, email, password, phoneNumber, actions
 *   - Client MENAMBAH atribut spesifik: previousOrder, cart, adres, paymentDetails
 * 
 * Mengapa perlu di-inherit dari User?
 *   - Menghindari duplikasi kode (DRY principle)
 *   - Semua user (Client/Seller) memiliki data dasar yang sama (nama, email, password)
 *   - Client dan Seller adalah spesialisasi dari User dengan perilaku berbeda
 * 
 * Konsep OOP - POLYMORPHISM:
 *   - actions ArrayList menyimpan berbagai Actionable items
 *   - Client menambahkan Explore action via polymorphism
 * 
 * Konsep OOP - KOMPOSISI:
 *   - Client memiliki previousOrder (ArrayList<Order>): Many-to-Many relationship
 *   - Client memiliki cart (Cart object): One-to-One relationship
 *   - Client memiliki adres dan paymentDetails: untuk checkout
 */
public class Client extends User {
    // ======================== ATRIBUT SPESIFIK CLIENT ========================
    
    // KOMPOSISI: Client memiliki daftar pesanan sebelumnya
    // Relasi: One Client dapat memiliki banyak Orders (One-to-Many)
    // Fungsi: Menyimpan history pembelian client
    private ArrayList<Order> previousOrder;
    
    // KOMPOSISI: Client memiliki satu Cart untuk menyimpan produk yang akan dibeli
    // Relasi: One Client dengan One Cart (One-to-One composition)
    // Fungsi: Menyimpan produk yang dipilih sebelum checkout
    private Cart cart;
    
    // ATRIBUT: Alamat pengiriman client
    private String adres;
    
    // ATRIBUT: Detail pembayaran client (nomor kartu, e-wallet, dll)
    private String paymentDetails;

    // ======================== CONSTRUCTOR 1 (Default Constructor) ========================
    
    /**
     * CONSTRUCTOR: Inisialisasi Client dengan nilai default
     * Fungsi: Membuat object Client baru dengan state awal
     */
    public Client() {
        // KOMPOSISI: Inisialisasi ArrayList untuk menyimpan Order
        previousOrder = new ArrayList<Order>();
        
        // KOMPOSISI: Inisialisasi ArrayList untuk menyimpan Actionable items
        // actions dideklarasikan di User (parent class), tapi diinisialisasi di sini
        actions = new ArrayList<Actionable>();
        
        // POLYMORPHISM: Menambahkan Explore action ke dalam actions Client
        // Explore adalah implementasi dari interface Actionable
        // Ini berarti Client bisa melakukan aksi "Explore" (melihat produk)
        actions.add(new Explore());
    }

    // ======================== CONSTRUCTOR 2 (Parameterized Constructor) ========================
    
    /**
     * CONSTRUCTOR: Inisialisasi Client dengan data lengkap
     * Parameter previousOrder: daftar pesanan sebelumnya
     * Parameter cart: cart yang sudah ada
     * Parameter adres: alamat pengiriman
     * Parameter paymentDetails: detail pembayaran
     */
    public Client(ArrayList<Order> previousOrder, Cart cart, String adres, String paymentDetails) {
        // KOMPOSISI: Menyimpan referensi object Order dan Cart yang diterima
        this.previousOrder = previousOrder;
        this.cart = cart;
        this.adres = adres;
        this.paymentDetails = paymentDetails;
    }

    // ======================== GETTER METHODS ========================
    
    /**
     * GETTER: Mengambil daftar pesanan sebelumnya
     * KOMPOSISI: Mengembalikan referensi ke ArrayList<Order>
     * Fungsi: Mengakses history pembelian client
     * Return: ArrayList berisi Order objects
     */
    public ArrayList<Order> getPreviousOrder() {
        return previousOrder;  // Mengembalikan daftar pesanan sebelumnya
    }

    /**
     * GETTER: Mengambil cart client
     * KOMPOSISI: Mengembalikan referensi Cart object
     * Fungsi: Mengakses keranjang belanja active client
     * Return: Cart object
     */
    public Cart getCart() {
        return cart;  // Mengembalikan cart yang sedang digunakan
    }

    /**
     * GETTER: Mengambil alamat client
     * Return: String alamat pengiriman
     */
    public String getAdres() {
        return adres;  // Mengembalikan alamat yang tersimpan
    }

    /**
     * GETTER: Mengambil detail pembayaran
     * Return: String berisi informasi pembayaran
     */
    public String getPaymentDetails() {
        return paymentDetails;  // Mengembalikan detail pembayaran
    }

    // ======================== SETTER METHODS ========================
    
    /**
     * SETTER: Mengubah daftar pesanan sebelumnya
     * KOMPOSISI: Mengubah referensi ke ArrayList<Order>
     * Parameter previousOrder: ArrayList Order baru
     */
    public void setPreviousOrder(ArrayList<Order> previousOrder) {
        this.previousOrder = previousOrder;  // Menyimpan referensi ArrayList Order baru
    }

    /**
     * SETTER: Mengubah cart client
     * KOMPOSISI: Mengubah referensi Cart object
     * Parameter cart: Cart object baru
     */
    public void setCart(Cart cart) {
        this.cart = cart;  // Menyimpan referensi Cart baru
    }

    /**
     * SETTER: Mengubah alamat client
     * Parameter adres: Alamat pengiriman baru
     */
    public void setAdres(String adres) {
        this.adres = adres;  // Menyimpan alamat baru
    }

    /**
     * SETTER: Mengubah detail pembayaran
     * Parameter paymentDetails: Detail pembayaran baru
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;  // Menyimpan detail pembayaran baru
    }

}
