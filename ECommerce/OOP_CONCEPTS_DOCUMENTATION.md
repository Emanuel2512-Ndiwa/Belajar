# Dokumentasi Konsep OOP dalam Project ECommerce

## Ringkasan Perubahan
File-file berikut telah ditambahkan dengan komentar detail yang menjelaskan setiap baris kode, konsep OOP, relasi antar kelas, dan CRUD operations:

1. **Main.java** - Entry Point Aplikasi
2. **User.java** - Base Class (Parent)
3. **Client.java** - Subclass (Inheritance)
4. **Seller.java** - Subclass (Inheritance)
5. **Actionable.java** - Interface Definition
6. **AddCategory.java** - Implementation & CRUD
7. **AddProduct.java** - Implementation & CRUD
8. **Product.java** - Domain Model
9. **Category.java** - Domain Model
10. **DataManager.java** - Data Repository
11. **SignUp.java** - User Creation & CRUD

---

## Konsep OOP Utama yang Diimplementasikan

### 1. INHERITANCE (Pewarisan Kelas)

#### Lokasi: User.java, Client.java, Seller.java

```
        User (Parent Class)
        /  \
       /    \
   Client   Seller (Child Classes)
```

**Penjelasan:**
- `Client extends User`: Mewarisi ID, firstName, lastName, email, password, phoneNumber, actions
- `Seller extends User`: Mewarisi semua atribut User plus atribut spesifik seller (SoldItemCount, profit, products)

**Mengapa diperlukan?**
- DRY Principle: Menghindari duplikasi kode
- Polymorphism: Bisa treat Client dan Seller sebagai User
- Specialization: Setiap subclass memiliki atribut dan behavior uniknya

