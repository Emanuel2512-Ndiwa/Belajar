# 🎓 LATIHAN - PROBLEM SOLVING & CLASS DIAGRAM CREATION
## Untuk Membangun Skill Fundamental Anda
**Tingkat Kesulitan:** Beginner → Intermediate

---

## 📌 LATIHAN 1: SIMPLE LIBRARY SYSTEM (Beginner)

### **PROBLEM STATEMENT:**

```
Buat sistem perpustakaan sederhana dengan fitur:
- Perpustakaan punya banyak buku
- Setiap buku punya ISBN, judul, pengarang, tahun terbit
- Member bisa meminjam buku (max 3 buku)
- Member bisa mengembalikan buku
- Perpustakaan bisa lihat daftar buku yang tersedia
- Perpustakaan bisa lihat siapa saja yang meminjam buku apa
```

### **STEP 1: UNDERSTANDING (Pahami Masalah)**

**Tugas Anda:**
- [ ] Apa INPUT dalam sistem ini?
- [ ] Apa OUTPUT yang diharapkan?
- [ ] Apa CONSTRAINT yang ada?
- [ ] Apa EDGE CASES yang mungkin?

**Jawab di sini:**
```
INPUT:
- 

OUTPUT:
- 

CONSTRAINT:
- 

EDGE CASES:
- 
```

---

### **STEP 2: ANALYSIS (Analisis Masalah)**

**Tugas Anda:**
- [ ] Identifikasi ENTITIES (objek/benda apa saja)?
- [ ] Untuk setiap entity, tentukan ATTRIBUTES (data apa)?
- [ ] Untuk setiap entity, tentukan METHODS (operasi apa)?
- [ ] Identifikasi RELATIONSHIPS (hubungan antar entity)?

**Jawab di sini:**
```
ENTITIES:
1. 
2. 
3. 

ATTRIBUTES & METHODS:

Entity 1: 
├─ Attributes:
│  ├─ 
│  └─ 
├─ Methods:
│  ├─ 
│  └─ 

Entity 2:
├─ Attributes:
├─ Methods:

Entity 3:
├─ Attributes:
├─ Methods:

RELATIONSHIPS:
- Entity 1 & Entity 2: _____ (hubungan apa?)
- Entity 2 & Entity 3: _____ (hubungan apa?)
```

---

### **STEP 3: DESIGN (Desain Solusi)**

**Tugas Anda:**
- [ ] Tentukan CLASS hierarchy/structure
- [ ] Tentukan apa yang harus INHERIT, COMPOSE, atau INTERFACE
- [ ] Buat PSEUDOCODE untuk operasi utama

**Jawab di sini dengan membuat pseudo-code:**
```
Function pinjamBuku(member, buku):
    if member.jumlahPinjaman < 3 and buku.tersedia:
        // TODO: implement
    else:
        // Handle error
```

---

### **STEP 4: DRAW DIAGRAM (Buat Diagram Kelas)**

**Tugas Anda:**
- [ ] Gambar class diagram di Draw.io atau kertas
- [ ] Pastikan semua relationship jelas
- [ ] Pastikan multiplicity sudah ditandai

**Template (copy-paste ke Plain Text):**
```
┌─────────────────────┐
│      Buku          │
├─────────────────────┤
│ - isbn : String     │
│ - judul : String    │
│ - tersedia : boolean│
├─────────────────────┤
│ + getJudul()        │
│ + terpinjam()       │
└─────────────────────┘

(Lanjutkan untuk entity lain...)
```

---

### **STEP 5: REVIEW & REFLECTION**

**Tanya diri sendiri:**
- [ ] Apakah diagram saya bisa diterjemahkan ke code dengan jelas?
- [ ] Apakah ada entity yang ketinggalan?
- [ ] Apakah multiplicity benar?
- [ ] Apakah inheritance hierarchy logis?
- [ ] Apakah ada circular dependency?

---

### **BONUS: IMPLEMENTASI SEDERHANA**

Setelah diagram jadi, implementasikan dalam kode:

```java
// TODO: Implementasikan class-class sesuai diagram Anda
public class Buku {
    // ... your code here
}

public class Member {
    // ... your code here
}

public class Perpustakaan {
    // ... your code here
}
```

---

---

## 📌 LATIHAN 2: RENTAL VEHICLE SYSTEM (Intermediate)

### **PROBLEM STATEMENT:**

