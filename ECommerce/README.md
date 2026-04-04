# ECommerce Project Latihan

## Deskripsi Singkat
Proyek ini adalah aplikasi e-commerce berbasis CLI sebagai latihan OOP Java. Sistem ini menggunakan struktur paket sederhana untuk memisahkan logika model (`src/ECommerce`) dan antarmuka pengguna CLI (`src/CLI`).

## Arsitektur yang Digunakan
- `ECommerce.Main`: titik masuk aplikasi.
- `ECommerce.DataManager`: penyimpan data in-memory untuk `User`, `Category`, `Product`, dan `Order`.
- `ECommerce.User`, `ECommerce.Client`, `ECommerce.Seller`: model pengguna dengan pewarisan kelas.
- `ECommerce.Product`, `ECommerce.Category`, `ECommerce.Order`, `ECommerce.Cart`: model domain bisnis e-commerce.
- `CLI.NavigationHandler`: menangani menu utama dan navigasi.
- `CLI.Login` / `CLI.SignUp`: alur autentikasi pengguna.
- `CLI.Actionable`: antarmuka untuk aksi pengguna dinamis.
- Kelas `CLI.*` lain seperti `AddProduct`, `AddCategory`, `Explore`, dan `ShowCategoryProduct` untuk aksi spesifik.

## Ruang Lingkup Proyek
- Pengelolaan pengguna dasar: login dan signup.
- Pengelolaan kategori dan produk melalui CLI.
- Peran pengguna `Client` dan `Seller` dengan aksi berbeda.
- Sistem checkout dan keranjang sederhana (masih berupa latihan, sebagian fungsi mungkin belum lengkap).
- Data disimpan sementara dalam memori (`ArrayList`), belum ada persistensi file atau database.
- Fokus pada penerapan konsep OOP dan pola desain sederhana.

## Konsep yang Digunakan
- Pemrograman Berorientasi Objek (OOP): kelas, objek, enkapsulasi.
- Pewarisan (`extends`) antara `User`, `Client`, dan `Seller`.
- Polimorfisme melalui antarmuka `Actionable` untuk aksi pengguna.
- Komposisi objek: `Client` memiliki `Cart`, `Seller` dapat memiliki daftar `Product`.
- Koleksi Java: `ArrayList` untuk menyimpan data.
- Struktur paket untuk memisahkan logic CLI dan model domain.
- Alur kontrol melalui `switch-case` dan pemilihan menu.

## Alur Program
1. Program dijalankan dari `ECommerce.Main`.
2. `NavigationHandler.welome()` menampilkan pesan sambutan.
3. `NavigationHandler.init()` menampilkan menu utama: Login, SignUp, Exit.
4. Jika memilih Login, `CLI.Login` akan memverifikasi email dan password.
5. Jika memilih SignUp, `CLI.SignUp` akan membuat pengguna baru dan kemudian login.
6. Setelah login, sistem menampilkan menu aksi berdasarkan peran pengguna:
   - `Client` akan melihat opsi eksplorasi produk dan operasi terkait.
   - `Seller` akan mendapatkan akses tambah kategori/produk dan manajemen dagang.
7. Setiap aksi dijalankan melalui kelas `Actionable` yang sesuai.
8. Setelah aksi selesai, menu kembali ditampilkan sampai pengguna memilih keluar.

## Cara Menggunakan
1. Buka folder `c:\Belajar\ECommerce` di VS Code atau terminal.
2. Pastikan Java telah terpasang dan `JAVA_HOME` sudah dikonfigurasi.
3. Jalankan program dari kelas `ECommerce.Main`.
   - Jika menggunakan VS Code, jalankan `Main.java` langsung.
   - Jika menggunakan command line:
     ```powershell
     cd c:\Belajar\ECommerce\src
     javac -d ..\bin ECommerce\Main.java CLI\*.java ECommerce\*.java
     java -cp ..\bin ECommerce.Main
     ```
4. Ikuti instruksi menu CLI untuk login, daftar, dan melakukan aksi.

## Catatan
- Ini adalah project latihan, bukan produk siap pakai.
- Tujuan utama adalah belajar konsep OOP dan struktur aplikasi Java sederhana.
- Fitur tambahan seperti penyimpanan data permanen, validasi input penuh, dan UI grafis belum diimplementasikan.
- Silakan gunakan sebagai dasar untuk pengembangan lebih lanjut.
