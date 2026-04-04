package CLI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.Order;
import ECommerce.Product;
import ECommerce.User;

/**
 * IMPLEMENTATION KELAS: AddCategory
 * Fungsi: Mengimplementasikan aksi "Tambah Category Baru" dari interface Actionable
 * 
 * Konsep OOP - INTERFACE IMPLEMENTATION:
 *   - AddCategory mengimplementasikan interface Actionable
 *   - Harus override method getLabel() dan execute()
 *   - Dapat disimpan dalam ArrayList<Actionable> untuk polymorphic behavior
 * 
 * Konsep OOP - POLYMORPHISM:
 *   - AddCategory adalah satu dari berbagai Actionable implementations
 *   - Ketika User (Seller) memanggil getActions().get(i).execute(), 
 *     polymorphism memastikan AddCategory.execute() yang dipanggil
 * 
 * OPERASI CRUD: CREATE
 *   - Aksi ini membuat dan menambahkan Category baru ke dalam sistem
 */
public class AddCategory implements Actionable {

    /**
     * OVERRIDE METHOD: getLabel()
     * Implementasi dari interface Actionable
     * Fungsi: Mengembalikan label yang akan ditampilkan di menu user
     * Return: String yang mendeskripsikan aksi ini
     */
    @Override
    public String getLabel() {
        // Mengembalikan label untuk ditampilkan di menu
        return "Add new Category";  // User akan melihat pilihan menu "Add new Category"
    }

    /**
     * OVERRIDE METHOD: execute()
     * Implementasi dari interface Actionable
     * Fungsi: Melaksanakan aksi penambahan Category baru
     * Parameter scanner: untuk membaca input dari user (nama, deskripsi kategori)
     * Parameter user: user yang menjalankan aksi (dalam kasus ini hanya Seller)
     * Parameter dataManager: untuk akses ke ArrayList<Category> untuk penyimpanan
     */
    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        // CRUD CREATE - STEP 1: Generate ID unik untuk category baru
        // IDGenerator memastikan setiap category memiliki ID unik
        int ID = IDGenerator.generateID(dataManager, "Category");
        
        // USER INPUT: Meminta nama kategori dari user
        System.out.println("Enter Category Name");
        String name = scanner.next();  // Membaca nama kategori dari input user
        
        // USER INPUT: Meminta deskripsi kategori
        System.out.println("Enter category description:");
        String description = scanner.next();  // Membaca deskripsi kategori
        
        // Clear buffer input (menghindari issue dengan nextLine() sebelumnya
        scanner.nextLine();

        // CRUD CREATE - STEP 2: Membuat object Category baru
        // Relasi: Category memiliki ArrayList<Product> (akan diisi kemudian)
        Category c = new Category();
        
        // CRUD CREATE - STEP 3: Set atribut Category
        c.setID(ID);                      // Menyimpan ID unik
        c.setName(name);                  // Menyimpan nama kategori
        c.setDescription(description);    // Menyimpan deskripsi kategori

        // CRUD CREATE - STEP 4: Menyimpan kategori baru ke dalam DataManager
        // AGREGASI: menambahkan category ke ArrayList<Category> yang dikelola DataManager
        // Relasi: DataManager mengagregasi Category objects
        dataManager.getCategories().add(c);  // Tambahkan category baru ke sistem
        
        // NOTE: Ketika category ditambahkan dengan sukses, AddProduct akan bisa mereference category ini

    }

}