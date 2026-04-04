package CLI;

import java.util.Random;
import java.util.Scanner;

import ECommerce.Client;
import ECommerce.DataManager;
import ECommerce.Seller;
import ECommerce.User;

/**
 * UTILITY KELAS: SignUp
 * Fungsi: Menghandle proses pendaftaran user baru (Client atau Seller)
 * 
 * Konsep OOP - POLYMORPHISM & INHERITANCE:
 *   - Membuat object berdasarkan tipe: Client atau Seller
 *   - Kedua keduanya adalah subclass dari User
 *   - User user = new Seller() atau User user = new Client()
 *   - Polymorphism: variable user bisa menampung Seller atau Client object
 * 
 * OPERASI CRUD: CREATE
 *   - Proses SignUp adalah CREATE operation untuk User
 *   - Data baru ditambahkan ke DataManager.getUsers() ArrayList
 * 
 * Alur Program:
 *   1. Baca input user (nama, email, password, tipe akun)
 *   2. Validasi password (harus sama dengan confirm)
 *   3. Tentukan tipe akun (Seller atau Client) menggunakan polymorphism
 *   4. Jika Client, minta input address dan payment details
 *   5. Set semua atribut user
 *   6. CRUD CREATE: Tambahkan user ke DataManager
 *   7. Arahkan ke menu user
 */
public class SignUp {

    // ATRIBUT: Referensi ke DataManager untuk menyimpan user baru
    // Komposisi: SignUp memiliki referensi ke DataManager
    private DataManager dataManager;

    /**
     * CONSTRUCTOR: SignUp (Constructor is the action trigger)
     * Fungsi: Menjalankan seluruh proses pendaftaran user
     * Parameter scanner: untuk membaca input user
     * Parameter dataManager: untuk CRUD CREATE operations
     * Parameter navigationHandler: untuk arahkan ke menu setelah signup
     * 
     * NOTE: Constructor langsung menjalankan proses (bukan method execute())
     * Ini karena SignUp dijalankan sekali saat dipilih di menu
     */
    public SignUp(Scanner scanner, DataManager dataManager, NavigationHandler navigationHandler) {

        // ATRIBUT INSTANCE: Menyimpan referensi DataManager
        this.dataManager = dataManager;
        
        // CRUD CREATE - STEP 1: Generate ID unik untuk user baru
        // IDGenerator memastikan setiap user memiliki ID yang berbeda
        int ID = IDGenerator.generateID(dataManager, "User");
        
        // ======================== INPUT COLLECTION ========================
        // Mengumpulkan data dari user untuk membuat akun baru
        
        System.out.println();
        
        // USER INPUT: Nama depan
        System.out.printf("%-20s", "Enter First Name\t:");
        String firstName = scanner.next();  // Membaca nama depan
        
        // USER INPUT: Nama belakang
        System.out.printf("%-20s", "Enter Last  Name\t:");
        String lastName = scanner.next();   // Membaca nama belakang
        
        // USER INPUT: Email (akan digunakan untuk login)
        System.out.print("Enter Email\t:");
        String email = scanner.next();  // Membaca email
        
        // USER INPUT: Password
        System.out.print("Enter Password\t:");
        String password = scanner.next();  // Membaca password
        
        // USER INPUT: Konfirmasi password
        System.out.print("Confirm password\t:");
        String confirmPassword = scanner.next();  // Membaca konfirmasi password

        // VALIDASI: Pastikan password dan confirm password cocok
        // Loop sampai user memasukkan password yang sama
        while (!password.equals(confirmPassword)) {
            System.out.println("password doesn't match");  // Pesan error
            System.out.println();
            
            // RETRY: Minta password lagi
            System.out.print("Enter password\t:");
            password = scanner.nextLine();  // Membaca ulang password
            
            System.out.print("Confirm password\t:");
            confirmPassword = scanner.nextLine();  // Baca konfirmasi ulang

        }

        // USER INPUT: Nomor telepon
        System.out.print("Enter Phone number\t:");
        String phoneNumber = scanner.next();  // Membaca nomor telepon
        
        // USER INPUT: Tipe akun (Seller atau Client)
        System.out.println("Are you signing up as seller or client?(S/C)");
        String accType = scanner.next();  // Membaca tipe akun (S/C)

        // ======================== POLYMORPHISM: Object Creation ========================
        // Membuat object berdasarkan tipe akun yang dipilih user
        
        // VARIABLE: User variable yang bisa menampung Seller atau Client
        // POLYMORPHISM: Tipe actual object ditentukan saat runtime
        User user = null;

        // POLYMORPHISM - CONDITIONAL CREATION: Jika Seller
        if (accType.toUpperCase().equals("S")) {
            // INHERITANCE: Seller adalah subclass dari User
            // OBJECT CREATION: Membuat Seller object baru
            // Seller constructor akan inisialisasi ArrayList<Actionable> actions
            user = new Seller();
            // Seller actions: Explore, AddCategory (AddProduct akan ditambahkan di runtime)

        } 
        // POLYMORPHISM - CONDITIONAL CREATION: Jika Client
        else if (accType.toUpperCase().equals("C")) {
            // INHERITANCE: Client adalah subclass dari User
            // OBJECT CREATION: Membuat Client object baru
            // Client constructor akan inisialisasi ArrayList<Actionable> actions dan cart
            user = new Client();
            // Client actions: Explore (shopping related actions)
            
            // CLIENT SPECIFIC INPUTS: Client memiliki atribut tambahan
            System.out.print("Enter address\t:");
            String address = scanner.next();  // Membaca alamat pengiriman
            
            System.out.print("Enter payment details\t:");
            String paymentDetails = scanner.next();  // Membaca detail pembayaran

            // CASTING & POLYMORPHISM: Casting user ke Client untuk akses Client-specific methods
            // (Client) user: Explicit casting dari User ke Client
            // Ini aman karena kita tahu user adalah Client dari conditional block ini
            ((Client) user).setAdres(address);  // Set alamat Client
            ((Client) user).setPaymentDetails(paymentDetails);  // Set payment details Client

        }

        // ======================== SET COMMON ATTRIBUTES ========================
        // Set atribut umum yang dimiliki oleh semua User (Client dan Seller)
        // ENKAPSULASI: Menggunakan setter methods untuk modifikasi data
        
        user.setID(ID);  // Set ID unik
        user.setFirstName(firstName);  // Set nama depan
        user.setLastName(lastName);  // Set nama belakang
        user.setEmail(email);  // Set email
        user.setPassword(password);  // Set password
        user.setPhoneNumber(phoneNumber);  // Set nomor telepon

        // ======================== CRUD CREATE: SAVE USER ========================
        // Menyimpan user baru ke dalam sistem
        
        // AGREGASI: Menambahkan user ke ArrayList<User> yang dikelola DataManager
        // Relasi: DataManager mengagregasi semua User objects
        // Operasi: CREATE dari CRUD
        dataManager.getUsers().add(user);  // Tambahkan user baru ke sistem
        
        // PROGRAM FLOW: Setelah signup berhasil, tampilkan menu user
        // NavigationHandler.showMenu(user) akan menampilkan actions available untuk user ini
        navigationHandler.showMenu(user);  // Arahkan user ke menu utama mereka

    }

}
