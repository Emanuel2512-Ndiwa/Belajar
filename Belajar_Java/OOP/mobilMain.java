package OOP;

import java.util.Scanner;

public class mobilMain {
    public static void main(String[] args) {
        System.out.println("============================================================================");
        System.out.println("Selamat Datang di Tempat Cuci Mobil Kami");
        System.out.println("Daftarkan Mobil Anda Sebelum Mencucinnya di Tempat Cuci Mobil Kami");
        System.out.println("============================================================================");

        Scanner input = new Scanner(System.in);
        int jumlahMobil;
        String namaPemilik;
        String jenisMobil;
        String warnaMobil;

        String[] namaPemilikArray = { "<Enter Nama Pemilik>" };
        String[] jenisMobilArray = { "<Enter Merek Mobil>" };
        String[] warnaMobilArray = { "<Enter Warna Mobil>" };
        int[] tahunMobilArray = { 0 };
        Mobil Mobil = new Mobil(jenisMobil, warnaMobil, tahunMobil, namaPemilik);

        System.out.println("Berapa Mobil yang Ingin Anda Cuci? ");

        jumlahMobil = input.nextInt();
        input.nextLine(); // Consume the newline character
        for (int i = 0; i < jumlahMobil; i++) {

            if (jumlahMobil == 1) {
                System.out.println("Mobil ke-" + (i + 1));
                System.out.print("Masukkan Nama Pemilik: ");
                namaPemilik = input.nextLine();
                System.out.print("Masukkan Merek Mobil: ");
                jenisMobil = input.nextLine();
                System.out.print("Masukkan Warna Mobil: ");
                warnaMobil = input.nextLine();
                System.out.println("Masukan Tahun Mobil: ");
                int tahunMobil = input.nextInt();
                input.nextLine(); // Consume the newline character

                Mobil = new Mobil(jenisMobil, warnaMobil, tahunMobil, namaPemilik);
                System.out.println("Mobil " + (i + 1) + " berhasil didaftarkan!");
                System.out.println("============================================================================");
                break;
            } else {
                System.out.println("Mobil ke-" + (i + 1));

                Mobil[] mobil = new Mobil[jumlahMobil];

                for (int j = 0; j < jumlahMobil; j++) {
                    System.out.println("Mobil ke-" + (i + 1));
                    System.out.print("Masukkan Nama Pemilik: ");
                    namaPemilikArray[j] = input.nextLine();
                    System.out.print("Masukkan Merek Mobil: ");
                    jenisMobilArray[j] = input.nextLine();
                    System.out.print("Masukkan Warna Mobil: ");
                    warnaMobilArray[j] = input.nextLine();
                    System.out.println("Masukan Tahun Mobil: ");
                    tahunMobilArray[j] = input.nextInt();
                    input.nextLine(); // Consume the newline character

                    mobil[j] = new Mobil(jenisMobilArray[j], warnaMobilArray[j], tahunMobilArray[j],
                            namaPemilikArray[j]);

                    System.out.println("Mobil " + (j + 1) + " berhasil didaftarkan!");
                    System.out.println("============================================================================");
                    System.out.println("Berikut Adalah Daftar Mobil yang Sudah Didaftarkan: ");
                    for (int k = 0; k < jumlahMobil; k++) {
                        System.out.println("Mobil ke-" + (k + 1));
                        System.out.println("Nama Pemilik: " + mobil[k].getNamaPemilik());
                      
                        System.out.println(
                                "============================================================================");
                    }
                }
                System.out.println("Mobil " + (i + 1) + " berhasil didaftarkan!");
                System.out.println("============================================================================");
            }
            input.close();
        }

    }

}
