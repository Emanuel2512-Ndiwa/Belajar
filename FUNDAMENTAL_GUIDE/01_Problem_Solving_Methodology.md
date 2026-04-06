# 📚 PROBLEM SOLVING METHODOLOGY
## Tahapan Sistematis Menyelesaikan Problem
**Referensi:** Books on Software Engineering - Sommerville, Pressman

---

## 🎯 5 TAHAPAN PROBLEM SOLVING (WAJIB!)

### **TAHAP 1: PROBLEM UNDERSTANDING (Pahami Masalah)**
**Durasi: 20-30% waktu total**

**Yang harus dilakukan:**
1. **Baca requirement 2-3x** (jangan langsung ngoding!)
2. **Identifikasi:**
   - Apa input yang diberikan?
   - Apa output yang diharapkan?
   - Apa constraint (batasan)?
   - Apa edge case (kasus khusus)?
3. **Tulis ulang dengan bahasa sendiri**
4. **Buat list requirements**

**Contoh - Problem Inventori:**
```
INPUT:
- Nama barang, harga, kategori, stok
- User input via menu

OUTPUT:
- Display barang dengan harga jual
- Laporan nilai inventori
- Search barang

CONSTRAINTS:
- Harga > 0
- Stok >= 0
- Diskon berbeda per kategori
- Harus support multiple seller

EDGE CASES:
- User input invalid?
- Barang tidak ditemukan?
- Stok kosong?
```

---

### **TAHAP 2: ANALYSIS (Analisis Masalah)**
**Durasi: 20-30% waktu total**

**Yang harus dilakukan:**
1. **Identifikasi Entity (Objek apa saja?)**
   - Apa benda/object yang ada di problem?
   - Apa properti/attribute setiap objek?
   - Apa behavior/method setiap objek?

2. **Identifikasi Relationship (Hubungan antar objek)**
   - Entity mana yang bertemu dengan entity mana?
   - Bagaimana cara mereka berelasi?
   - Berapa jumlahnya (1-to-1, 1-to-many, many-to-many)?

3. **Identifikasi Operasi (Apa yang bisa dilakukan?)**
   - Apa operation yang dibutuhkan?
   - CRUD? (Create, Read, Update, Delete)
   - Sorting, Filtering?
   - Calculation?

4. **Identifikasi Data Structure**
   - Data disimpan di mana?
   - Pake Array? ArrayList? HashMap?

**Contoh - Problem Inventori:**
```
ENTITIES:
┌─────────────────────────────────────┐
│ Barang                              │
├─────────────────────────────────────┤
│ - nama, harga, diskon               │
│ - pajak, stok                       │
├─────────────────────────────────────┤
│ - getNama(), getHarga()             │
│ - calculateSellingPrice()           │
│ - updateStok()                      │
└─────────────────────────────────────┘
         ▲ Inheritance
    ┌────┼────┬──────┐
    │    │    │      │
Elektronik Fashion Makanan


┌─────────────────────────────────────┐
│ Seller                              │
├─────────────────────────────────────┤
│ - nama, id, rating                  │
│ - inventori (ArrayList<Barang>)     │
├─────────────────────────────────────┤
│ - addBarang(), searchBarang()       │
│ - getTotalNilaiInventori()          │
└─────────────────────────────────────┘


┌─────────────────────────────────────┐
│ InventoryManager                    │
├─────────────────────────────────────┤
│ - sellers (ArrayList<Seller>)       │
├─────────────────────────────────────┤
│ - displayAllBarang()                │
│ - generateReport()                  │
│ - updateStokGlobal()                │
└─────────────────────────────────────┘

RELATIONSHIPS:
- 1 Seller memiliki BANYAK Barang (1-to-many)
- 1 InventoryManager mengelola BANYAK Seller (1-to-many)

OPERATIONS:
✓ CREATE: addBarang(), addSeller()
✓ READ: displayAllBarang(), searchBarang()
✓ UPDATE: updateStok()
✓ DELETE: (belum ada)
✓ REPORT: generateReport()

DATA STRUCTURE:
- ArrayList<Barang> → untuk menyimpan barang di Seller
- ArrayList<Seller> → untuk menyimpan seller di Manager
```

---

### **TAHAP 3: DESIGN (Desain Solusi)**
**Durasi: 20-30% waktu total**

**Yang harus dilakukan:**
1. **Identifikasi Design Pattern**
   - Apa pattern yang cocok?
   - Inheritance? Composition? Interface?

2. **Buat Class Diagram**
   - Lihat TAHAP 4 untuk detail

3. **Buat Method Specifications**
   - Setiap method apa input-nya?
   - Apa output-nya?
   - Apa logic-nya?

4. **Tentukan Algorithm & Pseudocode**
   - Pseudocode sebelum koding!

