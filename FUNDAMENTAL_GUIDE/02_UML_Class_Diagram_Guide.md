# 📐 UML CLASS DIAGRAM - COMPLETE GUIDE
## Bagaimana Membuat Class Diagram Seperti Profesional
**Referensi:** UML Reference Manual (Rational Rose), Object-Oriented Analysis & Design (Grady Booch, Robert Martin)

---

## 🔍 APA ITU CLASS DIAGRAM?

**Definisi (Industri):**
Class Diagram adalah visual representation dari static structure sebuah sistem yang menunjukkan:
- Classes (kelas-kelas dalam sistem)
- Attributes (properti/field kelas)
- Methods (operasi/behavior kelas)
- Relationships (hubungan antar kelas)

**Kegunaan:**
- ✅ Komunikasi antar developer
- ✅ Documentation untuk project
- ✅ Planning sebelum coding
- ✅ Review architecture sistem
- ✅ Onboarding developer baru

---

## 📦 KOMPONEN CLASS DIAGRAM

### **1. CLASS NOTATION (Simbol Kelas)**

```
┌─────────────────────────────────┐
│   <<stereotype>>                │  ← Stereotype (optional)
│   ClassName                     │  ← Nama Class
├─────────────────────────────────┤
│ - attribute1 : type             │  ← Attributes (private)
│ # attribute2 : type             │  ← Attributes (protected)
│ + attribute3 : type             │  ← Attributes (public)
├─────────────────────────────────┤
│ + method1(param) : returnType   │  ← Methods (public)
│ - method2() : void              │  ← Methods (private)
│ # method3() : String            │  ← Methods (protected)
│ {abstract}                      │  ← Abstract method
└─────────────────────────────────┘
```

**Penjelasan Symbols:**

| Symbol | Visibility | Akses |
|--------|-----------|-------|
| `-` | Private | Hanya dalam class |
| `#` | Protected | Dalam class + subclass |
| `+` | Public | Semua bisa akses |
| `~` | Package | Dalam package yang sama |

**Contoh Real:**
```
┌──────────────────────────────┐
│      Barang (abstract)       │
├──────────────────────────────┤
│ - nama : String              │
│ - harga : double             │
│ - diskon : double            │
│ - pajak : double             │
│ - stok : int                 │
├──────────────────────────────┤
│ + getNama() : String         │
│ + setHarga(double) : void    │
│ + getHarga() : double        │
│ + calculateSellingPrice()* : double  │
│ + updateStok(int) : boolean  │
└──────────────────────────────┘
         * = abstract method
```

---

### **2. RELATIONSHIP TYPES (Jenis Hubungan)**

#### **A. INHERITANCE (Pewarisan)**

```
Notasi:     Parent
            ▲
            │
            │ (solid arrow)
            │
          Child

Contoh:
            Barang (abstract)
            ▲
       ┌────┼────┬──────┐
       │    │    │      │
   Elektronik Fashion Makanan

Berarti: Elektronik/Fashion/Makanan adalah jenis Barang
         Mereka inherit semua attribute & method dari Barang
```

**Syntax di UML:**
```
Child ---|> Parent

Arti: - - - menunjukkan solid line
      > menunjukkan arah (dari child ke parent)
```

#### **B. COMPOSITION (Komposisi)**

```
Notasi:   Owner
          ────────→  Child
          (solid diamond)

Contoh:
          Seller
          ──●────→  ArrayList<Barang>

Berarti: 1 Seller MEMILIKI banyak Barang
         Jika Seller dihapus, Barang-nya juga hilang
         (strong ownership/lifecyle dependency)

        1 ---●───→ * (many)
        ↑
   "Seller memiliki 1 atau lebih barang"
```

#### **C. AGGREGATION (Agregasi)**

```
Notasi:   Owner
          ────────○  Child
          (hollow diamond)

Contoh:
          Team  
          ───○────→  ArrayList<Employee>

Berarti: 1 Team MEMILIKI banyak Employee
         Tapi jika Team dihapus, Employee masih bisa ada
         (weak ownership/independent lifecycle)

        1 ───○─→ *
        
PERBEDAAN KOMPOSISI vs AGREGASI:
- Komposisi: Hard dependency (●)
  Owner WAJIB punya child
  
- Agregasi: Soft dependency (○)
  Owner bisa punya atau tidak punya child
```

#### **D. ASSOCIATION (Asosiasi)**

```
Notasi:   Class1
          ────────→  Class2

Contoh:
          Order
          ──────→  Customer

Berarti: Order berhubungan dengan Customer
         Tapi tidak ownership atau inheritance
         Hanya relationship saja
```

#### **E. DEPENDENCY (Dependensi)**

```
Notasi:   Class1
          - - - - →  Class2
          (dashed arrow)

Contoh:
          Main
          - - → InventoryManager

Berarti: Main menggunakan InventoryManager
         Tapi bukan ownership
         Hanya menggunakan/memanggil saja
```

#### **F. REALIZATION/IMPLEMENTATION (Interface)**

