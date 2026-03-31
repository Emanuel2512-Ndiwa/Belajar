package OOP;

import java.util.Scanner;

public class mobilMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("Selamat Datang di Tempat Cuci Mobil");
        System.out.println("======================================================");

        System.out.print("Berapa Mobil yang Ingin Anda Cuci? ");
        int jumlahMobil = input.nextInt();
        input.nextLine(); // Consume newline

        // Cukup buat SATU array untuk menampung OBJEK Mobil
        Mobil[] daftarMobil = new Mobil[jumlahMobil];

        for (int i = 0; i < jumlahMobil; i++) {
            System.out.println("\nMobil ke-" + (i + 1));

            System.out.print("Masukkan Nama Pemilik: ");
            String nama = input.nextLine();

            System.out.print("Masukkan Merek Mobil: ");
            String merek = input.nextLine();

            System.out.print("Masukkan Warna Mobil: ");
            String warna = input.nextLine();

            System.out.print("Masukkan Tahun Mobil: ");
            int tahun = input.nextInt();
            input.nextLine(); // Consume newline

            // Langsung masukkan ke array sebagai objek baru
            daftarMobil[i] = new Mobil(merek, warna, tahun, nama);
            System.out.println("Berhasil didaftarkan!");
        }

        // Menampilkan hasil
        System.out.println("\n======================================================");
        System.out.println("DAFTAR ANTRIAN CUCI MOBIL:");
        for (Mobil m : daftarMobil) {
            // Asumsi class Mobil punya method tampilkanData()
            // atau kamu bisa akses getter-nya
            System.out.println("Pemilik: " + m.getNamaPemilik() + " | Mobil: " + m.getMerk() + " | Warna: "
                    + m.getWarna() + " | Tahun: " + m.getTahun());
        }

        input.close();
    }
}