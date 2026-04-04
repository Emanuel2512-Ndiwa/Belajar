package ECommerce;

import java.util.ArrayList;

/**
 * UTILITY KELAS: DataManager
 * Fungsi: Central data repository yang mengelola semua data collections dalam aplikasi
 * 
 * Konsep OOP - AGREGASI (Aggregation):
 *   - DataManager mengagregasi (bukan komposisi) ArrayList dari User, Category, Product, Order
 *   - Agregasi: Object dapat disimpan dan diakses melalui DataManager
 *   - Diferensi dari Komposisi: ArrayList dibuat di Main, bukan di DataManager
 *   - Lifetime: ArrayList memiliki lifetime independen dari DataManager
 * 
 * Arsitektur Pola (Design Pattern):
 *   - FACADE PATTERN: DataManager menyediakan interface tunggal untuk akses data
 *   - Semua akses data di aplikasi melalui DataManager, bukan direct access ke ArrayLists
 * 
 * Hubungan Dengan Kelas Lain:
 *   - NavigationHandler memiliki referensi DataManager
 *   - Semua CLI Actionables menerima DataManager sebagai parameter
 *   - Operasi CRUD (Create, Read, Update, Delete) dilakukan melalui DataManager
 * 
 * Data Management:
 *   - Belum ada persistensi (penyimpanan ke file/database)
 *   - Semua data disimpan dalam memory (RAM) selama program berjalan
 *   - Saat aplikasi ditutup, semua data hilang
 * 
 * Enkapsulasi:
 *   - Semua ArrayList adalah private
 *   - Akses melalui getter methods
 */
public class DataManager {
    // ======================== AGREGASI: Private Data Collections ========================
    
    // AGREGASI: ArrayList menyimpan semua User objects (Client dan Seller)
    // Relasi: One DataManager mengagregasi Many Users
    // CRUD Operations:
    //   - CREATE: SignUp.java menambahkan user baru ke sini
    //   - READ: Login.java membaca dari sini untuk verifikasi
    //   - UPDATE: User data bisa diupdate melalui setter
    //   - DELETE: Belum diimplementasi
    private ArrayList<User> user;
    
    // AGREGASI: ArrayList menyimpan semua Category objects
    // Relasi: One DataManager mengagregasi Many Categories
    // CRUD Operations:
    //   - CREATE: AddCategory.java menambahkan category baru ke sini
    //   - READ: Explore.java membaca dari sini untuk menampilkan categories
    //   - UPDATE: EditCategory.java bisa update category (belum sepenuhnya implemented)
    //   - DELETE: DeleteCategory.java menghapus category dari sini
    private ArrayList<Category> categories;
    
    // AGREGASI: ArrayList menyimpan semua Product objects
    // Relasi: One DataManager mengagregasi Many Products
    // CRUD Operations:
    //   - CREATE: AddProduct.java menambahkan product baru ke sini
    //   - READ: Explore.java membaca dari sini untuk menampilkan products
    //   - UPDATE: EditProduct.java bisa update product (belum sepenuhnya implemented)
    //   - DELETE: Belum diimplementasi
    private ArrayList<Product> products;
    
    // AGREGASI: ArrayList menyimpan semua Order objects
    // Relasi: One DataManager mengagregasi Many Orders
    // CRUD Operations:
    //   - CREATE: Checkout process menambahkan order baru ke sini
    //   - READ: ShowOrderDetails bisa membaca order (belum sepenuhnya implemented)
    //   - UPDATE: OrderStatus bisa diupdate
    //   - DELETE: Belum diimplementasi
    private ArrayList<Order> orders;

    // ======================== CONSTRUCTOR ========================
    
