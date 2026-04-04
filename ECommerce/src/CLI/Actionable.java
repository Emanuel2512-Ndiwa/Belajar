package CLI;

import ECommerce.User;
import java.util.Scanner;
import ECommerce.DataManager;

/**
 * INTERFACE: Actionable
 * Fungsi: Kontrak (blueprint) untuk berbagai aksi yang bisa dilakukan user dalam sistem
 * 
 * Konsep OOP - INTERFACE & POLYMORPHISM:
 *   - Interface Actionable mendefinisikan kontrak minimum yang harus diimplementasi semua Action classes
 *   - Berbagai kelas mengimplementasi interface ini: Explore, AddCategory, AddProduct, Login, SignUp, dll
 *   - Client dan Seller memiliki ArrayList<Actionable> untuk polymorphic behavior
 * 
 * Mengapa butuh Interface?
 *   - Memisahkan "apa yang harus dilakukan" dari "bagaimana melakukannya"
 *   - Memungkinkan berbagai implementasi dengan interface yang sama
 *   - User.actions dapat menyimpan berbagai Actionable implementations
 *   - NavigationHandler dapat memanggil execute() tanpa tahu tipe actual implementasinya
 * 
 * Benefit Polymorphism:
 *   - Code yang flexible dan extensible: menambah action baru cukup dengan implement interface ini
 *   - Single Responsibility: setiap action class fokus pada tugas spesifik mereka
 */
public interface Actionable {

    /**
     * METHOD SIGNATURE: getLabel()
     * Fungsi: Mengembalikan label/deskripsi aksi yang akan ditampilkan di menu
     * Return: String label dari aksi ini
     * 
     * Setiap implementasi harus memberikan label uniknya:
     *   - Explore: "Explore Products"
     *   - AddCategory: "Add new Category"
     *   - AddProduct: "Add new product"
     *   - dll
     */
    String getLabel();

    /**
     * METHOD SIGNATURE: execute()
     * Fungsi: Melaksanakan aksi spesifik ketika dipilih oleh user
     * 
     * Parameter:
     *   - Scanner scanner: untuk membaca input dari user
     *   - User user: user yang menjalankan aksi (bisa Client atau Seller)
     *   - DataManager dataManager: untuk akses ke data collections
     * 
     * Setiap implementasi akan melakukan logika berbeda:
     *   - Explore: menampilkan daftar produk
     *   - AddCategory: membuat category baru (CRUD Create)
     *   - AddProduct: membuat product baru (CRUD Create)
     *   - DeleteCategory: menghapus category (CRUD Delete)
     *   - EditProduct: mengubah product (CRUD Update)
     *   - dll
     */
    void execute(Scanner scanner, User user, DataManager dataManager);

}