**File dengan penjelasan:**
- [User.java](src/ECommerce/User.java#L1) - Komentar di awal class
- [Client.java](src/ECommerce/Client.java#L9) - Penjelasan inheritance di awal class
- [Seller.java](src/ECommerce/Seller.java#L10) - Penjelasan inheritance di awal class

---

### 2. INTERFACE (Kontrak Kelas)

#### Lokasi: Actionable.java

**Definisi:**
```java
public interface Actionable {
    String getLabel();
    void execute(Scanner scanner, User user, DataManager dataManager);
}
```

**Implementasi Interface:**
- `AddCategory implements Actionable` ✓
- `AddProduct implements Actionable` ✓
- `Explore implements Actionable` ✓
- `Login implements Actionable` ✓
- `SignUp implements Actionable` ✓

**Mengapa diperlukan Interface?**
- **Loose Coupling**: Action classes tidak perlu tahu satu sama lain
- **Polymorphism**: User.actions dapat menyimpan berbagai Actionable implementations
- **Extensibility**: Mudah menambah action baru dengan implement interface
- **Contract Definition**: Mndefinisikan apa yang harus dilakukan setiap action

**File dengan penjelasan:**
- [Actionable.java](src/CLI/Actionable.java#L8) - Penjelasan lengkap interface

---

### 3. POLYMORPHISM (Banyak Bentuk)

#### Lokasi: Multiple Files

**Contoh 1: Interface Polymorphism**
```java
// Di User.java
protected ArrayList<Actionable> actions;  // Bisa menyimpan berbagai implementasi

// Di Client.java
actions.add(new Explore());  // Menambahkan Explore

// Di Seller.java
actions.add(new Explore());
actions.add(new AddCategory());  // Menambahkan berbeda dari Client
```

**Contoh 2: Inheritance Polymorphism (SignUp.java)**
```java
User user = null;

if (accType.equals("S")) {
    user = new Seller();  // Variable user menampung Seller object
} else {
    user = new Client();  // Variable user menampung Client object
}

// Kedua object bisa ditreat sebagai User
dataManager.getUsers().add(user);
navigationHandler.showMenu(user);
```

**Mengapa diperlukan?**
- **Flexibility**: Code yang sama bekerja dengan berbagai tipe object
- **Code Reusability**: NavigationHandler tidak perlu tahu tipe actual user
- **Runtime Binding**: Tipe actual ditentukan saat program berjalan

**File dengan penjelasan:**
- [SignUp.java](src/CLI/SignUp.java#L64) - Penjelasan polymorphism saat object creation

---

### 4. ENCAPSULATION (Enkapsulasi)

#### Lokasi: Semua class dengan private attributes dan public getter/setter

**Prinsip:**
```java
private int ID;  // Private - hanya dari dalam class
private String name;

public int getID() { return ID; }  // Public getter
public void setID(int id) { this.ID = id; }  // Public setter
```

**Mengapa diperlukan?**
- **Data Protection**: Data tidak bisa diakses/dimodifikasi langsung dari luar
- **Validation**: Setter bisa melakukan validasi sebelum mengeset value
- **Maintainability**: Bisa mengubah implementasi internal tanpa mengubah interface public
- **Encapsulation**: Menyembunyikan detail implementasi

**File dengan penjelasan:**
- [User.java](src/ECommerce/User.java#L23) - Getter/Setter dengan enkapsulasi
- [Product.java](src/ECommerce/Product.java#L103) - Getter/Setter dengan enkapsulasi
- [Category.java](src/ECommerce/Category.java#L90) - Getter/Setter dengan enkapsulasi

---

### 5. COMPOSITION (Komposisi)

#### Lokasi: Multiple Classes

**Definisi:** Kelas memiliki references ke object lain yang lifetime-nya dependent

**Contoh 1: Client memiliki Cart**
```java
// Di Client.java
private Cart cart;  // Client memiliki satu Cart

public Cart getCart() { return cart; }
```

**Contoh 2: Client memiliki ArrayList<Order>**
```java
// Di Client.java
private ArrayList<Order> previousOrder;  // Client memiliki banyak Order

public ArrayList<Order> getPreviousOrder() { return previousOrder; }
```

**Contoh 3: Seller memiliki ArrayList<Product>**
```java
// Di Seller.java
private ArrayList<Product> products;  // Seller memiliki banyak Product

public ArrayList<Product> getProducts() { return products; }
```

**File dengan penjelasan:**
- [Client.java](src/ECommerce/Client.java#L28) - Komposisi Cart dan Order
- [Seller.java](src/ECommerce/Seller.java#L37) - Komposisi Product dan Order
- [Category.java](src/ECommerce/Category.java#L37) - Komposisi ArrayList<Product>

---

### 6. AGGREGATION (Agregasi)

#### Lokasi: Main.java, DataManager.java

**Definisi:** Kelas menyimpan references ke object lain yang lifetime-nya independent

**Contoh: DataManager mengagregasi ArrayList**
```java
// Di Main.java - ArrayList dibuat terlebih dahulu
ArrayList<User> User = new ArrayList<User>();
ArrayList<Category> categories = new ArrayList<Category>();
ArrayList<Product> products = new ArrayList<Product>();
ArrayList<Order> orders = new ArrayList<Order>();

// Di DataManager - hanya menyimpan referensi, tidak membuat ArrayLists
DataManager dataManager = new DataManager(User, categories, products, orders);
```

**Perbedaan Composition vs Aggregation:**
- **Composition**: Child object dibuat inside parent, lifetime dependent
- **Aggregation**: Objects sudah ada, parent hanya menyimpan referensi, lifetime independent

**File dengan penjelasan:**
- [Main.java](src/ECommerce/Main.java#L17) - Agregasi ArrayList
- [DataManager.java](src/ECommerce/DataManager.java#L32) - Agregasi data collections

---

### 7. ASSOCIATION (Associasi/Relasi)

#### Lokasi: Product.java, Category.java

**One-to-Many: Category memiliki banyak Product**
```java
// Di Category.java
private ArrayList<Product> products;  // One Category, Many Products

// Di Product.java
private Category category;  // Many Products, One Category
```

**Many-to-One: Product dijual oleh Seller**
```java
// Di Product.java
private Seller seller;  // Many Products, One Seller

// Di Seller.java
private ArrayList<Product> products;  // One Seller, Many Products
```

**Bidirectional Relationship:**
- Product tahu kategorinya (product.getCategory())
- Category tahu produk-produk yang ada di dalamnya (category.getProducts())

**File dengan penjelasan:**
- [Product.java](src/ECommerce/Product.java#L16) - Relasi ke Category dan Seller
- [Category.java](src/ECommerce/Category.java#L37) - Relasi ke Product
- [AddProduct.java](src/CLI/AddProduct.java#L60) - Bidirectional relationship setting

---

## CRUD Operations

### CREATE (Buat Data Baru)

**User Creation (SignUp.java)**
- [SignUp.java](src/CLI/SignUp.java#L77) - CRUD CREATE untuk User
- Step 1: Baca input
- Step 2: Validasi
- Step 3: Buat object (Seller atau Client)
- Step 4: Set atribut
- Step 5: `dataManager.getUsers().add(user)` - Simpan ke DataManager

**Category Creation (AddCategory.java)**
- [AddCategory.java](src/CLI/AddCategory.java#L46) - CRUD CREATE untuk Category
- Generate ID unik
- Baca input nama dan deskripsi
- Buat object Category
- Set atribut
- `dataManager.getCategories().add(c)` - Simpan ke DataManager

**Product Creation (AddProduct.java)**
- [AddProduct.java](src/CLI/AddProduct.java#L76) - CRUD CREATE untuk Product
- Validasi hanya Seller yang bisa (instanceof check)
- Baca input (nama, deskripsi, harga, stok)
- Buat object Product
- Set atribut
- Relasi bidirectional: `category.getProducts().add(product)` dan `product.setCategory(category)`
- `dataManager.getProducts().add(product)` - Simpan ke DataManager

---

### READ (Baca/Akses Data)

Implementasi READ operations ada di berbagai tempat:
- **Login.java**: `dataManager.getUsers()` - baca semua user untuk verifikasi
- **Explore.java**: `dataManager.getCategories()` dan `dataManager.getProducts()` - baca untuk menampilkan
- **ShowCategoryProduct.java**: `category.getProducts()` - baca products dalam category

---

### UPDATE (Ubah Data)

Menggunakan setter methods:
```java
product.setPrice(newPrice);        // UPDATE harga produk
category.setName(newName);         // UPDATE nama category
user.setPassword(newPassword);     // UPDATE password user
```

---

### DELETE (Hapus Data)

Belum fully implemented dalam tutorial stage ini, tapi sudah ada:
- **DeleteCategory.java**: `dataManager.getCategories().remove(category)`

---

## Relasi Antar Kelas - Diagram

```
┌─────────────────────────────────────────────────────┐
│                    DataManager                       │  (Mengagregasi)
│  - ArrayList<User>                                  │
│  - ArrayList<Category>                              │
│  - ArrayList<Product>                               │
│  - ArrayList<Order>                                 │
└─────────┬─────────┬──────────────┬──────────────────┘
          │         │              │
      (READ) (CREATE)          (CREATE)
          │         │              │
          ▼         ▼              ▼
    ┌─────────┐  ┌──────────┐  ┌─────────┐
    │   User  │  │Category  │  │ Product │
    ├─────────┤  ├──────────┤  ├─────────┤
    │  *ID    │  │  *ID     │  │  *ID    │
    │firstName│  │  name    │  │  name   │
    │lastName │  │products[]│◄─┤category │
    │ email   │  │          │  │ seller  │
    │password │  │          │  │ price   │
    └────┬────┘  └──────────┘  │ stock   │
         │                      └─────────┘
         │
    (INHERITANCE)
         │
    ┌────┴────┐
    ▼         ▼
┌────────┐┌────────┐
│ Client ││ Seller │
├────────┤├────────┤
│ *cart  ││product │
│*address││*profit ││
│ order[]││orders[]│
└────────┘└────────┘
   (COMPOSITION)
   │         │
   │         │
   ▼         ▼
┌──────┐  ┌──────┐
│ Cart │  │Order │
└──────┘  └──────┘
```

---

## File-File Penting untuk Belajar

| File | Konsep Utama | Lokasi |
|------|-------------|--------|
| User.java | Encapsulation, Base Class | src/ECommerce/User.java |
| Client.java | Inheritance, Composition | src/ECommerce/Client.java |
| Seller.java | Inheritance, Composition | src/ECommerce/Seller.java |
| Actionable.java | Interface, Contract | src/CLI/Actionable.java |
| AddCategory.java | Interface Implementation, CRUD CREATE | src/CLI/AddCategory.java |
| AddProduct.java | CRUD CREATE, Association | src/CLI/AddProduct.java |
| SignUp.java | Polymorphism, CRUD CREATE | src/CLI/SignUp.java |
| Product.java | Association, Composition | src/ECommerce/Product.java |
| Category.java | Composition, One-to-Many | src/ECommerce/Category.java |
| DataManager.java | Aggregation, FACADE Pattern | src/ECommerce/DataManager.java |
| Main.java | Program Entry, Aggregation | src/ECommerce/Main.java |

---

## Cara Membaca Komentar

Setiap file memiliki komentar detail pada:

1. **Class Level** - Penjelasan purpose class dan konsep OOP
   ```java
   /**
    * KELAS TURUNAN (SUBCLASS): Client
    * Fungsi: ...
    * Konsep OOP - INHERITANCE: ...
    */
   public class Client extends User { ... }
   ```

2. **Attribute Level** - Penjelasan setiap field dan relasi
   ```java
   // KOMPOSISI: Client memiliki referensi ke Category
   private Category category;
   ```

3. **Method Level** - Penjelasan function dan parameter
   ```java
   /**
    * GETTER: Mengambil ID produk
    * Return: int ID yang unik
    */
   public int getID() { return ID; }
   ```

4. **Operation Level** - Penjelasan CRUD operations
   ```java
   // CRUD CREATE - STEP 1: Generate ID unik
   // CRUD CREATE - STEP 2: Buat object baru
   ```

---

## Next Steps Untuk Improvement

1. **Tambahi komentar ke file CLI lainnya:**
   - Login.java
   - Explore.java
   - ShowCategoryProduct.java
   - FindCategoryByID.java
   - Input.java

2. **Tambahi komentar ke file domain model:**
   - Cart.java
   - CartProduct.java
   - Order.java
   - OrderStatus.java

3. **Implementasi UPDATE dan DELETE CRUD operations**

4. **Tambahi error handling dan validation**

5. **Implementasi persistensi data (file/database)**

---

## Ringkasan Nilai Pembelajaran

Project ini mengajarkan:
- ✓ **Inheritance**: User -> Client/Seller
- ✓ **Polymorphism**: ArrayList<Actionable>, User type polymorphism
- ✓ **Encapsulation**: Private attributes dengan getter/setter
- ✓ **Interface**: Actionable contract
- ✓ **Composition**: Client-Cart, Seller-Product, Category-Product
- ✓ **Aggregation**: DataManager-Collections
- ✓ **Association**: Product-Category, Product-Seller, Client-Order
- ✓ **CRUD Operations**: CREATE (SignUp, AddCategory, AddProduct)
- ✓ **Design Patterns**: FACADE (DataManager), Strategy (Actionable)

---

**Documentation Generated**: 2026-04-04
**Project**: ECommerce Learning Project
**Language**: Bahasa Indonesia & English