```
Notasi:   Class
          - - - - |>  Interface
          (dashed hollow arrow)

Contoh:
          Barang
          - - - |>  Reportable

Berarti: Barang implements interface Reportable
         Harus implement semua method yang ada di Reportable
```

---

### **3. MULTIPLICITY (Jumlah Relasi)**

```
Notasi:
  0..1      : 0 atau 1
  1         : Tepat 1
  0..*  or *: 0 atau lebih (many)
  1..*      : 1 atau lebih
  n         : Tepat n (contoh: 3 berarti tepat 3)
  m..n      : Antara m sampai n

Contoh dalam relationship:
                  Seller ──●──1────→──* Barang
                                ↑
                          Multiplicity
                    "1 Seller punya BANYAK barang"
                    
                  Customer ──────→──1 Order
                      │
                   "BANYAK customer, tapi satu order"
```

---

## 🛠️ STEP-BY-STEP MEMBUAT CLASS DIAGRAM

### **STEP 1: Identifikasi Semua Classes**

```
PROBLEM: Sistem Inventori Toko

CLASSES:
1. Barang (abstract) - entity barang
2. Elektronik - type barang
3. Fashion - type barang
4. Makanan - type barang
5. Seller - entity penjual
6. InventoryManager - manage sistem
7. Reportable (interface) - kontrak untuk report
```

---

### **STEP 2: Definisikan Attributes & Methods**

**Untuk setiap class, tentukan:**
- Apa data yang disimpan? (attributes)
- Apa operasi yang bisa dilakukan? (methods)

```
Barang:
  Attributes:
  - nama : String
  - harga : double
  - diskon : double
  - pajak : double
  - stok : int
  
  Methods:
  + getNama() : String
  + setHarga(double) : void
  + calculateSellingPrice() : double (abstract)
  + updateStok(int) : boolean

Seller:
  Attributes:
  - nama : String
  - id : String
  - rating : double
  - inventori : ArrayList<Barang>
  
  Methods:
  + addBarang(Barang) : void
  + searchBarang(String) : Barang
  + getTotalNilaiInventori() : double
```

---

### **STEP 3: Tentukan Relationships**

**Tanya diri sendiri:**
1. Class mana yang inherit dari class mana?
2. Class mana yang punya/memiliki class lain?
3. Class mana yang menggunakan class lain?

```
INHERITANCE:
- Elektronik EXTENDS Barang
- Fashion EXTENDS Barang
- Makanan EXTENDS Barang

COMPOSITION:
- Seller MEMILIKI ArrayList<Barang>
  (1 Seller : Many Barang)

- InventoryManager MEMILIKI ArrayList<Seller>
  (1 Manager : Many Seller)

REALIZATION:
- Barang IMPLEMENTS Reportable
- Seller IMPLEMENTS Reportable

DEPENDENCY:
- Main USES InventoryManager
```

---

### **STEP 4: Draw the Diagram**

```
                    <<interface>>
                      Reportable
                           ▲
                           │ (implements)
                           │ - - - |>
                           │            
        ┌──────────────────┴──────────────────┐
        │                                     │
    ┌────────────────┐              ┌──────────────────┐
    │    Barang      │              │     Seller       │
    │   (abstract)   │              │                  │
    ├────────────────┤              ├──────────────────┤
    │ - nama         │              │ - nama           │
    │ - harga        │●─────────────│ - id             │
    │ - diskon       │  "memiliki"  │ - rating         │
    │ - pajak        │   1 : *      │ - inventori[]    │
    │ - stok         │              ├──────────────────┤
    ├────────────────┤              │ + addBarang()    │
    │ + getNama()    │              │ + searchBarang() │
    │ + getHarga()   │              │ + totalnilai()   │
    │ + calcPrice()* │              └──────────────────┘
    └────────────────┘                       ▲
            ▲                                 │
       ┌────┼────┬───────┐            Seller
       │    │    │       │                │ ●───────────│
       │    │    │       │         "1 : *"│
    ┌──┴───┐ │ ┌─┴──┐ ┌──┴──┐           │
    │Elekt │ │ │Fash│ │Mak  │    ┌──────┴──────────────┐
    │ronik │ │ │ion │ │anan │    │ InventoryManager    │
    └──────┘ │ └────┘ └─────┘    ├─────────────────────┤
             │                    │ - sellers :[]       │
             │                    ├─────────────────────┤
             │                    │ + addSeller()       │
             │                    │ + displayAll()      │
             │                    │ + generateReport()  │
             │                    └─────────────────────┘
             │                             ▲
             │                             │ (uses)
             │                             │ - - - - -
             └─────────────────────────────┘
                        Main.java
```

---

## 📋 CHECKLIST SAAT MEMBUAT DIAGRAM