```
Buat sistem rental kendaraan dengan fitur:
- Rental agency punya banyak kendaraan (Mobil, Motor, Truk)
- Setiap kendaraan punya license plate, merk, tipe, tahun, status (tersedia/dipinjam)
- Customer bisa rental kendaraan
- Customer bisa kembalikan kendaraan
- Setiap jenis kendaraan punya harga rental per hari BERBEDA
- Sistem bisa hitung total biaya rental
- Sistem bisa lihat laporan: berapa kendaraan yang dipinjam, berapa total revenue hari ini
```

### **STEP 1-2: UNDERSTANDING & ANALYSIS**

**Tugas Anda: Lengkapi requirement analysis**

```
ENTITIES YANG DIPERLUKAN:
1. Kendaraan (dengan subtype: Mobil, Motor, Truk)
2. ? (customer related)
3. ? (rental related)
4. ? (report/manager related)

ATTRIBUTES YANG DIPERLUKAN:
- Kendaraan: _____, _____, _____
- Customer: _____, _____, _____
- Rental: _____, _____, _____

OPERATIONS YANG DIPERLUKAN:
- Rental: _____, _____, _____
- Agency: _____, _____, _____

RELATIONSHIPS:
- Agency & Kendaraan: 1 agency : many kendaraan
- Customer & Rental: 1 customer : many rental
- Kendaraan & Rental: ? (satu kendaraan bisa dirental berkali-kali)
- Rental & ?: (untuk hitung biaya)
```

---

### **STEP 3-4: DESIGN & DIAGRAM**

**Pertanyaan Design:**
1. Apakah `Mobil`, `Motor`, `Truk` harus INHERIT dari `Kendaraan`?
   - Alasan:
   
2. Bagaimana cara implement "harga berbeda per tipe"?
   - Pake inheritance + polymorphism? Pake field? Pake interface?
   - Pilihan saya: _______ karena _________
   
3. Bagaimana data RENTAL disimpan?
   - Apakah di Kendaraan? Di Customer? Di RentalAgency?
   - Pilihan saya: _______ karena _________

**Tugas Anda:**
- [ ] Buat class diagram lengkap (minimum 5 classes)
- [ ] Jelaskan setiap relationship
- [ ] Identifikasi method abstract vs concrete
- [ ] Tentukan apa yang MUST implement interface

---

### **STEP 5: PSEUDOCODE & LOGIC**

Tulis pseudocode untuk operasi penting:

```
Function rentalKendaraan(customer, kendaraan, hariRental):
    if kendaraan.status == TERSEDIA:
        // TODO: Create rental object
        // TODO: Update kendaraan status
        // TODO: Calculate total biaya = harga_per_hari * hariRental
    else:
        return "Kendaraan tidak tersedia"

Function likuidasiRental(rental):
    // TODO: Update kendaraan status back to TERSEDIA
    // TODO: Calculate actual cost
    // TODO: Process payment
    // TODO: Record transaction
```

---

---

## 📌 LATIHAN 3: ONLINE LEARNING PLATFORM (Intermediate+)

### **PROBLEM STATEMENT:**

```
Buat sistem e-learning dengan fitur:
- Platform punya banyak COURSE
- Setiap course punya INSTRUCTOR
- Setiap course berisi LESSONS & QUIZZES
- STUDENT bisa enroll ke course
- STUDENT bisa submit assignment
- INSTRUCTOR bisa grade assignment
- Sistem tracking progress student (% completion)
- Sistem generate report: top students, course popularity, instructor rating
```

**Ini adalah problem yang kompleks! Hanya untuk latihan lanjutan.**

### **CHALLENGE:**

- [ ] Identifikasi MINIMUM 8-10 entities yang diperlukan
- [ ] Tentukan mana yang ABSTRACT, mana yang CONCRETE
- [ ] Tentukan relationship (1:1, 1:*, *:*, inheritance)
- [ ] Identifikasi yang bisa implement INTERFACE
- [ ] Tentukan LOOPING strategy (untuk display reports)
- [ ] Buat class diagram dengan 10+ classes
- [ ] Jelaskan design decision Anda

---

---

## 🔑 SOLUTION & REFERENCE

### **LATIHAN 1 SOLUTION - LIBRARY SYSTEM**