**Contoh - Problem Inventori:**
```
CLASS HIERARCHY:
abstract Barang
├── Elektronik (diskon 15%, pajak 10%)
├── Fashion (diskon 20%, pajak 8%)
└── Makanan (diskon 5%, pajak 5%)

DESIGN PATTERN:
- Inheritance: kategori product
- Polymorphism: calculateSellingPrice()
- Interface: Reportable
- Composition: Seller punya ArrayList<Barang>

METHOD SPEC - calculateSellingPrice():
Input: -
Output: double (harga jual)
Logic: Harga - (Harga × Diskon) + Pajak

Pseudocode:
```
function calculateSellingPrice():
    diskonAmount = harga × diskon
    hargaSetelahDiskon = harga - diskonAmount
    hargaFinal = hargaSetelahDiskon + pajak
    return hargaFinal
```

LOOPING STRATEGY:
- Display: FOR LOOP (index) + FOR-EACH (item) = NESTED
- Report: NESTED LOOP (kategori & barang)
- Search: FOR-EACH + break
```

---

### **TAHAP 4: IMPLEMENTATION (Implementasi Kode)**
**Durasi: 15-20% waktu total**

**Yang harus dilakukan:**
1. **Follow Design yang sudah dibuat**
2. **Code iteratively** (satu class per satu)
3. **Test setelah selesai satu class**
4. **Follow Coding Standards**
   - PascalCase untuk class
   - camelCase untuk method/variable
   - Meaningful names
   - Comments untuk public method

**Urutan Coding:**
```
1. abstract Barang (base)
2. Elektronik, Fashion, Makanan (extend)
3. Seller (use Barang)
4. InventoryManager (use Seller)
5. Main (UI & Menu)
```

---

### **TAHAP 5: TESTING & REFINEMENT (Testing & Perbaikan)**
**Durasi: 10-20% waktu total**

**Yang harus dilakukan:**
1. **Unit Test** - Test setiap class/method
2. **Integration Test** - Test antar class
3. **Edge Case Test** - Test kasus khusus
4. **Performance Test** - Ada bottleneck?
5. **Code Review** - Ada yang bisa diperbaiki?

**Test Cases:**
```
Test: Add barang dengan harga negatif
Expected: Error message, barang tidak ditambah

Test: Search barang yang tidak ada
Expected: Return null, display "not found"

Test: Update stok menjadi negatif
Expected: Error, stok tidak berkurang

Test: Report dengan 0 seller
Expected: Display "Tidak ada seller"

Test: Polymorphism - hitung harga jual berbeda kategori
Expected: Setiap kategori harga berbeda
```

---

## 📊 VISUALISASI 5 TAHAPAN

```
┌──────────────────────────────────────────────────────────┐
│         PROBLEM SOLVING TIMELINE (100% = Total waktu)   │
├──────────────────────────────────────────────────────────┤
│                                                          │
│ 1. UNDERSTANDING      [████████░░░░░░░░░░░░░░] 20-30%   │
│    ↓                                                     │
│ 2. ANALYSIS           [████████░░░░░░░░░░░░░░] 20-30%   │
│    ↓                                                     │
│ 3. DESIGN (DIAGRAM)   [████████░░░░░░░░░░░░░░] 20-30%   │
│    ↓                                                     │
│ 4. IMPLEMENTATION     [██████░░░░░░░░░░░░░░░░] 15-20%   │
│    ↓                                                     │
│ 5. TESTING            [██████░░░░░░░░░░░░░░░░] 10-20%   │
│                                                          │
│ ⚠️  JANGAN: Langsung ke step 4!                         │
│ ✅ HARUS: Tempuh semua tahap!                           │
└──────────────────────────────────────────────────────────┘
```

---

## ⚡ COMMON MISTAKES & HOW TO AVOID

| Kesalahan | Penyebab | Solusi |
|-----------|---------|--------|
| Langsung coding | Skip tahap analysis | Buat diagram dulu! |
| Design berubah-ubah | Tidak clear dari awal | Tulis requirements |
| Sulit debug kode | Tidak test per-unit | Test setiap method |
| Over-engineering | Terlalu banyak fitur | Follow requirement saja |
| Tidak reusable | Class tidak well-designed | Gunakan design pattern |

---

## 🎯 KESIMPULAN

**Sebelum Coding:**
1. ✅ Pahami problem dengan jelas
2. ✅ Analisis entity & relationship
3. ✅ Desain dengan diagram & pseudocode
4. ✅ Buat method specification

**Saat Coding:**
5. ✅ Follow design, test per-unit, refactor

**Jangan:**
❌ Langsung koding tanpa plan
❌ Ngoding sambil design
❌ Tidak test sebelum selesai semua

---

**Catatan:** 50% masalah solving terjadi di tahap 1-3. Jika tahap 1-3 jelas, tahap 4-5 akan smooth!