- [ ] Semua class sudah ada?
- [ ] Setiap class ada attributes dan methods?
- [ ] Visibility modifier sudah benar? (-, #, +)
- [ ] Inheritance relationships jelas?
- [ ] Composition/Aggregation sudah ditandai?
- [ ] Multiplicity sudah ditandai (1:1, 1:*, *:*)?
- [ ] Interface/Implementation sudah ada?
- [ ] Tidak ada circular dependency?
- [ ] Diagram mudah dibaca dan clean?

---

## 🔧 TOOLS UNTUK MEMBUAT DIAGRAM

**Online Tools (Free):**
1. **Draw.io** (https://draw.io) - Best for quick diagram
2. **Lucidchart** (Free tier)
3. **PlantUML** (https://www.plantuml.com) - Text-based
4. **Miro** (Free tier)

**Desktop Tools:**
1. **Visual Paradigm Community Edition** - Powerful, free
2. **StarUML** - Popular di Asia SE
3. **Rational Rose** - Industry standard (berbayar)

**Enterprise Tools:**
1. **Enterprise Architect** - Complete modeling tool
2. **IBM Rational** - Industry leader

---

## 🎓 ADVANCED TIPS

### **1. Stereotype dalam Diagram**

```
<<interface>>    : Untuk interface
<<abstract>>     : Untuk abstract class
<<enumeration>>  : Untuk enum
<<singleton>>    : Untuk singleton pattern
<<controller>>   : Untuk controller (MVC)
<<utility>>      : Untuk utility class

Contoh:
┌──────────────────────┐
│ <<interface>>        │
│   Reportable         │
└──────────────────────┘
```

### **2. Package Diagram**

```
Mengelompokkan class ke dalam packages:

┌─── OOP ────────────┐
│ ├── Barang         │
│ ├── Elektronik     │
│ ├── Fashion        │
│ ├── Makanan        │
│ └── kategory       │
└────────────────────┘

┌─── Manager ─────────────┐
│ ├── Seller              │
│ ├── InventoryManager    │
│ └── Reportable          │
└────────────────────────┘
```

### **3. Sequence Diagram (Bonus)**

Menunjukkan urutan interaksi antar object:

```
Main  →  Manager  →  Seller  →  Barang
  │        │          │         │
  ├─search─→          │         │
  │        ├─search─→ │         │
  │        │        ├─search─→  │
  │        │        │←─found────│
  │        │←─found─┤           │
  │←─found─┤        │           │
```

---

## 💡 REAL WORLD EXAMPLE - DARI PROBLEM SAMPAI DIAGRAM

### **1. PROBLEM STATEMENT**

```
"Buat sistem e-commerce dengan fitur:
- Customer bisa browse product
- Customer bisa add ke cart
- Customer bisa checkout dan bayar
- Admin bisa manage inventory
- Sistem harus track order status"
```

### **2. ANALYSIS**

```
ENTITIES:
- Customer
- Product
- Cart
- Order
- OrderDetail
- Admin
- Payment
- Inventory

RELATIONSHIPS:
- 1 Customer : Many Order
- 1 Order : Many OrderDetail
- 1 Product : Many OrderDetail
- 1 Admin : Manage Many Inventory
```

### **3. CLASS DIAGRAM**

```
(Diagram akan sangat kompleks, lihat PDF untuk visual)

Classes:
- Customer (punya Cart, punya Order)
- Product (punya Inventory, punya OrderDetail)
- Cart (berisi CartItem)
- Order (berisi OrderDetail)
- Admin (manage Inventory)
- Payment (proses pembayaran)
- Inventory (track stok)
```

---

## 📝 PERATURAN INDUSTRI (SOP)

**Standar Industri untuk Class Diagram:**

1. ✅ **Naming Convention:**
   - Class: PascalCase (Customer, Product)
   - Attribute: camelCase (firstName, cartTotal)
   - Method: camelCase (getCustomer(), setPrice())

2. ✅ **Visibility:**
   - Public (+): Untuk interface/API
   - Private (-): Untuk internal logic
   - Protected (#): Untuk inheritance

3. ✅ **Documentation:**
   - Diagram harus ada legend/keterangan
   - Complex relationship harus ada note

4. ✅ **Size & Scope:**
   - 1 diagram ≤ 10-15 classes (agar readable)
   - Lebih banyak? Buat multiple diagrams per layer/module

5. ✅ **Version Control:**
   - Diagram di-versioning seperti code
   - Update setiap kali ada perubahan struktur

---

## ⏰ TIMELINE PEMBUATAN DIAGRAM

```
Untuk problem sedang (5-7 classes):
- Understanding problem: 15 menit
- Analisis struktur: 20 menit
- Draft diagram: 15 menit
- Refinement: 10 menit
Total: ~1 jam

Untuk problem kompleks (15+ classes):
- Understanding problem: 30 menit
- Analisis struktur: 45 menit
- Draft diagram: 60 menit
- Refinement & review: 30 menit
Total: ~3 jam
```

---

## 🎯 KEY TAKEAWAYS

1. **Class Diagram adalah blueprint kode Anda**
   - Sebelum koding, sudah jelas struktur?
   
2. **Diagram HARUS bisa dibaca orang lain**
   - Naming, layout, clarity adalah KEY
   
3. **Jangan over-detail dahulu**
   - Start simple, baru kompleks
   
4. **Diagram = Documentation**
   - Gunakan untuk review, maintenance, onboarding
   
5. **Update diagram seiring development**
   - Jangan biarkan diagram outdated
