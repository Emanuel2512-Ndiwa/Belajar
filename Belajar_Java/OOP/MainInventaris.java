package OOP;

import java.util.Scanner;

public class MainInventaris {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventaris inventaris = new Inventaris();

        System.out.println();
        System.out.println("Selamat datang di Sistem Inventaris Barang + Supplier Management!");

        System.out.print("Masukkan jumlah supplier yang ingin ditambahkan: ");
        int jumlahSupplier = Integer.parseInt(input.nextLine());

        for (int i = 0; i < jumlahSupplier; i++) {
            System.out.println();
            System.out.println("Input Supplier ke-" + (i + 1));
            System.out.print("ID Supplier     : ");
            String idSupplier = input.nextLine();
            System.out.print("Nama Supplier   : ");
            String namaSupplier = input.nextLine();
            System.out.print("Alamat Supplier : ");
            String alamat = input.nextLine();
            System.out.print("Telepon         : ");
            String telepon = input.nextLine();

            Supplier supplier = new Supplier(idSupplier, namaSupplier, alamat, telepon);
            inventaris.tambahSupplier(supplier);
        }

        System.out.println();
        System.out.print("Masukkan jumlah barang yang ingin ditambahkan: ");
        int jumlahBarang = Integer.parseInt(input.nextLine());

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println();
            System.out.println("Input Barang ke-" + (i + 1));
            System.out.print("Kode Barang     : ");
            String kodeBarang = input.nextLine();
            System.out.print("Nama Barang     : ");
            String namaBarang = input.nextLine();
            System.out.print("Harga Barang    : ");
            int harga = Integer.parseInt(input.nextLine());
            System.out.print("Stok Awal       : ");
            int stok = Integer.parseInt(input.nextLine());
            System.out.print("ID Supplier     : ");
            String idSupplier = input.nextLine();

            Supplier supplierTerpilih = inventaris.cariSupplierById(idSupplier);

            if (supplierTerpilih != null) {
                Barang barang = new Barang(kodeBarang, namaBarang, harga, stok, supplierTerpilih);
                inventaris.tambahBarang(barang);
            } else {
                System.out.println("Supplier dengan ID " + idSupplier + " tidak ditemukan. Barang gagal ditambahkan.");
            }
        }

        System.out.println();
        inventaris.tampilkanSemuaSupplier();

        System.out.println();
        inventaris.tampilkanSemuaBarang();

        System.out.println();
        inventaris.hitungTotalNilaiStok();

        input.close();
    }
}
