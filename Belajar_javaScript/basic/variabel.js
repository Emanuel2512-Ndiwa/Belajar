/**
 * JavaScript Variables - Panduan Komprehensif ES6+
 * Fokus: Keamanan memori (Scope), Efisiensi data, dan Sintaks Modern.
 */

// --- 1. DEKLARASI VARIABEL (PONDASI) ---

// VAR: Cara lama (Pre-2015). Memiliki masalah "Hoisting" dan tidak kenal "Block Scope".
// Sebaiknya dihindari dalam proyek modern/perusahaan besar.
var nama = "John Doe"; 
console.log(nama);

// LET: Variabel modern. Nilainya BISA diubah (re-assign). 
// Bersifat "Block Scope" (hanya hidup di dalam kurung kurawal tempat ia dibuat).
let umur = 25; 
let email = "john@example.com";
umur = 26; // Ini diperbolehkan karena menggunakan 'let'
console.log(umur, email);

// CONST: Singkatan dari Constant. Nilainya TIDAK BISA diubah setelah diisi.
// Gunakan ini sebagai default untuk menjaga keamanan data agar tidak sengaja tertimpa.
const negara = "Indonesia"; 
const tahunLahir = 1999;
// negara = "Malaysia"; // Ini akan menyebabkan ERROR (Assignment to constant variable).
console.log(negara, tahunLahir);


// --- 2. TIPE DATA PRIMITIF (UNIT TERKECIL) ---

const string = "Hello World";      // Tipe teks (harus pakai kutip).
const number = 42;                 // Tipe angka (bulat atau desimal).
const boolean = true;              // Tipe logika (hanya true atau false).
const nullable = null;             // Sengaja dikosongkan (objek kosong).
let undefined_var;                 // Variabel dibuat tapi belum diberi isi (otomatis undefined).
const bigInt = 9007199254740991n;  // Angka sangat besar di luar batas Number biasa (pakai akhiran 'n').
const symbol = Symbol("unique");   // Membuat ID unik yang tidak akan pernah sama dengan variabel lain.

// 'typeof' adalah operator untuk mengecek jenis data dari sebuah variabel.
console.log(typeof string, typeof number, typeof boolean); 


// --- 3. TIPE DATA KOMPLEKS (STRUKTUR DATA) ---

// OBJECT: Menyimpan banyak data dalam pasangan Key (Kunci) dan Value (Nilai).
const objek = {
    nama: "Alice",
    umur: 30,
    kota: "Jakarta"
};

// ARRAY: Kumpulan data yang disusun berdasarkan urutan/indeks (dimulai dari 0).
const array = [1, 2, 3, 4, 5]; 

// FUNCTION: Blok kode yang bisa dipanggil berulang kali untuk menjalankan tugas tertentu.
const fungsi = function() { return "Hello"; };

console.log(objek, array);


// --- 4. FITUR MODERN ES6 (EFISIENSI) ---

// TEMPLATE LITERAL: Menggabungkan variabel ke dalam string tanpa ribet pakai tanda +.
// Gunakan simbol backtick ( ` ) di sebelah angka 1 pada keyboard.
const person = "Bob";
const greeting = `Halo, namaku ${person}!`; // Sintaks ${} disebut Interpolasi.
console.log(greeting);

// DESTRUCTURING: Teknik "membongkar" isi objek/array ke dalam variabel terpisah secara instan.
// Mengambil 'nama' dari objek dan menyimpannya ke variabel 'personName'.
const { nama: personName, umur: personAge } = objek; 
// Mengambil elemen 1 dan 2 dari array, sisanya dimasukkan ke variabel 'rest' (Spread Operator).
const [first, second, ...rest] = array; 
console.log(personName, personAge, rest);


// --- 5. LOGIKA SCOPE & BEHAVIOR (PEMAHAMAN LANJUTAN) ---

// BLOCK SCOPE: Variabel let/const di dalam { } tidak bisa diakses dari luar.
if (true) {
    let blockScoped = "Hanya di block ini";
    const alsoBlockScoped = "Juga di block ini";
    // console.log(blockScoped); // Berhasil di sini
}
// console.log(blockScoped); // ERROR: blockScoped is not defined.

// HOISTING: var ditarik ke atas oleh browser sebelum kode dijalankan.
// 'var' akan bernilai undefined jika dipanggil sebelum deklarasi.
console.log(typeof hoistedVar); 
var hoistedVar = "var value"; 

// Catatan: let & const juga di-hoist tapi masuk ke "Temporal Dead Zone", 
// sehingga akan ERROR jika dipanggil sebelum baris deklarasinya.


// --- 6. OPERASI DALAM STRING ---

const harga = 50000;
const jumlah = 3;
// Template string bisa menampung operasi matematika langsung di dalam ${ }.
const total = `Total: Rp ${harga * jumlah}`; 
console.log(total);