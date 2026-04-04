package ECommerce;

import java.util.ArrayList;

import CLI.NavigationHandler;

/**
 * ENTRY POINT APLIKASI E-COMMERCE
 * Kelas Main adalah titik awal program ini.
 * Fungsi: Menginisialisasi data structures (ArrayLists) dan mengatur alur program awal
 */
public class Main {
    /**
     * METHOD MAIN
     * Fungsi: Metode utama yang menjalankan aplikasi saat program dimulai
     * Parameter args: argumen command line (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        // AGREGASI: ArrayList<User> adalah koleksi untuk menyimpan semua user (Clients & Sellers)
        // DataManager akan memegang referensi ke ArrayList ini dan mengelola akses data
        ArrayList<User> User = new ArrayList<User>();
        
        // AGREGASI: ArrayList<Category> menyimpan semua kategori produk
        // Objek Category di sini akan menampung daftar Product melalui komposisi
        ArrayList<Category> categories = new ArrayList<Category>();
        
        // AGREGASI: ArrayList<Product> menyimpan semua produk dalam sistem
        // Setiap Product memiliki referensi ke Category dan Seller melalui komposisi
        ArrayList<Product> products = new ArrayList<Product>();
        
        // AGREGASI: ArrayList<Order> menyimpan semua pesanan yang dibuat di sistem
        // Setiap Order memiliki referensi ke Client dan bisa memiliki multiple Products
        ArrayList<Order> orders = new ArrayList<Order>();
        
        // OBJECT CREATION & AGREGASI/KOMPOSISI
        // DataManager adalah central data repository yang mengagregasi semua data collections
        // Relasi: DataManager mengagregasi User, Category, Product, dan Order ArrayLists
        DataManager dataManager = new DataManager(User, categories, products, orders);
        
        // OBJECT CREATION
        // NavigationHandler berkomposisi dengan DataManager (memegang referensi ke dataManager)
        // Tungsi: Menangani navigasi menu CLI dan alur program
        NavigationHandler navigationHandlerv = new NavigationHandler(dataManager);
        
        // METHOD CALL
        // Menampilkan pesan sambutan ke pengguna
        navigationHandlerv.welome();
        
        // METHOD CALL
        // Menampilkan menu utama (Login, SignUp, Exit) 
        // Ini adalah awal dari interaksi user dengan aplikasi
        navigationHandlerv.init();
    }

}
