package ECommerce;

import java.util.ArrayList;

/**
 * DOMAIN MODEL KELAS: Category
 * Fungsi: Merepresentasikan kategori/klasifikasi produk dalam sistem e-commerce
 * 
 * Konsep OOP - KOMPOSISI:
 *   - Category memiliki ArrayList<Product> (COMPOSITION)
 *   - Relasi: One Category mengandung banyak Products (One-to-Many)
 *   - Relasi bi-directional: Category -> ArrayList<Product> dan Product -> Category
 * 
 * Hubungan Antar Kelas:
 *   - DataManager mengagregasi ArrayList<Category>
 *   - Category mengagregasi ArrayList<Product> (bag of products)
 *   - Setiap Product memiliki referensi balik ke Category
 * 
 * Contoh Relasi:
 *   - Kategori "Elektronik" memiliki 100+ Products (laptop, mouse, monitor, dll)
 *   - Setiap Product "Laptop Dell" tahu bahwa dia belong to kategori "Elektronik"
 * 
 * Enkapsulasi:
 *   - Semua atribut adalah private
 *   - Akses melalui getter/setter methods
 */
public class Category {
    // ======================== ATRIBUT KATEGORI ========================
    
    // IDENTITAS: ID unik untuk setiap kategori
    private int ID;
    
    // IDENTITAS: Nama kategori (contoh: "Elektronik", "Fashion", "Makanan")
    private String name;
    
    // DESKRIPSI: Penjelasan tentang kategori dan produk apa saja yang ada di dalamnya
    private String description;
    
    // KOMPOSISI: ArrayList yang menyimpan semua Product yang belong to kategori ini
    // Relasi One-to-Many: 1 Category memiliki Many Products
    // Relasi bi-directional: Setiap Product dalam list tahu kategorinya adalah ini
    private ArrayList<Product> products;

    // ======================== CONSTRUCTORS ========================
    
    /**
     * CONSTRUCTOR 1: Default Constructor (tanpa parameter)
     * Fungsi: Membuat Category dengan ArrayList<Product> kosong dan siap diisi
     * Kegunaan: Ketika membuat kategori baru dari user input (di AddCategory.java)
     */
    public Category() {
        // KOMPOSISI INITIALIZATION: Inisialisasi ArrayList kosong
        // Produk akan ditambahkan kemudian melalui method getProducts().add()
        products = new ArrayList<Product>();
    }

    /**
     * CONSTRUCTOR 2: Parameterized Constructor (dengan semua parameter)
     * Fungsi: Membuat Category dengan semua atribut langsung terisi
     * Parameter ID: ID unik kategori
     * Parameter name: Nama kategori
     * Parameter description: Deskripsi kategori
     * Parameter products: ArrayList<Product> yang sudah ada (untuk restore dari database)
     */
    public Category(int ID, String name, String description, ArrayList<Product> products) {
        this.ID = ID;                      // Menyimpan ID
        this.name = name;                  // Menyimpan nama
        this.description = description;    // Menyimpan deskripsi
        this.products = products;          // Menyimpan referensi ArrayList<Product>
    }

    // ======================== GETTER METHODS ========================
    
    /**
     * GETTER: Mengambil ID kategori
     * Return: int ID yang unik
     */
    public int getID() {
        return ID;  // Mengembalikan ID kategori
    }

    /**
     * GETTER: Mengambil nama kategori
     * Return: String nama kategori
     */
    public String getName() {
        return name;  // Mengembalikan nama kategori
    }

    /**
     * GETTER: Mengambil deskripsi kategori
     * Return: String deskripsi kategori
     */
    public String getDescription() {
        return description;  // Mengembalikan deskripsi kategori
    }

    /**
     * GETTER: Mengambil daftar produk dalam kategori
     * KOMPOSISI: Mengembalikan referensi ke ArrayList<Product>
     * Fungsi: Mengakses semua products yang ada dalam kategori ini
     * Return: ArrayList<Product> yang berisi 0 atau lebih Product objects
     * 
     * Cara Penggunaan:
     *   - category.getProducts().add(product): CRUD CREATE - menambah produk baru
     *   - category.getProducts().remove(product): CRUD DELETE - menghapus produk
     *   - category.getProducts().get(i): CRUD READ - mengakses produk tertentu
     */
    public ArrayList<Product> getProducts() {
        return products;  // Mengembalikan referensi ArrayList<Product>
    }

    // ======================== SETTER METHODS ========================
    
    /**
     * SETTER: Mengubah ID kategori
     * Parameter ID: ID baru
     */
    public void setID(int ID) {
        this.ID = ID;  // Menyimpan ID baru
    }

    /**
     * SETTER: Mengubah nama kategori (CRUD UPDATE)
     * Parameter name: Nama baru
     */
    public void setName(String name) {
        this.name = name;  // Menyimpan nama baru
    }

    /**
     * SETTER: Mengubah deskripsi kategori (CRUD UPDATE)
     * Parameter description: Deskripsi baru
     */
    public void setDescription(String description) {
        this.description = description;  // Menyimpan deskripsi baru
    }

    /**
     * SETTER: Mengubah ArrayList<Product> kategori (KOMPOSISI UPDATE)
     * Parameter products: ArrayList<Product> baru
     * 
     * Catatan: Setter ini jarang digunakan dalam operasi normal
     * Biasanya digunakan:
     *   - Mengganti seluruh list produk (reimport dari database)
     *   - Operasi bulk update
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;  // Menyimpan referensi ArrayList<Product> baru
    }

}
