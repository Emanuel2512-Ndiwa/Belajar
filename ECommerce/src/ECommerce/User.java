package ECommerce;

import java.util.ArrayList;
import CLI.Actionable;

/**
 * KELAS BASE: User
 * Fungsi: Kelas parent yang menyimpan data umum pengguna (Client dan Seller)
 * Konsep OOP - INHERITANCE:
 *   - Client dan Seller mewarisi kelas ini (extends User)
 *   - User adalah abstract blueprint untuk semua tipe pengguna
 *   - Client dan Seller dapat menambah atribut dan perilaku spesifik mereka
 * 
 * Konsep OOP - ENCAPSULATION:
 *   - Semua atribut private (hanya bisa diakses dari dalam kelas User)
 *   - Akses data melalui getter/setter public (controlled access)
 *   - actions adalah protected agar subclass (Client, Seller) bisa mengaksesnya
 */
public class User {

    // ENKAPSULASI: Private attributes yang hanya diakses melalui getter/setter
    // ATRIBUT UMUM: Data yang dimiliki semua User
    private int ID;                                  // Identitas unik setiap user
    private String firstName;                        // Nama depan pengguna
    private String lastName;                         // Nama belakang pengguna
    private String email;                            // Email (untuk login)
    private String password;                         // Password (untuk autentikasi)
    private String phoneNumber;                      // Nomor telepon pengguna
    
    // PROTECTED ATTRIBUTE: Bisa diakses oleh subclass (Client, Seller)
    // KOMPOSISI: User memiliki ArrayList<Actionable> untuk menyimpan daftar aksi yang bisa dilakukan user
    // POLYMORPHISM: actions berisi berbagai implementasi Actionable (AddProduct, Explore, AddCategory, dll)
    protected ArrayList<Actionable> actions;         // List of dynamic actions berdasarkan role



    // ======================== GETTER METHODS (Data Access) ========================
    
    /**
     * GETTER: Mengambil nilai ID
     * Fungsi: Mengakses ID user dengan cara terenkapsulasi
     * Return: ID dari user
     */
    public int getID() {
        return ID;  // Mengembalikan ID yang tersimpan
    }
    
    /**
     * GETTER: Mengambil nama depan
     * Return: firstName yang tersimpan
     */
    public String getFirstName() {
        return firstName;  // Mengembalikan firstName
    }
    
    /**
     * GETTER: Mengambil nama belakang
     * Return: lastName yang tersimpan
     */
    public String getLastName() {
        return lastName;  // Mengembalikan lastName
    }
    
    /**
     * GETTER: Mengambil email
     * Return: email yang tersimpan
     */
    public String getEmail() {
        return email;  // Mengembalikan email
    }
    
    /**
     * GETTER: Mengambil password
     * Return: password yang tersimpan
     */
    public String getPassword() {
        return password;  // Mengembalikan password
    }
    
    /**
     * GETTER: Mengambil nomor telepon
     * Return: phoneNumber yang tersimpan
     */
    public String getPhoneNumber() {
        return phoneNumber;  // Mengembalikan phoneNumber
    }

    /**
     * GETTER: Menggabungkan nama depan dan belakang
     * Return: String format "firstName lastName"
     */
    public String getFullName() {
        return firstName + " " + lastName;  // Menggabungkan firstName dan lastName
    }


    // ======================== SETTER METHODS (Data Modification) ========================
    
    /**
     * SETTER: Mengubah ID user
     * Parameter id: nilai ID baru
     * Fungsi: Melakukan enkapsulasi saat modifikasi data
     */
    public void setID(int ID) {
        this.ID = ID;  // Menyimpan ID baru ke atribut instance ID
    }
    
    /**
     * SETTER: Mengubah nama depan
     * Parameter firstName: nilai nama depan baru
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;  // Menyimpan firstName baru
    }
    
    /**
     * SETTER: Mengubah nama belakang
     * Parameter lastName: nilai nama belakang baru
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;  // Menyimpan lastName baru
    }
    
    /**
     * SETTER: Mengubah email
     * Parameter email: nilai email baru
     */
    public void setEmail(String email) {
        this.email = email;  // Menyimpan email baru
    }
    
    /**
     * SETTER: Mengubah password
     * Parameter password: nilai password baru
     */
    public void setPassword(String password) {
        this.password = password;  // Menyimpan password baru
    }
    
    /**
     * SETTER: Mengubah nomor telepon
     * Parameter phoneNumber: nilai nomor telepon baru
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;  // Menyimpan phoneNumber baru
    }
    
    /**
     * GETTER: Mengambil daftar aksi yang bisa dilakukan user
     * POLYMORPHISM: Mengakses berbagai implementasi Actionable sesuai tipe user
     * Return: ArrayList berisi Actionable objects
     * Relasi: KOMPOSISI - User memiliki ArrayList<Actionable>
     */
    public ArrayList<Actionable> getActions() {
        return actions;  // Mengembalikan list of actions
    }
}
