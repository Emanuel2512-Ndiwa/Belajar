
import java.security.SecureRandom;

public class RollDie {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] frequency = new int[7];// array untuk menyimpan frekuensi kemunculan angka 1 hingga 6, indeks 0 tidak
                                     // digunakan

        for (int roll = 1; roll <= 600000; roll++) {
            ++frequency[randomNumbers.nextInt(6) + 1]; // bound menghasilkan angka acak antara 1 dan 6
            /*
             * contoh jika method random menghasilkan angka 3, maka frequency[3+ 1] = 4
             * maka frequency[5] = 5 ini unutk menunjukan ow frekuensi indeks ke lima
             * nilainya itu berapa
             * setleah di cek ternnya nilianya kosong nih jadi akan di increment menjadi 1,
             * maka frequency[4] = 1
             * kenapa di tmabah karena ada perintah increament yaitu
             * ++frequency[randomNumbers.nextInt(6) + 1] jadi setiap kali angka 3 muncul
             * maka frequency[4] akan di increment sebanyak 1
             * 
             */
        }

        System.out.println("Face\tFrequency");
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }
    }
}
