package CLI;

import java.util.Scanner;

import ECommerce.User;
import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.Product;
import ECommerce.Seller;

/**
 * IMPLEMENTATION KELAS: AddProduct
 * Fungsi: Mengimplementasikan aksi "Tambah Product Baru" dari interface Actionable
 * 
 * Konsep OOP - INTERFACE IMPLEMENTATION:
 *   - AddProduct mengimplementasikan interface Actionable
 *   - Harus override method getLabel() dan execute()
 * 
 * Konsep OOP - POLYMORPHISM:
 *   - AddProduct adalah implementasi Actionable yang berbeda dari AddCategory
 *   - Dijalankan polymorphically melalui ArrayList<Actionable>
 * 
 * Konsep OOP - ENCAPSULATION:
 *   - Check type: hanya Seller yang bisa menjalankan aksi ini (instanceof Seller)
 *   - Private attribute category: category reference yang disimpan saat konstruksi
 * 
 * RELASI ANTAR KELAS:
 *   - AddProduct memiliki referensi ke Category (composition)
 *   - Product memiliki referensi ke Category dan Seller
 *   - Hubungan: Product -belongs to-> Category dan Product -sold by-> Seller
 * 
 * OPERASI CRUD: CREATE
 *   - Aksi ini membuat dan menambahkan Product baru ke dalam sistem
 */
public class AddProduct implements Actionable {

    // KOMPOSISI: AddProduct memiliki referensi ke Category
    // Category ini digunakan untuk menambahkan product ke kategori yang tepat
    private Category category;

    /**
     * CONSTRUCTOR: Inisialisasi AddProduct dengan referensi Category
     * Parameter category: kategori yang akan menerima product baru
     * 
     * Fungsi: Ketika user memilih category, AddProduct dibuat dengan category tersebut
     * Relasi: AddProduct -> Category (composition)
     */
    public AddProduct(Category category) {
        this.category = category;  // Menyimpan referensi Category untuk digunakan di execute()
    }

    /**
     * OVERRIDE METHOD: getLabel()
     * Implementasi dari interface Actionable
     * Return: String label untuk menu
     */
    @Override
    public String getLabel() {
        return "Add new product";  // Label yang ditampilkan di menu user
    }

    /**
     * OVERRIDE METHOD: execute()
     * Implementasi dari interface Actionable
     * Fungsi: Melaksanakan aksi penambahan Product baru ke Category
     * 
     * Parameter scanner: untuk membaca input produk dari user
     * Parameter user: user yang menjalankan aksi (harus berupa Seller)
     * Parameter dataManager: untuk akses ke ArrayList<Product> global
     */
    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {

        // ENKAPSULASI: Check tipe user dengan instanceof
        // Hanya Seller yang bisa menambah product, bukan Client
        // Reason: Hanya Seller yang memiliki produk untuk dijual
        if (!(user instanceof Seller)) {
            System.out.println("Only seller can add new product");  // Pesan error jika bukan Seller
            return;  // Exit dari method jika user tidak authorized
        }

        // USER INPUT: Meminta nama produk
        System.out.println("Enter a product name");
        String name = Input.readLineString(scanner);  // Membaca nama produk dari user

        // USER INPUT: Meminta deskripsi produk
        System.out.println("Enter the description");
        String description = Input.readLineString(scanner);  // Membaca deskripsi

        // USER INPUT: Meminta harga produk
        System.out.println("enter the price product");
        double price = Input.readDouble(scanner);  // Membaca harga sebagai double

        // USER INPUT: Meminta stok produk (jumlah barang)
        System.out.println("enter product stockQuantty(int)");
        int stoctQty = Input.readInt(scanner);  // Membaca stok sebagai integer

        // CRUD CREATE - STEP 1: Membuat object Product baru
        // Relasi: Product akan memiliki referensi ke Category dan Seller
        Product product = new Product();

        // CRUD CREATE - STEP 2: Set atribut Product
        // IDGenerator.generateID(): Generate ID unik untuk product
        product.setID(IDGenerator.generateID(dataManager, "product"));  // ID unik
        
        product.setName(name);                  // Nama produk
        product.setDescription(description);    // Deskripsi produk
        product.setPrice(price);                // Harga produk
        product.setStockQuantity(stoctQty);    // Jumlah stock

        // RELASI: Menambahkan product ke Category
        // KOMPOSISI: Category memiliki ArrayList<Product>
        // Akses: category.getProducts().add(product)
        category.getProducts().add(product);    // Tambahkan product ke category's product list
        
        // RELASI BALIK: Set category untuk product ini
        // Relasi bi-directional: Product mengetahui kategorinya
        product.setCategory(category);          // Product reference kembali ke Category

        // CRUD CREATE - STEP 3: Menyimpan product ke DataManager
        // AGREGASI: DataManager mengagregasi semua Product objects di sistem
        dataManager.getProducts().add(product); // Tambahkan product ke global products list

        // GET INDEX: Mendapatkan index category (untuk tracking)
        // Catatan: Variabel ini sebenarnya tidak digunakan untuk apa-apa
        // Bisa dihapus atau digunakan untuk updater Category di DataManager
        int catIndex = dataManager.getCategories().indexOf(category);

        // SUCCESS MESSAGE: Konfirmasi bahwa product telah ditambahkan
        System.out.println("Product addedd successfully");  // Pesan sukses ke user

        // SUMMARY OPERASI CRUD CREATE:
        // 1. Membaca input dari user (nama, deskripsi, harga, stok)
        // 2. Membuat object Product baru
        // 3. Menambahkan ke category.products (relasi bi-directional)
        // 4. Menambahkan ke dataManager.products (agregasi global)
    }
}