```
ENTITIES:
1. Buku
2. Member
3. Peminjaman
4. Perpustakaan

CLASS DIAGRAM (TEXT):

┌─────────────────────────────┐
│          Buku              │
├─────────────────────────────┤
│ - isbn : String             │
│ - judul : String            │
│ - pengarang : String        │
│ - tahunTerbit : int         │
├─────────────────────────────┤
│ + getJudul() : String       │
│ + isbnGetISBN() : String    │
└─────────────────────────────┘
              ▲
              │ "banyak buku"
              │ 1 : *
              │●

┌─────────────────────────────┐
│       Member               │
├─────────────────────────────┤
│ - idMember : String        │
│ - nama : String            │
│ - email : String           │
├─────────────────────────────┤
│ + pinjamBuku()             │
│ + kembalikanBuku()         │
└─────────────────────────────┘
         │
         │ "meminjam 0-3 buku"
         │ 1 : 0..3
         ●───→

┌─────────────────────────────┐
│      Peminjaman            │
├─────────────────────────────┤
│ - tglPinjam : Date         │
│ - tglKembali : Date        │
│ - status : String          │
├─────────────────────────────┤
│ + hitungDendaKeterlambatan()│
└─────────────────────────────┘

┌─────────────────────────────┐
│     Perpustakaan           │
├─────────────────────────────┤
│ - nama : String            │
│ - alamat : String          │
├─────────────────────────────┤
│ + displayBukuTersedia()     │
│ + displayPeminjamanAktif()  │
│ + generateLaporan()         │
└─────────────────────────────┘

KEY DESIGN DECISION:
- Buku & Peminjaman separate class (karena 1 buku bisa dipinjam berkali-kali)
- Peminjaman "belongs to" Member & Buku
- Perpustakaan adalah aggregate yang manage semuanya
```

**Untuk solution lengkap Latihan 2 & 3, lihat PDF companion file.**

---

---

## 💪 TIPS SUKSES LATIHAN

**DO:**
✅ Pahami problem sebelum buat diagram
✅ Bikin draft kasar dulu (di kertas/whiteboard)
✅ Minta review dari mentor/senior
✅ Iterasi & refactor diagram
✅ Implementasikan & test

**DON'T:**
❌ Langsung buat diagram perfect di tools
❌ Overly complex di awal
❌ Lupa constraint & requirement
❌ Copy solution tanpa understand
❌ Lupa document design decision

---

## 📈 PROGRESSION PATH

```
WEEK 1: Latihan 1 (Library System)
├─ Focus: Basic entity identification
├─ Focus: Simple inheritance
└─ Difficulty: ⭐ Beginner

WEEK 2: Latihan 1 Review + Implementasi
├─ Focus: Code design pattern
├─ Focus: Encapsulation
└─ Difficulty: ⭐ Beginner

WEEK 3: Latihan 2 (Rental System)
├─ Focus: Complex relationships
├─ Focus: Polymorphism
├─ Focus: Business logic
└─ Difficulty: ⭐⭐ Intermediate

WEEK 4: Latihan 2 Review + Implementasi
├─ Focus: CRUD operations
├─ Focus: Reporting logic
└─ Difficulty: ⭐⭐ Intermediate

WEEK 5-6: Latihan 3 (E-Learning Platform)
├─ Focus: Complex domain model
├─ Focus: Multiple relationships
├─ Focus: Aggregate root
└─ Difficulty: ⭐⭐⭐ Advanced

WEEK 7: Review semua + real-world project
└─ Apply ke existing project Anda!
```

---

## 🎯 FINAL PROJECT CHALLENGE

**Setelah selesai 3 latihan, silakan apply skills Anda:**

1. **Ambil salah satu project dari workspace Anda:**
   - ECommerce system
   - Employee management
   - Portfolio project apa pun

2. **Buat Class Diagram yang PROPER:**
   - Lengkap dengan semua class
   - Lengkap dengan relationship
   - Lengkap dengan multiplicity
   - Lengkap dengan visibility modifier

3. **Review dengan SOP Industri:**
   - Apakah design bisa di-maintain?
   - Apakah scalable?
   - Apakah follow SOLID principles?

4. **Dokumentasi:**
   - Jelaskan setiap design decision
   - Explain alternative approaches
   - Document trade-offs

**Target:** Diagram yang bisa Anda tunjukkan ke senior/mentor tanpa malu!

---

**Good luck dengan latihan Anda! 🚀**
