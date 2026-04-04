package ECommerce;

/**
 * DOMAIN MODEL KELAS: Product
 * Fungsi: Merepresentasikan produk yang dijual dalam sistem e-commerce
 * 
 * Konsep OOP - KOMPOSISI/RELASI KELAS:
 *   - Product memiliki referensi ke Category (COMPOSITION)
 *     Relasi: Many Products dapat belong to One Category (Many-to-One)
 *   - Product memiliki referensi ke Seller (COMPOSITION)
 *     Relasi: Many Products dapat be sold by One Seller (Many-to-One)
 *   - Category memiliki ArrayList<Product> (COMPOSITION)
 *     Relasi: One Category mengandung banyak Products (One-to-Many)
 * 
 * Hubungan Antar Kelas:
 *   - DataManager mengagregasi ArrayList<Product>
 *   - Category mengagregasi ArrayList<Product> (bag of products)
 *   - Seller mengagregasi ArrayList<Product> (inventory)
 *   - Cart dapat mengagregasi ArrayList<Product> (items to purchase)
 * 
 * Enkapsulasi:
 *   - Semua atribut adalah private
 *   - Akses melalui getter/setter methods
 */
public class Product {
    // ======================== ATRIBUT PRODUK ========================
    
    // IDENTITAS: ID unik untuk setiap produk
    private int ID;
    
    // IDENTITAS: Nama produk yang ditampilkan kepada user
    private String name;
    
    // DESKRIPSI: Penjelasan detail tentang produk
    private String description;
    
    // BISNIS: Harga produk dalam rupiah/currency unit
    private double price;
    
    // INVENTARIS: Jumlah stok produk yang tersedia
    private int stockQuantity;
    
    // RELASI KOMPOSISI: Referensi ke Category tempat product ini berada
    // Relasi Many-to-One: banyak Products dalam satu Category
    // Relasi bi-directional: Product -> Category dan Category -> ArrayList<Product>
    private Category category;
    
    // RELASI KOMPOSISI: Referensi ke Seller yang menjual product ini
    // Relasi Many-to-One: banyak Products dijual oleh satu Seller
    // Relasi bi-directional: Product -> Seller dan Seller -> ArrayList<Product>
    private Seller seller;

    // ======================== CONSTRUCTORS ========================
    
    /**
     * CONSTRUCTOR 1: Default Constructor (tanpa parameter)
     * Fungsi: Membuat object Product dengan nilai default (null/0)
     * Kegunaan: Flexible initialization, atribut dapat diset satu per satu dengan setters
     */
    public Product() {
        // Nilai default akan null (int=0, String=null, double=0.0)
    }

    /**
     * CONSTRUCTOR 2: Parameterized Constructor (dengan semua parameter)
     * Fungsi: Membuat object Product dengan semua atribut langsung terisi
     * Parameter id: ID unik product
     * Parameter name: Nama produk
     * Parameter description: Deskripsi produk
     * Parameter price: Harga produk
     * Parameter stockQuantity: Jumlah stok awal
     * Parameter category: Referensi ke Category
     * Parameter seller: Referensi ke Seller
     */
    public Product(int ID, String name, String description, double price, int stockQuantity, Category category,
            Seller seller) {
        this.ID = ID;                      // Menyimpan ID
        this.name = name;                  // Menyimpan nama
        this.description = description;    // Menyimpan deskripsi
        this.price = price;                // Menyimpan harga
        this.stockQuantity = stockQuantity; // Menyimpan stok
        this.category = category;          // Menyimpan referensi Category
        this.seller = seller;              // Menyimpan referensi Seller
    }

    // ======================== GETTER METHODS ========================
    
    /**
     * GETTER: Mengambil ID produk
     * Return: int ID yang unik
     */
    public int getID() {
        return ID;  // Mengembalikan ID produk
    }

    /**
     * GETTER: Mengambil nama produk
     * Return: String nama produk
     */
    public String getName() {
        return name;  // Mengembalikan nama produk
    }

    /**
     * GETTER: Mengambil deskripsi produk
     * Return: String deskripsi produk
     */
    public String getDescription() {
        return description;  // Mengembalikan deskripsi produk
    }

    /**
     * GETTER: Mengambil harga produk
     * Return: double harga produk
     */
    public double getPrice() {
        return price;  // Mengembalikan harga produk
    }

    /**
     * GETTER LOGIC: Mengecek apakah produk ada di stok
     * Business Logic: Produk dianggap "in stock" jika stockQuantity > 0
     * Return: boolean true jika ada stok, false jika habis
     */
    public boolean isInStock() {
        return stockQuantity > 0;  // Logic: stok > 0 berarti tersedia
    }

    /**
     * GETTER: Mengambil jumlah stok produk
     * Return: int jumlah barang yang tersedia
     */
    public int getStockQuantity() {
        return stockQuantity;  // Mengembalikan jumlah stok
    }

    /**
     * GETTER: Mengambil referensi kategori produk
     * RELASI KOMPOSISI: Mengembalikan referensi ke Category object
     * Return: Category object yang mengandung produk ini
     */
    public Category getCategory() {
        return category;  // Mengembalikan referensi ke Category
    }

    /**
     * GETTER: Mengambil referensi seller produk
     * RELASI KOMPOSISI: Mengembalikan referensi ke Seller object
     * Return: Seller object yang menjual produk ini
     */
    public Seller getSeller() {
        return seller;  // Mengembalikan referensi ke Seller
    }

    // ======================== SETTER METHODS ========================
    
    /**
     * SETTER: Mengubah ID produk
     * Parameter ID: ID baru
     */
    public void setID(int ID) {
        this.ID = ID;  // Menyimpan ID baru
    }

    /**
     * SETTER: Mengubah nama produk
     * Parameter name: Nama baru
     */
    public void setName(String name) {
        this.name = name;  // Menyimpan nama baru
    }

    /**
     * SETTER: Mengubah deskripsi produk
     * Parameter description: Deskripsi baru
     */
    public void setDescription(String description) {
        this.description = description;  // Menyimpan deskripsi baru
    }

    /**
     * SETTER: Mengubah harga produk (UPDATE CRUD)
     * Parameter price: Harga baru
     */
    public void setPrice(double price) {
        this.price = price;  // Menyimpan harga baru
    }

    /**
     * SETTER: Mengubah jumlah stok produk (UPDATE CRUD)
     * Parameter stockQuantity: Jumlah stok baru
     * Digunakan ketika: product dibeli, stok dikurangi
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;  // Menyimpan stok baru
    }

    /**
     * SETTER: Mengubah kategori produk (RELASI KOMPOSISI UPDATE)
     * Parameter category: Category object baru
     */
    public void setCategory(Category category) {
        this.category = category;  // Menyimpan referensi Category baru
    }

    /**
     * SETTER: Mengubah seller produk (RELASI KOMPOSISI UPDATE)
     * Parameter seller: Seller object baru
     */
    public void setSeller(Seller seller) {
        this.seller = seller;  // Menyimpan referensi Seller baru
    }

}
