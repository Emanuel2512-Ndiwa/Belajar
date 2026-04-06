# 📘 JAVA FUNDAMENTALS - PANDUAN LENGKAP

**Status:** Panduan Pembelajaran Komprehensif  
**Level:** Beginner to Intermediate  
**Target Audience:** Pemula yang ingin memahami Java secara mendalam

---

## 📑 DAFTAR ISI

1. [Pengenalan Java dan Ekosistemnya](#pengenalan)
2. [Cara Kerja Java - JVM, JRE, JDK](#cara-kerja-java)
3. [Compiler, Bytecode, dan Execution](#compiler-bytecode)
4. [Memory Management - Stack dan Heap](#memory-management)
5. [Garbage Collection](#garbage-collection)
6. [Data Types & Variables](#data-types)
7. [Object Oriented Programming (OOP)](#oop)
8. [Inheritance & Polymorphism](#inheritance)
9. [Encapsulation & Access Modifiers](#encapsulation)
10. [Interface dan Abstract Class](#interface)

---

## <a name="pengenalan"></a>1. PENGENALAN JAVA DAN EKOSISTEMNYA

### 🌍 Apa itu Java?

Java adalah sebuah **bahasa pemrograman** yang bersifat **Object-Oriented** dan dirancang dengan filosofi **"Write Once, Run Anywhere" (WORA)**. Artinya, kode Java yang kita tulis bisa dijalankan di mana saja selama ada JVM (Java Virtual Machine).

Konteks java di antara bahasa pemrograman lain:
```
┌─────────────────────────────────────────────┐
│      BAHASA PEMROGRAMAN DI DUNIA             │
├─────────────────────────────────────────────┤
│ • C++ (Low-level, close to hardware)        │
│ • Python (Simple, readable, high-level)     │
│ • JavaScript (Web-focused)                  │
│ • Java ⭐ (Universal, OOP-strong, enterprise) │
│ • C# (Microsoft ecosystem)                  │
│ • Go, Rust (Modern languages)               │
└─────────────────────────────────────────────┘
```

Java **paling populer di enterprise** karena:
- Object-Oriented (support full OOP concepts)
- Platform independent
- Robust dan secure
- Punya ecosystem besar (libraries, frameworks)
- Backward compatible (kode lama tetap jalan)

---

## <a name="cara-kerja-java"></a>2. CARA KERJA JAVA - JVM, JRE, JDK

Ini adalah hal PALING PENTING untuk dipahami. Banyak orang bingung tentang JVM, JRE, dan JDK. Mari kita jelaskan secara bertahap.

### 🏗️ Arsitektur Java Stack

```
┌─────────────────────────────────────────────────────┐
│              IDE / Text Editor                      │
│         (IntelliJ, Eclipse, VSCode)                 │
├─────────────────────────────────────────────────────┤
│       JDK (Java Development Kit)                    │
│  ├─ Compiler (javac) - mengubah .java jadi .class  │
│  ├─ Tools (jar, javadoc, dll)                       │
│  ├─ JRE (sudah termasuk di dalamnya)                │
├─────────────────────────────────────────────────────┤
│       JRE (Java Runtime Environment)                │
│  ├─ JVM (Java Virtual Machine)                      │
│  ├─ Standard Library (Java Classes/API)             │
├─────────────────────────────────────────────────────┤
│              OS (Windows, Mac, Linux)               │
│         (Hardware underlying)                       │
└─────────────────────────────────────────────────────┘
```

### 🔄 Perbedaan JDK, JRE, dan JVM

```
┌──────────────────┬──────────────────┬──────────────────┐
│       JDK        │       JRE        │       JVM        │
├──────────────────┼──────────────────┼──────────────────┤
│ Development Kit  │ Runtime Only     │ Virtual Machine  │
├──────────────────┼──────────────────┼──────────────────┤
│ Untuk develop    │ Untuk run        │ Untuk execute    │
│ (buat & compile) │ (jalankan saja)   │ bytecode         │
├──────────────────┼──────────────────┼──────────────────┤
│ Include compiler │ Tidak ada         │ Part of JRE      │
│ (javac)          │ compiler          │                  │
├──────────────────┼──────────────────┼──────────────────┤
│ Include JRE      │ Include JVM       │ Yang actual      │
│                  │                  │ interpret        │
├──────────────────┼──────────────────┼──────────────────┤
│ Tools: jar,      │ No tools for      │ No tools         │
│ javadoc, dll     │ development       │                  │
└──────────────────┴──────────────────┴──────────────────┘
```

### 📝 Alur Sederhana

```
1. Programmer (Kita) menulis code Java:
   ├─ File: App.java
   └─ Berisi: code yang bisa dibaca manusia

2. JDK Compiler (javac) mengcompile:
   ├─ Input: App.java
   ├─ Proses: Translasi ke bytecode
   └─ Output: App.class (bytecode)

3. JRE menjalankan bytecode:
   ├─ JVM membaca App.class
   ├─ Proses: Translate bytecode ke machine language
   └─ Output: Program berjalan

4. OS dan Hardware eksekusi:
   └─ Actual execution di processor
```

### 💡 Analogi Mudah

Bayangkan begini:

**Kita = Manusia India**  
**Java Code = Bahasa Hindi**  
**Compiler = Penerjemah Hindi→English**  
**Bytecode = Bahasa Inggris**  
**JVM = Penerjemah Inggris→Bahasa lokal (Jawa, Padang, dll)**  
**Machine Code = Bahasa lokal**  
**Computer = Orang lokal yang ngerti bahasa lokalnya**

Kenapa begini? Karena:
- Kita nulis code di Java (bahasa tingkat tinggi yang mudah)
- Compiler terjemahkan ke bytecode (intermediate format)
- JVM terjemahkan lagi ke machine code (binary 0 dan 1)
- Computer baru bisa ngerti dan jalankan

---

## <a name="compiler-bytecode"></a>3. COMPILER, BYTECODE, DAN EXECUTION

### 🔧 Apa itu Compiler?

**Compiler adalah sebuah program** yang membaca kode Java (bahasa tingkat tinggi) dan mengubahnya menjadi **bytecode** (intermediate representation yang bisa dipahami JVM).

Compiler itu tugasnya:
1. ✅ **Syntax checking** - apakah kode sudah benar secara grammar
2. ✅ **Semantic analysis** - apakah kode sudah benar secara logic
3. ✅ **Code generation** - generate bytecode yang equivalent
4. ✅ **Optimization** - optimasi kode (dalam batas tertentu)

### 📦 Apa itu Bytecode?

**Bytecode adalah intermediate language** yang bukan binary murni (0 dan 1) tapi sudah lebih dekat ke mesin dari Java source code.

Karakteristik bytecode:
- **Platform independent** - sama untuk semua OS
- **Not directly executable** - harus dijalankan JVM
- **Compact** - lebih kecil dari source code
- **Verifiable** - JVM bisa verify keamanannya sebelum jalankan

```
Contoh Java Code:
┌─────────────────────────────┐
│ int x = 5;                  │
│ int y = 10;                 │
│ int z = x + y;              │
└─────────────────────────────┘
          ↓ (Compiler)
Bytecode (simplified):
┌─────────────────────────────┐
│ BIPUSH 5       (push 5)     │
│ ISTORE 1       (store ke x) │
│ BIPUSH 10      (push 10)    │
│ ISTORE 2       (store ke y) │
│ ILOAD 1        (load x)     │
│ ILOAD 2        (load y)     │
│ IADD           (add)        │
│ ISTORE 3       (store ke z) │
└─────────────────────────────┘
          ↓ (JVM)
Machine Code (0 dan 1):
┌─────────────────────────────┐
│ 01010110 10101010           │
│ 10101010 11110000           │
│ ... (seterusnya)            │
└─────────────────────────────┘
```

### 🏃 Execution Flow (Alur Eksekusi)

```
┌────────────────────────────────────────────────────────┐
│ 1. COMPILE TIME (saat kita nulis dan compile)          │
├────────────────────────────────────────────────────────┤
│                                                        │
│  $ javac App.java                                      │
│         ↓                                              │
│    [Compiler baca App.java]                            │
│         ↓                                              │
│    [Check syntax & semantic]                           │
│         ↓                                              │
│    [Generate App.class dengan bytecode]                │
│         ↓                                              │
│    App.class created ✓                                 │
│                                                        │
└────────────────────────────────────────────────────────┘
        ↓ (Hari kemudian, bulan kemudian, tahun kemudian)
┌────────────────────────────────────────────────────────┐
│ 2. RUNTIME (saat kita jalankan program)                │
├────────────────────────────────────────────────────────┤
│                                                        │
│  $ java App                                            │
│         ↓                                              │
│    [JVM baca App.class]                                │
│         ↓                                              │
│    [Verify bytecode - aman?]                           │
│         ↓                                              │
│    [JIT Compiler mengubah bytecode ke machine code]    │
│         ↓                                              │
│    [CPU jalankan machine code]                         │
│         ↓                                              │
│    Program berjalan ✓                                  │
│                                                        │
└────────────────────────────────────────────────────────┘
```

### 🎯 Key Point

**Compiler dan JVM terpisah dan bekerja di waktu berbeda:**
- Compiler hanya kerja saat **COMPILE TIME** (.java → .class)
- JVM bekerja saat **RUNTIME** (.class → executing)

Makanya kita bisa compile App.java di laptop Windows, kirim App.class ke server Linux, dan dia bisa langsung jalan. **Sekali compile, bisa jalankan di mana saja** (WORA).

---

## <a name="memory-management"></a>4. MEMORY MANAGEMENT - STACK DAN HEAP

Ini adalah konsep yang PALING PENTING dan paling sering salah dipahami. Mari kita jelaskan dengan detail.

### 🏗️ Struktur Memory Java

```
                    MEMORY JAVA
┌─────────────────────────────────────────┐
│                 STACK                   │
│  ┌─────────────────────────────────┐   │
│  │ • Primitive values (int, bool)  │   │
│  │ • Object references (pointers)  │   │
│  │ • Method calls (call stack)     │   │
│  │ • Local variables               │   │
│  │                                 │   │
│  │ Size: TERBATAS (kecil)          │   │
│  │ Freed: OTOMATIS (method return) │   │
│  │ Speed: SANGAT CEPAT             │   │
│  │ Thread: TIAP THREAD PUNYA STACK │   │
│  │ Problem: StackOverflowError     │   │
│  └─────────────────────────────────┘   │
├─────────────────────────────────────────┤
│                 HEAP                    │
│  ┌─────────────────────────────────┐   │
│  │ • Objects (instances)           │   │
│  │ • Array (semua isinya)          │   │
│  │ • String                        │   │
│  │ • Setiap referensi type         │   │
│  │                                 │   │
│  │ Size: BESAR (besar sekali)      │   │
│  │ Freed: GARBAGE COLLECTOR        │   │
│  │ Speed: LEBIH LAMBAT             │   │
│  │ Thread: SHARED (semua thread)   │   │
│  │ Problem: OutOfMemoryError       │   │
│  └─────────────────────────────────┘   │
└─────────────────────────────────────────┘
```

### 📊 Perbedaan Stack vs Heap

```
┌──────────────┬───────────────────┬─────────────────┐
│   ASPEK      │      STACK        │      HEAP       │
├──────────────┼───────────────────┼─────────────────┤
│ Menyimpan    │ Primitives        │ Objects (semua  │
│              │ References        │ referensi types)│
├──────────────┼───────────────────┼─────────────────┤
│ Ukuran       │ Kecil (~10MB)     │ Besar (bisa GB) │
├──────────────┼───────────────────┼─────────────────┤
│ Kecepatan    │ ⚡ Sangat cepat   │ 🐢 Lebih lambat │
├──────────────┼───────────────────┼─────────────────┤
│ Deallocation │ Otomatis saat     │ Garbage         │
│              │ method return     │ Collector       │
├──────────────┼───────────────────┼─────────────────┤
│ Thread-safe  │ Tiap thread      │ Shared, butuh   │
│              │ punya sendiri     │ synchronization │
├──────────────┼───────────────────┼─────────────────┤
│ Error        │ Stack             │ Out Of Memory   │
│              │ OverflowError     │ Error           │
└──────────────┴───────────────────┴─────────────────┘
```

### 💡 PENJELASAN DETAIL (GAYA ANDA)

Mari kita jelaskan dengan contoh yang sama yang Anda gunakan:

#### **Contoh 1: Array dengan Primitive**

```java
int[] nama = {10, 20, 30};
String[] nama_orang = {"Eman", "Roganta", "Siti"};
```

Ini yang terjadi di belakang:

```
┌─────────────────────────────────┐
│         STACK (10MB)            │
├─────────────────────────────────┤
│                                 │
│  nama ─────┐                    │
│  (ref)     │                    │
│            │ (menunjuk ke)      │
│  nama_org  │ (reference/       │
│  (ref)     │  alamat pointer)  │
│            │                    │
└─────────────────────────────────┘
             ↓
┌─────────────────────────────────┐
│     HEAP (besar sekali)         │
├─────────────────────────────────┤
│                                 │
│ Array [int] @0x12345           │
│  [0] = 10                       │
│  [1] = 20                       │
│  [2] = 30                       │
│                                 │
│ Array [String] @0x67890        │
│  [0] → "Eman"  @0xABC00        │
│  [1] → "Roganta" @0xDEF00      │
│  [2] → "Siti"   @0x1AB00      │
│                                 │
│ String objects:                 │
│  "Eman"  @0xABC00              │
│  "Roganta" @0xDEF00           │
│  "Siti"  @0x1AB00              │
│                                 │
└─────────────────────────────────┘
```

**Breakdown:**
- `nama`, `nama_orang` itu adalah REFERENCE → ada di STACK (kecil, cepat diakses)
- Actual array object `{10, 20, 30}` → ada di HEAP
- Actual String objects "Eman", "Roganta", "Siti" → ada di HEAP
- Ketika method selesai, STACK cleared otomatis, tapi Heap masih ada sampai GC datang

#### **Contoh 2: Object Custom**

```java
class Tas {
    String nama;
    int kapasitas;
}

Tas tas1 = new Tas();
Tas tas2 = tas1;
tas1.nama = "Ransel";
```

Memory state:

```
STACK:
┌─────────────┐
│ tas1 ───┐   │ (reference/alamat)
│ tas2 ───┤   │ (reference/alamat - SAMA dengan tas1)
└─────────────┘
              ↓ (keduanya menunjuk ke object yang sama)
HEAP:
┌─────────────────────────────┐
│ Tas Object @0x4C3F50       │
│  ├─ nama: "Ransel"  @x... │
│  └─ kapasitas: 0          │
└─────────────────────────────┘

Hasil: tas1.nama dan tas2.nama keduanya "Ransel" (sama object!)
```

**Key insight:** `tas1 = tas2` itu copy REFERENCE, bukan copy object!

---

## <a name="garbage-collection"></a>5. GARBAGE COLLECTION

### 🗑️ Apa itu Garbage Collection?

**Garbage Collection (GC) adalah automatic memory management system** yang menghapus object di Heap yang tidak digunakan lagi.

Kenapa butuh GC?
- Programmer sering lupa hapus object (unlike C yang butuh manual `free()`)
- Bisa jadi memory leak kalau tidak ditangani
- Java ingin fokus pada logic, bukan memory management

### 🔍 Cara Kerja GC

```
┌────────────────────────────────────────────┐
│ SEBELUM GC                                 │
├────────────────────────────────────────────┤
│                                            │
│ STACK:                                     │
│  obj1 ──┐                                  │
│  obj2 ──┼────→ HEAP Objects                │
│         │                                  │
│  ┌──────────────────────────────────┐     │
│  │ Obj A (referenced by obj1) ✓    │     │
│  │ Obj B (referenced by obj2) ✓    │     │
│  │ Obj C (NOT referenced) ✗ GARBAGE│     │
│  │ Obj D (NOT referenced) ✗ GARBAGE│     │
│  └──────────────────────────────────┘     │
│                                            │
│ Memory used: PENUH dengan garbage         │
│                                            │
└────────────────────────────────────────────┘
             ↓ (GC runs)
┌────────────────────────────────────────────┐
│ SESUDAH GC                                 │
├────────────────────────────────────────────┤
│                                            │
│ STACK:                                     │
│  obj1 ──┐                                  │
│  obj2 ──┼────→ HEAP Objects                │
│         │                                  │
│  ┌──────────────────────────────────┐     │
│  │ Obj A (referenced by obj1) ✓    │     │
│  │ Obj B (referenced by obj2) ✓    │     │
│  │ [FREE SPACE]                     │     │
│  │ [FREE SPACE]                     │     │
│  └──────────────────────────────────┘     │
│                                            │
│ Memory recovered: Obj C dan D dihapus     │
│                                            │
└────────────────────────────────────────────┘
```

### 📝 Stages of GC

**GC tidak selalu jalan real-time. Ada fase-fase:**

1. **Mark Phase**
   - GC identify semua objects yang masih "live" (ada reference dari Stack)
   - Objects lain ditandai untuk dihapus

2. **Sweep Phase**
   - GC menghapus objects yang sudah ditandai
   - Membebaskan memory di heap

3. **Compact Phase** (optional)
   - Reorganize memory untuk hindari fragmentation
   - Membuat memory lebih efisien

```
Contoh dalam code:

public static void main(String[] args) {
    // Line 1
    String s1 = "Hello";  // Object String di heap
    String s2 = "World";  // Object String baru di heap
    
    // Line 4
    s1 = null;  // Reference s1 sekarang null
                // "Hello" object TIDAK bisa diakses lagi
    
    // Line 7 - "Hello" object adalah GARBAGE (bisa dihapus GC)
    System.gc();  // Suggest GC, tapi tidak guarantee
    
    // ... nanti waktu GC run, "Hello" object dihapus
    // Memory freed
}
```

### ⚠️ Penting tentang GC

```
1. UNPREDICTABLE
   └─ Kita tidak tahu kapan GC akan jalan
   └─ System.gc() hanya SUGGEST, tidak guarantee
   └─ Bisa jalan saat program idle atau memory penuh

2. CAN CAUSE PAUSE (Stop The World)
   └─ Saat GC jalan, seluruh program PAUSE
   └─ Tidak bisa jalankan code selama GC
   └─ Ini disebut GC Pause atau Stop The World Event

3. NECESSARY EVIL
   └─ Automatic management itu convenience
   └─ Tapi performa bisa terasa lag karena GC pause
   └─ Ini trade-off: convenience vs performance

4. NOT MEAN MEMORY LEAK CANNOT HAPPEN
   └─ Meskipun ada GC, tetap bisa memory leak
   └─ Contoh: Circular reference, static collections
```

### 🎯 Memory Leak di Java (GC bukan magic!)

```java
// CONTOH MEMORY LEAK meskipun ada GC

// Leak 1: Static Collection
public class Holder {
    static List<String> list = new ArrayList<>();
    
    public void addData(String data) {
        list.add(data);  // Strings ditambah terus
                         // Jarang dihapus
                         // Eventually OutOfMemory
    }
}

// Leak 2: Yang lupa remove listener
public class EventManager {
    static List<Listener> listeners = new ArrayList<>();
    
    public void register(Listener l) {
        listeners.add(l);  // Add tapi tidak pernah remove
    }
}

// Leak 3: Circular reference (jarang sekarang, tapi possible)
public class Node {
    Node parent;
    Node child;
    
    // Jika parent → child dan child → parent
    // Mereka saling reference, tidak bisa GC
}
```

---

## <a name="data-types"></a>6. DATA TYPES & VARIABLES

### 📦 Apa itu Variable?

**Variable adalah container/wadah untuk menyimpan data**. di Java, setiap variable harus punya type.

### 🎯 Types in Java

```
┌──────────────────────────────────────────────────────┐
│              JAVA DATA TYPES                         │
├──────────────────────────────────────────────────────┤
│                                                      │
│  PRIMITIVE TYPES (8 buah)                           │
│  ├─ Numeric:                                        │
│  │  ├─ Integer: byte, short, int, long              │
│  │  └─ Floating: float, double                      │
│  ├─ Character: char                                 │
│  └─ Boolean: boolean                                │
│                                                      │
│  REFERENCE TYPES (Non-primitive)                    │
│  ├─ Classes (custom classes)                        │
│  ├─ Arrays                                          │
│  ├─ Strings                                         │
│  ├─ Interfaces                                      │
│  ├─ Enums                                           │
│  └─ dll                                             │
│                                                      │
└──────────────────────────────────────────────────────┘
```

### 💾 Primitive vs Reference

```
┌──────────────┬──────────────────┬─────────────────┐
│   ASPEK      │    PRIMITIVE      │    REFERENCE    │
├──────────────┼──────────────────┼─────────────────┤
│ Storage      │ STACK             │ Reference di    │
│              │ (value langsung)  │ STACK, object   │
│              │                  │ di HEAP         │
├──────────────┼──────────────────┼─────────────────┤
│ Comparison   │ == membanding     │ == membanding   │
│              │ VALUE             │ REFERENCE       │
│              │ int a=5, b=5      │ obj1==obj2      │
│              │ a==b → true ✓     │ banding address │
├──────────────┼──────────────────┼─────────────────┤
│ Assignment   │ Copy VALUE        │ Copy REFERENCE  │
│              │ int x=5, y=x      │ obj1=obj2       │
│              │ x dan y berbeda   │ obj1,obj2 menunjuk
│              │                  │ object yang sama │
├──────────────┼──────────────────┼─────────────────┤
│ Default      │ 0, false, etc     │ null            │
│ Value        │                  │                 │
├──────────────┼──────────────────┼─────────────────┤
│ Null         │ ✗ TIDAK bisa      │ ✓ BISA          │
│              │ null              │ null            │
└──────────────┴──────────────────┴─────────────────┘
```

### 🔄 Pass by Value vs Pass by Reference

Ini yang sering bikin bingung. Inget:

**DI JAVA: SELALU PASS BY VALUE DARI PARAMETER**

Maksudnya:
```java
// PRIMITIVE
int x = 5;
void update(int num) {
    num = 100;  // Mengubah copy, x tetap 5
}
update(x);
System.out.println(x);  // Output: 5 (tidak berubah)

---

// REFERENCE TYPE (Object)
List<String> list = new ArrayList<>();
list.add("Hello");

void modify(List<String> l) {
    l.add("World");  // Menambah ke OBJECT (shared)
}
modify(list);
System.out.println(list);  // Output: [Hello, World] (BERUBAH!)

---

// TAPI jika reassign reference:
void reassign(List<String> l) {
    l = new ArrayList<>();  // Hanya mengubah local reference
    l.add("Baru");
}
reassign(list);
System.out.println(list);  // Output: [Hello, World] (tidak berubah)
```

**Penjelasan:**
- Parameter yang kita kirim itu "**value** dari variable"
- Untuk primitive: value-nya adalah data langsung (5, "hello")
- Untuk object: value-nya adalah reference (pointer/alamat)
- Jadi kita copy reference, bukan copy object

Analogi: "Pass by value dari reference object"

---

## <a name="oop"></a>7. OBJECT ORIENTED PROGRAMMING (OOP)

### 🎯 Apa itu OOP?

**OOP adalah paradigma programming yang mengorganisir code dengan konsep object dan class**. Tujuannya membuat code lebih modular, reusable, dan mudah dikelola.

Filosofi: "Dunia itu terdiri dari objects. Setiap object punya state (property) dan behavior (method)."

### 📚 Konsep Inti OOP (4 Pilar)

```
┌──────────────────────────┐
│     4 PILAR OOP          │
├──────────────────────────┤
│ 1. Encapsulation ⭐      │
│ 2. Abstraction ⭐⭐      │
│ 3. Inheritance ⭐        │
│ 4. Polymorphism ⭐⭐     │
└──────────────────────────┘
```

### 🔶 1. CLASS vs OBJECT

Mari kita jelaskan dengan detail seperti penjelasan Anda:

#### **CLASS = BLUEPRINT/CETAK**

Analogi: **Sebuah blueprint rumah**
- Architect membuat blueprint (1 blueprint saja)
- Blueprint itu jadi template untuk semua rumah

```java
// CLASS: Blueprint tas
public class Tas {
    // PROPERTIES (Attributes)
    String nama;
    int kapasitas;
    
    // METHODS (Behaviors)
    void simpanBarang(String barang) {
        System.out.println("Menyimpan: " + barang);
    }
    
    void keluarkanBarang(String barang) {
        System.out.println("Mengeluarkan: " + barang);
    }
}
```

**Karakteristik Class:**
- Hanya 1 class "Tas" di code kita
- Bukan real, abstract, idenya saja
- Template/blueprint untuk membuat object

#### **OBJECT = INSTANCE/REALISASI**

Analogi: **Rumah fisik yang dibangun dari blueprint**
- Ada banyak rumah dibangun dari satu blueprint
- Setiap rumah punya warna berbeda, lokasi berbeda, tapi struktur sama

```java
// OBJECT: Instance dari class Tas
Tas tas1 = new Tas();
tas1.nama = "Ransel Lipat";
tas1.kapasitas = 50;

Tas tas2 = new Tas();
tas2.nama = "Sleep Bag Outdoor";
tas2.kapasitas = 100;

Tas tas3 = new Tas();
tas3.nama = "Backpack Travel";
tas3.kapasitas = 75;
```

**Karakteristik Object:**
- Bisa banyak object dari 1 class
- Real, actual, ada di memory
- Each object punya state sendiri
- Instance dari class

#### **Visualisasi:**

```
CLASS (Blueprint):
┌─────────────────────────────┐
│      Class Tas              │
├─────────────────────────────┤
│ Properties:                 │
│  - nama: String             │
│  - kapasitas: int           │
│                             │
│ Methods:                    │
│  - simpanBarang()           │
│  - keluarkanBarang()        │
└─────────────────────────────┘
          ↓ (instantiation)
         (new Tas())
          ↓ ↓ ↓ (bisa banyak)
┌──────────┬────────────┬────────────────┐
│ OBJECT 1 │ OBJECT 2   │ OBJECT 3       │
├──────────┼────────────┼────────────────┤
│ Ransel   │ Sleep Bag  │ Backpack       │
│ 50       │ 100        │ 75             │
└──────────┴────────────┴────────────────┘
```

### 🔶 2. ENCAPSULATION (PEMBUNGKUS)

#### **Definisi:**
**Encapsulation adalah teknik untuk membungkus data (properties) dan method dalam satu unit, serta melindungi data dari akses langsung.**

#### **Analogi Anda: OBAT DALAM KAPSUL ✓ PERFECT**

```
Obat Sakit Kepala:
┌────────────────────────────┐
│    KAPSUL (Pembungkus)      │
├────────────────────────────┤
│ Isi kapsul (Private):       │
│  - Paracetamol 500mg        │
│  - Caffeine 50mg            │
│  - Binding agent            │
│                             │
│ Yang user tahu (Public):    │
│  - Nama: Paracetamol Plus   │
│  - Dosis: 1x500mg sehari    │
│  - Efek samping: Mulas      │
└────────────────────────────┘

Sama dengan Java:
┌────────────────────────────┐
│    CLASS (Pembungkus)       │
├────────────────────────────┤
│ Private (Rahasia):         │
│  - int internalValue        │
│  - void internalProcess()   │
│                             │
│ Public (Interface):        │
│  - String getName()         │
│  - void setValue(int val)   │
└────────────────────────────┘
```

#### **Mengapa Encapsulation?**

```
TANPA ENCAPSULATION (Bad):
┌─────────────────────────────────┐
│  public int age;                │
│  public String email;           │
└─────────────────────────────────┘
        ↓
Person p = new Person();
p.age = -50;  // SALAH! Tidak ada validasi
p.email = "invalid email";  // SALAH! Tidak ada format check


DENGAN ENCAPSULATION (Good):
┌─────────────────────────────────┐
│  private int age;               │
│  private String email;          │
│                                 │
│  public setAge(int age) {        │
│    if (age > 0) {               │
│      this.age = age;  ✓         │
│    } else {                     │
│      throw error;  ✗ INVALID    │
│    }                            │
│  }                              │
└─────────────────────────────────┘
        ↓
Person p = new Person();
p.setAge(-50);  // ERROR! Validasi catch
p.setAge(25);   // OK! Valid
```

#### **Implementasi Encapsulation:**

```java
public class BankAccount {
    // PRIVATE: Data disembunyikan
    private double balance;
    private String accountNumber;
    
    // PUBLIC: Getter dan Setter untuk kontrol akses
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double amount) {
        // VALIDASI dimulai di sini
        if (amount > 0) {
            this.balance = amount;
        } else {
            System.err.println("Amount must be positive!");
        }
    }
    
    public void withdraw(double amount) {
        // Method yang sesuai business logic
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        } else {
            System.err.println("Invalid withdrawal");
        }
    }
}

// Penggunaan:
BankAccount account = new BankAccount();
account.balance = -999;  // ✗ TIDAK BISA (private)
account.setBalance(-999);  // ✗ BISA DIKETIK tapi ERROR (ada validasi)
account.setBalance(5000);  // ✓ OK
account.withdraw(500);  // ✓ OK dengan business logic
```

### 🔶 3. CONSTRUCTOR & INITIALIZATION

#### **Apa itu Constructor?**

**Constructor adalah method khusus yang dipanggil otomatis saat membuat object (instantiation).**

Tujuan: Initialize (atur nilai awal) dari object.

```java
public class Person {
    String name;
    int age;
    
    // Constructor default (tanpa parameter) - dibuat otomatis oleh Java
    // public Person() { }
    
    // Constructor dengan parameter (kita buat manual)
    public Person(String name, int age) {
        this.name = name;  // this = object yang sedang dibuat
        this.age = age;
    }
}

// Penggunaan:
Person p1 = new Person("Budi", 25);  // Constructor dipanggil otomatis
System.out.println(p1.name);  // Output: Budi
System.out.println(p1.age);   // Output: 25
```

**Key points:**
- Constructor HARUS same name dengan class
- Constructor TIDAK punya return type (bukan void, tapi benar-benar tidak ada)
- Bisa ada multiple constructors (overloading)
- Dipanggil dengan keyword `new`

#### **Constructor Overloading:**

```java
public class Car {
    String brand;
    String model;
    int year;
    
    // Constructor 1: Tanpa parameter
    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }
    
    // Constructor 2: Dengan 1 parameter
    public Car(String brand) {
        this.brand = brand;
        this.model = "Unknown";
        this.year = 0;
    }
    
    // Constructor 3: Dengan 3 parameter
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

// Penggunaan:
Car c1 = new Car();  // Panggil constructor 1
Car c2 = new Car("Toyota");  // Panggil constructor 2
Car c3 = new Car("Honda", "Civic", 2020);  // Panggil constructor 3
```

### 🔶 4. STATIC vs NON-STATIC

Ini yang sering bikin bingung. Mari kita jelaskan dengan detail SESUAI KONSEP (bukan yang Anda katakan sebelumnya).

#### **Definisi:**

**Static = Milik CLASS, bukan object**  
**Non-static = Milik OBJECT**

```
┌────────────────────────────────────────────────────┐
│ STATIC: Satu untuk semua object                    │
├────────────────────────────────────────────────────┤
│                   CLASS                            │
│  ┌──────────────────────────────────┐             │
│  │ static int count = 0;             │             │
│  │ static void printCount() {..}    │             │
│  │                                  │             │
│  │ (Ini property/method SHARED)     │             │
│  └──────────────────────────────────┘             │
│            ↓ ↓ ↓                                    │
│   ┌──────────┬──────────┬──────────┐             │
│   │ Object 1 │ Object 2 │ Object 3 │             │
│   │ (access  │ (access  │ (access  │             │
│   │  same    │  same    │  same    │             │
│   │  count)  │  count)  │  count)  │             │
│   └──────────┴──────────┴──────────┘             │
└────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────┐
│ NON-STATIC: Setiap object punya sendiri          │
├────────────────────────────────────────────────────┤
│                   CLASS                            │
│  ┌──────────────────────────────────┐             │
│  │ String name;                      │             │
│  │ int age;                          │             │
│  │ void greet() {..}                 │             │
│  │                                  │             │
│  │ (Ini property/method UNIQUE)     │             │
│  └──────────────────────────────────┘             │
│            ↓ ↓ ↓                                    │
│   ┌──────────┬──────────┬──────────┐             │
│   │ Object 1 │ Object 2 │ Object 3 │             │
│   │ name:"Edi"│ name:"Budi"│ name:"Siti"│       │
│   │ age:25   │ age:30   │ age:22   │             │
│   └──────────┴──────────┴──────────┘             │
└────────────────────────────────────────────────────┘
```

#### **Contoh Praktis:**

```java
public class Student {
    // STATIC: Milik class "Student" (semua student)
    static int totalStudents = 0;
    
    // NON-STATIC: Milik setiap object student
    String name;
    int studentID;
    
    // STATIC METHOD
    static void whoAreWeStudents() {
        System.out.println("We are " + totalStudents + " students");
    }
    
    // NON-STATIC METHOD
    void introduce() {
        System.out.println("My name is " + name);
    }
    
    // Constructor
    Student(String name, int id) {
        this.name = name;
        this.studentID = id;
        totalStudents++;  // Increment untuk semua
    }
}

// PENGGUNAAN:

// Static method - langsung dari CLASS (bukan dari object)
Student.whoAreWeStudents();  // Output: We are 0 students

Student s1 = new Student("Edi", 001);
Student s2 = new Student("Budi", 002);
Student s3 = new Student("Siti", 003);

// Static method - bisa dari class atau object, hasilnya SAMA
Student.whoAreWeStudents();  // Output: We are 3 students
s1.whoAreWeStudents();      // Output: We are 3 students (SAMA!)

// Non-static method - harus dari object
s1.introduce();  // Output: My name is Edi
s2.introduce();  // Output: My name is Budi
s3.introduce();  // Output: My name is Siti
```

**Key point yang Anda salah sebelumnya:**
- ❌ "Static tidak bisa kolaborasi dengan class lain" - **SALAH**
- ✅ "Static bisa diakses dari class lain, tapi milik class, not object" - **BENAR**

```java
public class Counter {
    static int total = 0;
    static void increment() {
        total++;
    }
}

public class Main {
    public static void main(String[] args) {
        Counter.increment();  // ✓ BISA! Dari class berbeda
        System.out.println(Counter.total);  // ✓ BISA! Output: 1
    }
}
```

---

## <a name="inheritance"></a>8. INHERITANCE & POLYMORPHISM

### 🌳 INHERITANCE (Warisan/Turunan)

#### **Definisi:**

**Inheritance adalah mekanisme dimana satu class (child) dapat mewarisi properties dan methods dari class lain (parent).**

#### **Analogi Silsilah (Dari Anda) ✓ TEPAT:**

```
DUNIA NYATA:
┌─────────┐
│ BAPAK   │ ← Punya sifat: keras, teliti, pintar bisnis
│ MAMA    │ ← Punya sifat: penyabar, ulet, rajin
└────┬────┘
     │
   ANAK ← Wariskan sifat dari salah satu parent
(bisa ambil dari Bapak ATAU Mama, tapi Java cuma bisa 1)

JAVA CODE:
┌─────────────────────────◊
│ class Person {          │
│   void work() {}        │
│   void sleep() {}       │
│ }                       │
└─────────────────────────┘
           ↑
     [extends]  (ditunjukkan dengan kata kunci extends)
           │
┌─────────────────────────┐
│ class Employee extends  │
│ Person {                │
│   void takeSalary() {}  │
│ }                       │
└─────────────────────────┘

Artinya: Employee adalah Person
         + punya method work() dan sleep() (dari Person)
         + punya method takeSalary() (miliknya)
```

#### **Mengapa Inheritance?**

Reusability! Tidak perlu tulis ulang code yang sama.

```java
// TANPA INHERITANCE (Buruk):
public class Teacher {
    String name;
    void work() { System.out.println("Teaching"); }
    void sleep() { System.out.println("Sleeping"); }
}

public class Engineer {
    String name;  // REDUNDANT! Sama dengan Teacher
    void work() { System.out.println("Coding"); }  // REDUNDANT!
    void sleep() { System.out.println("Sleeping"); }  // REDUNDANT!
}

// CODE BERULANG! 😤


// DENGAN INHERITANCE (Bagus):
public class Person {
    String name;
    void sleep() { System.out.println("Sleeping"); }
}

public class Teacher extends Person {
    void work() { System.out.println("Teaching"); }
}

public class Engineer extends Person {
    void work() { System.out.println("Coding"); }
}

// CODE LEBIH CLEAN! 😊
```

#### **Terminology:**

```
public class Employee extends Person {
                            ↑
                          Parent
                      (Base class)
                  (Super class)
                    (Ancestor)
                    
    ↑
  Child
(Derived class)
(Sub class)
(Descendant)
```

#### **Method Overriding - untuk customize behavior:**

```java
public class Animal {
    void sound() {
        System.out.println("Some generic sound");
    }
}

public class Dog extends Animal {
    @Override  // Annotation: code jadinya lebih clear
    void sound() {
        System.out.println("Woof! Woof!");
    }
}

public class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow!");
    }
}

// PENGGUNAAN:
Animal a = new Animal();
a.sound();  // Output: Some generic sound

Dog d = new Dog();
d.sound();  // Output: Woof! Woof!

Cat c = new Cat();
c.sound();  // Output: Meow!
```

### 🔄 POLYMORPHISM

#### **Definisi:**

**Polymorphism = "Banyak bentuk"**

One interface, many implementations. Sesuatu yang bisa punya banyak bentuk/cara implementasi.

#### **Analogi:**

```
Bentuk geometri:
┌─────────────────────────────┐
│ Shape (Parent)              │
│  - calculateArea()          │
└─────────────────────────────┘
         ↓ ↓ ↓
    ┌────┼────┬────┐
    │    │    │    │
┌───┴──┐ ┌──┴───┐ ┌──┴───┐
│Circle│ │Square│ │Triangle│
│ (area│ │ (area│ │ (area  │
│=πr²) │ │=s²)  │ │=½ab)   │
└──────┘ └──────┘ └────────┘

Semuanya adalah Shape, tapi each calculate area berbeda!
```

#### **"One interface, many forms":**

```java
// Interface/Parent:
public class Shape {
    double calculateArea() {
        return 0;
    }
}

// Many forms (implementations):
public class Circle extends Shape {
    double radius;
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Square extends Shape {
    double side;
    
    @Override
    double calculateArea() {
        return side * side;
    }
}

public class Triangle extends Shape {
    double base, height;
    
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
```

#### **Power of Polymorphism:**

```java
// TANPA POLYMORPHISM (Buruk):
public void printAreas(Circle c, Square s, Triangle t) {
    System.out.println(c.calculateArea());
    System.out.println(s.calculateArea());
    System.out.println(t.calculateArea());
}
// Jika ada shape baru? Harus bikin method baru lagi! 😤


// DENGAN POLYMORPHISM (Genius):
public void printAreas(Shape[] shapes) {
    for (Shape shape : shapes) {
        System.out.println(shape.calculateArea());  // Magic!
    }
}

// PENGGUNAAN:
Shape[] shapes = {
    new Circle(5),
    new Square(4),
    new Triangle(3, 4)
};

printAreas(shapes);
// Jika ada shape baru? Cukup extends Shape, langsung bisa!
// Tidak perlu ubah method printAreas() sama sekali! 😎
```

### 🔗 SUPER KEYWORD

**Super digunakan untuk refer ke parent class methods/properties.**

```java
public class Parent {
    void message() {
        System.out.println("From Parent");
    }
}

public class Child extends Parent {
    @Override
    void message() {
        System.out.println("From Child");
    }
    
    void parentMessage() {
        super.message();  // Panggil parent method
    }
}

// PENGGUNAAN:
Child c = new Child();
c.message();  // Output: From Child
c.parentMessage();  // Output: From Parent
```

---

## <a name="encapsulation"></a>9. ENCAPSULATION & ACCESS MODIFIERS (DETAIL)

Kita sudah bahas sedikit, sekarang mari detail lebih complete.

### 📋 Access Modifiers (4 Level)

```
┌──────────────┬─────────────┬──────────────┬──────────────┬────────────┐
│   MODIFIER   │   CLASS     │   PACKAGE    │   SUBCLASS   │   OTHER    │
├──────────────┼─────────────┼──────────────┼──────────────┼────────────┤
│   public     │     ✓       │      ✓       │      ✓       │     ✓      │
│              │ Bisa akses  │ Bisa akses   │ Bisa akses   │ Bisa akses │
├──────────────┼─────────────┼──────────────┼──────────────┼────────────┤
│  protected   │     ✓       │      ✓       │      ✓       │     ✗      │
│              │ Bisa akses  │ Bisa akses   │ Bisa akses   │ TIDAK      │
├──────────────┼─────────────┼──────────────┼──────────────┼────────────┤
│  (default)   │     ✓       │      ✓       │      ✗       │     ✗      │
│  / package   │ Bisa akses  │ Bisa akses   │ TIDAK        │ TIDAK      │
│  private     │             │ (same package)               │            │
├──────────────┼─────────────┼──────────────┼──────────────┼────────────┤
│   private    │     ✓       │      ✗       │      ✗       │     ✗      │
│              │ Bisa akses  │ TIDAK        │ TIDAK        │ TIDAK      │
│              │ (only class)│              │              │            │
└──────────────┴─────────────┴──────────────┴──────────────┴────────────┘
```

### ✏️ Contoh Praktis:

```java
// File: com/example/Person.java
package com.example;

public class Person {
    public String publicName = "Everyone can access";
    protected String protectedInfo = "Family and subclass can access";
    String defaultInfo = "Same package only";  // default access
    private String privateSecret = "Only me can access";
    
    public void publicMethod() {
        System.out.println("Public method");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
    
    void defaultMethod() {
        System.out.println("Default method");
    }
    
    private void privateMethod() {
        System.out.println("Private method");
    }
}

---

// File: com/example/Employee.java (SAME PACKAGE)
package com.example;

public class Employee extends Person {
    void testAccess() {
        System.out.println(publicName);       // ✓ OK
        System.out.println(protectedInfo);   // ✓ OK (subclass)
        System.out.println(defaultInfo);     // ✓ OK (same package)
        // System.out.println(privateSecret);  // ✗ ERROR
        
        publicMethod();        // ✓ OK
        protectedMethod();     // ✓ OK
        defaultMethod();       // ✓ OK
        // privateMethod();    // ✗ ERROR
    }
}

---

// File: com/other/Stranger.java (DIFFERENT PACKAGE)
package com.other;

import com.example.Person;

public class Stranger {
    void testAccess() {
        Person p = new Person();
        System.out.println(p.publicName);      // ✓ OK
        // System.out.println(p.protectedInfo); // ✗ ERROR
        // System.out.println(p.defaultInfo);  // ✗ ERROR
        // System.out.println(p.privateSecret); // ✗ ERROR
        
        p.publicMethod();       // ✓ OK
        // p.protectedMethod();  // ✗ ERROR
        // p.defaultMethod();   // ✗ ERROR
        // p.privateMethod();   // ✗ ERROR
    }
}
```

### 🛡️ Best Practices (Encapsulation Guideline)

```java
public class BankAccount {
    // 1. PRIVATE: Data sensitif disembunyikan
    private double balance;
    private String accountNumber;
    private LocalDateTime createdDate;
    
    // 2. PUBLIC: Hanya interface yang penting
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("DEPOSIT", amount);
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logTransaction("WITHDRAW", amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
    
    // 3. PROTECTED: Untuk subclass jika ada
    protected void logTransaction(String type, double amount) {
        System.out.println(type + ": " + amount);
    }
    
    // 4. PRIVATE: Internal helper
    private void validateBalance() {
        // Internal validation
    }
}

// Aturan:
// - Private untuk data sensitif
// - Public untuk interface (getter/setter/business method)
// - Protected untuk customization di subclass
// - Avoid: public direct data access
```

---

## <a name="interface"></a>10. INTERFACE & ABSTRACT CLASS

### 🔌 INTERFACE

#### **Definisi:**

**Interface adalah contract atau agreement** yang mengatakan "Siapa saja yang implement interface ini HARUS punya method-method ini."

#### **Analogi:**

```
DUNIA NYATA:
┌──────────────────────────────┐
│ USB Interface (Standard)     │
│  - 4 pin connection          │
│  - 5V power                  │
│  - Data transfer protocol    │
└──────────────────────────────┘
         ↓ (must follow contract)
    ┌────┼────────┬────────┐
    │    │        │        │
┌───┴──┐ ┌──┴──┐ ┌──┴──┐ ┌──┴──┐
│Flash │ │Mouse│ │Hard  │ │Printer│
│Drive │ │    │ │Drive │ │      │
└──────┘ └─────┘ └──────┘ └──────┘

Semua device USB "mengikuti" interface yang sama,
tapi fungsi berbeda.

JAVA:
┌────────────────────────────────┐
│ interface Transportable {       │
│   void move();                 │
│   void stop();                 │
│   void honk();                 │
│ }                              │
└────────────────────────────────┘
         ↓ (must implement)
    ┌────┼─────────┬────┐
    │    │         │    │
┌───┴──┐ ┌──┴───┐ ┌──┴──┐ ┌──┴──┐
│Car   │ │Bike  │ │Train│ │Bus  │
└──────┘ └──────┘ └─────┘ └─────┘

Semua vehicle implements Transportable,
tapi each move berbeda.
```

#### **Syntax:**

```java
// INTERFACE DEFINITION
public interface Transportable {
    // Method hanya signature, TIDAK ada implementation (sampai Java 8)
    void move();
    void stop();
    void honk();
}

// IMPLEMENTATION (Harus implement SEMUA method)
public class Car implements Transportable {
    @Override
    public void move() {
        System.out.println("Car moving on road");
    }
    
    @Override
    public void stop() {
        System.out.println("Car brake applied");
    }
    
    @Override
    public void honk() {
        System.out.println("Car: Beep! Beep!");
    }
}

public class Bike implements Transportable {
    @Override
    public void move() {
        System.out.println("Bike pedaling");
    }
    
    @Override
    public void stop() {
        System.out.println("Bike brake applied");
    }
    
    @Override
    public void honk() {
        System.out.println("Bike: Ring! Ring!");
    }
}

// PENGGUNAAN:
Transportable[] vehicles = {
    new Car(),
    new Bike()
};

for (Transportable v : vehicles) {
    v.move();   // Polymorphism! Each implementasi berbeda
    v.honk();
    v.stop();
}
```

### 🔗 Multiple Implementation (Perbedaan dari Inheritance)

**KEY DIFFERENCE:** Inheritance cuman SATU parent, Interface bisa MANY!

```java
public interface Drawable {
    void draw();
}

public interface Colorable {
    void setColor(String color);
}

// BISA implements DANYA (tidak bisa dengan inheritance!)
public class Circle implements Drawable, Colorable {
    String color;
    
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

// Ini IMPOSSIBLE dengan inheritance:
// public class Circle extends Drawable, Colorable { }  // ✗ ERROR!
// (Java tidak allow multiple inheritance)
```

### 🤔 INTERFACE vs ABSTRACT CLASS

```
┌────────────────────┬──────────────────┬─────────────────┐
│      ASPEK         │    INTERFACE     │  ABSTRACT CLASS │
├────────────────────┼──────────────────┼─────────────────┤
│ Methods            │ Cuman signature  │ Ada yang full   │
│                    │ (mostly)         │ implementasi    │
│                    │ (Java 8+ ada def)│                 │
├────────────────────┼──────────────────┼─────────────────┤
│ Properties         │ Cuman constants  │ Bisa declare    │
│                    │ (public static   │ apa saja        │
│                    │  final)          │                 │
├────────────────────┼──────────────────┼─────────────────┤
│ Inheritance        │ MULTIPLE ✓       │ SINGLE ✗        │
├────────────────────┼──────────────────┼─────────────────┤
│ Constructor        │ ✗                │ ✓               │
├────────────────────┼──────────────────┼─────────────────┤
│ Use case           │ "What to do"     │ "How to do"     │
│                    │ (Contact)        │ (Partial impl)  │
├────────────────────┼──────────────────┼─────────────────┤
│ Keyword            │ interface        │ abstract class  │
│                    │ implements       │ extends         │
└────────────────────┴──────────────────┴─────────────────┘
```

#### **Contoh untuk membedakan:**

```java
// INTERFACE - "What to do" (contractual)
public interface Payable {
    void pay(double amount);
}

// ABSTRACT CLASS - "How to do it" (partial impl, template)
public abstract class Employee {
    String name;
    double salary;
    
    abstract void work();  // Must implement
    
    void receiveSalary() {  // Already implemented
        System.out.println(name + " received " + salary);
    }
}

// BISA COMBINE KEDUANYA:
public class Developer extends Employee implements Payable {
    @Override
    void work() {
        System.out.println("Coding");
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paying: " + amount);
    }
}
```

### 📝 Method Overloading vs Overriding (RECAP)

Ini yang dari penjelasan Anda sebelumnya, untuk clarifikasi final:

```
┌──────────────┬────────────────────┬──────────────────┐
│   ASPEK      │    OVERLOADING     │    OVERRIDING    │
├──────────────┼────────────────────┼──────────────────┤
│ Method name  │ Sama               │ Sama             │
├──────────────┼────────────────────┼──────────────────┤
│ Parameter    │ BERBEDA (inti!)    │ SAMA (inti!)     │
|  /Signature  │                    │                  │
├──────────────┼────────────────────┼──────────────────┤
│ Return type  │ Bisa berbeda       │ HARUS sama       │
├──────────────┼────────────────────┼──────────────────┤
│ Where        │ SAME class or      │ Different class  │
│              │ different class    │ (child extends   │
│              │ (bisa)             │ parent)          │
├──────────────┼────────────────────┼──────────────────┤
│ Resolved at  │ COMPILE-TIME       │ RUNTIME          │
│              │ (Static binding)   │ (Dynamic binding)│
├──────────────┼────────────────────┼──────────────────┤
│ @Override    │ ✗ tidak perlu      │ ✓ sebaiknya ada  │
├──────────────┼────────────────────┼──────────────────┤
│ Tujuan       │ Convenience        │ Polymorphism     │
│              │ (method yg sama    │ (customize       │
│              │ dengan param       │ behavior)        │
│              │ berbeda)           │                  │
└──────────────┴────────────────────┴──────────────────┘
```

```java
// OVERLOADING - Compile-time (Static binding)
public class Calculator {
    // Method 1
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method 2 - SAMA NAME, DIFF PARAM
    public double add(double a, double b) {
        return a + b;
    }
    
    // Method 3 - SAMA NAME, DIFF PARAM COUNT
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Compiler sudah tau:
// add(5, 3) → Method 1 (SAAT COMPILE)
// add(5.0, 3.0) → Method 2
// add(5, 3, 2) → Method 3

Calculator c = new Calculator();
System.out.println(c.add(5, 3));      // Method 1 → 8
System.out.println(c.add(5.5, 3.5));  // Method 2 → 9.0
System.out.println(c.add(5, 3, 1));   // Method 3 → 9


// OVERRIDING - Runtime (Dynamic binding)
public class Animal {
    public void sound() {
        System.out.println("Generic sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {  // SAMA NAME, SAME PARAM
        System.out.println("Woof!");
    }
}

// Compiler tidak tau:
// Hanya tau "sound()" method ada
// Runtime baru tau apakah sebenarnya Dog atau Animal

Animal a = new Dog();  // Reference type: Animal, actual: Dog
a.sound();  // Output: Woof! (SAAT RUNTIME decide yang Dog.sound())

// Jika tanpa inheritance:
Dog d = new Dog();
d.sound();  // Output: Woof! (langsung tau Dog)
```

---

## KESIMPULAN

**Hierarchy of Java Learning:**

```
1. Compile & Execution
   └─ Understand: Compiler, Bytecode, JVM, JRE, JDK
   
2. Memory Management
   └─ Understand: Stack, Heap, Garbage Collection
   
3. Data Types
   └─ Understand: Primitive vs Reference, passing by value
   
4. Object Oriented Programming
   ├─ Class vs Object
   ├─ Variable: Instance vs Static
   ├─ Methods: Instance vs Static
   ├─ Constructor & Initialization
   └─ Encapsulation (access modifiers)
   
5. Inheritance & Polymorphism
   ├─ Class inheritance
   ├─ Method overriding
   ├─ super keyword
   └─ Polymorphic behavior
   
6. Interface & Abstraction
   ├─ Interface definition
   ├─ Multiple implementation
   ├─ Abstract class
   └─ Method overloading
```

---

**Next steps dalam learning Java:**
- ✅ Pahami fundamental ini dengan detail
- Practice dengan membuat project kecil (Inventory, Bank, e-commerce)
- Learn Java Collections (List, Set, Map, Queue)
- Learn Exception Handling
- Learn I/O & File Management
- Learn Multithreading
- Learn Database (JDBC)
- Learn Web Framework (Spring)

---

**Panduan ini dibuat untuk pembelajaran mendalam OOP di Java. Gunakan sebagai referensi ketika mengajar atau belajar!**