    /**
     * CONSTRUCTOR: Inisialisasi DataManager dengan ArrayList references
     * Fungsi: DataManager meneima referensi ke ArrayLists yang sudah dibuat di Main.java
     * 
     * Parameter users: ArrayList<User> yang sudah dibuat di Main
     * Parameter categories: ArrayList<Category> yang sudah dibuat di Main
     * Parameter products: ArrayList<Product> yang sudah dibuat di Main
     * Parameter orders: ArrayList<Order> yang sudah dibuat di Main
     * 
     * AGREGASI RELATIONSHIP:
     *   - DataManager tidak membuat ArrayLists, hanya menyimpan referensi
     *   - ArrayList dibuat di Main.java dan diteruskan ke DataManager
     *   - Ini adalah definisi Aggregation (bukan Composition)
     */
    public DataManager(ArrayList<User> users, ArrayList<Category> categories, ArrayList<Product> products,
            ArrayList<Order> orders) {
        // Menyimpan referensi ArrayList<User>
        this.user = users;
        
        // Menyimpan referensi ArrayList<Category>
        this.categories = categories;
        
        // Menyimpan referensi ArrayList<Product>
        this.products = products;
        
        // Menyimpan referensi ArrayList<Order>
        this.orders = orders;
    }

    // ======================== GETTER METHODS (Data Access/READ Operations) ========================
    
    /**
     * GETTER: Mengakses daftar semua Users
     * AGREGASI: Mengembalikan referensi ke ArrayList<User>
     * Fungsi: Digunakan untuk CRUD READ operations
     * 
     * Contoh Penggunaan:
     *   - Login.java: membaca user list untuk verifikasi email/password
     *   - SignUp.java: membaca untuk cek email yang sudah terdaftar
     *   - Explore.java: bisa untuk tracking user yang membuat action
     * 
     * Return: ArrayList<User> yang berisi 0 atau lebih User objects
     */
    public ArrayList<User> getUsers() {
        return user;  // Mengembalikan referensi ke ArrayList<User>
    }

    /**
     * GETTER: Mengakses daftar semua Categories
     * AGREGASI: Mengembalikan referensi ke ArrayList<Category>
     * Fungsi: Digunakan untuk CRUD READ operations
     * 
     * Contoh Penggunaan:
     *   - Explore.java: menampilkan semua categories kepada user
     *   - ShowCategoryProduct.java: menampilkan products dalam category tertentu
     *   - AddCategory.java dan DeleteCategory.java: modify category list
     * 
     * Return: ArrayList<Category> yang berisi 0 atau lebih Category objects
     */
    public ArrayList<Category> getCategories() {
        return categories;  // Mengembalikan referensi ke ArrayList<Category>
    }

    /**
     * GETTER: Mengakses daftar semua Products
     * AGREGASI: Mengembalikan referensi ke ArrayList<Product>
     * Fungsi: Digunakan untuk CRUD READ operations
     * 
     * Contoh Penggunaan:
     *   - Explore.java: menampilkan semua products kepada user
     *   - ShowCategoryProduct.java: filter products berdasarkan category
     *   - SearchProduct: cari products berdasarkan kriteria
     *   - Cart: menambah/mengurangi products dari keranjang
     * 
     * Return: ArrayList<Product> yang berisi 0 atau lebih Product objects
     */
    public ArrayList<Product> getProducts() {
        return products;  // Mengembalikan referensi ke ArrayList<Product>
    }

    /**
     * GETTER: Mengakses daftar semua Orders
     * AGREGASI: Mengembalikan referensi ke ArrayList<Order>
     * Fungsi: Digunakan untuk CRUD READ operations
     * 
     * CATATAN BUG: Method name typo - "geOrders" seharusnya "getOrders"
     * Harus diperbaiki untuk konsistensi naming convention
     * 
     * Contoh Penggunaan:
     *   - Checkout process: menambahkan order baru ke list
     *   - ShowOrderHistory: menampilkan orders dari user tertentu
     *   - OrderTracking: update status order
     * 
     * Return: ArrayList<Order> yang berisi 0 atau lebih Order objects
     */
    public ArrayList<Order> geOrders() {
        return orders;  // Mengembalikan referensi ke ArrayList<Order>
    }

    // ======================== NOTES ========================
    
    /**
     * DESIGN IMPROVEMENT:
     * Setter methods sebaiknya tidak ditambahkan untuk ArrayList
     * Jika perlu replace seluruh list, lebih baik gunakan:
     *   - getCategories().clear() untuk kosongkan
     *   - getCategories().addAll() untuk batch add
     * 
     * FUTURE ENHANCEMENT:
     * Tambahkan method utilities seperti:
     *   - User getUser(int id)
     *   - Product getProduct(int id)
     *   - Category getCategory(int id)
     *   - List<Product> getProductsByCategory(int categoryId)
     *   - List<Order> getOrdersByUser(int userId)
     */

}
