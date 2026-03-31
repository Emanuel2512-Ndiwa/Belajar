package Basic;
public class PassArray {
    // Main method: tempat program dimulai
    public static void main(String[] args) {
        // Inisialisasi array awal dengan isi 1, 2, 3, 4, 5
        int[] array = { 1, 2, 3, 4, 5 };

        System.out.printf(
                "Effects of passing reference to entire array:%n" +
                        "The values of the original array are:%n");

        // Menampilkan isi array asli menggunakan perulangan for-each
        for (int value : array) {
            System.out.printf("  %d", value);
        }

        // MEMANGGIL METHOD modifyArray
        // Di sini kita mengirim "alamat" (referensi) array asli
        modifyArray(array);

        System.out.printf("%n%nThe values of the modified array are:%n");

        // Menampilkan array setelah dimodifikasi oleh method modifyArray
        // Nilainya akan berubah menjadi 2, 4, 6, 8, 10 karena array asli ikut berubah
        for (int value : array) {
            System.out.printf("  %d", value);
        }

        System.out.printf(
                "%n%nEffects of passing array element value:%n" +
                        "array[3] before modifyElement: %d%n",
                array[3]);

        // MEMANGGIL METHOD modifyElement
        // Di sini kita hanya mengirim "NILAI" dari indeks ke-3 (yaitu angka 8)
        modifyElement(array[3]);

        // Menampilkan array[3] setelah method selesai
        // Nilainya TETAP 8, tidak berubah jadi 16, karena yang dikirim cuma salinan
        // nilainya
        System.out.printf(
                "array[3] after modifyElement: %d%n", array[3]);
    }

    // Method untuk mengalikan setiap elemen array dengan 2
    public static void modifyArray(int[] array2) {
        // Loop ini akan mengakses alamat memori array asli melalui variabel array2
        for (int counter = 0; counter < array2.length; counter++) {
            /*
             * di sini yang terjadi adalah kita mengakses alamat memori array asli melalui
             * variabel array2,
             * alamat ini menjadi kabel penghubung antara array2 dan array,
             * karena ada kabel penghubung maka dia punya akses ke array.
             * tetapi lokasi mereka itu berbeda si array2 itu hanya variabel lokal aaaaaaaaaaaa
             * menyimpan alamat array asli, sedangkan array itu sendiri adalah objek yang
             * berada di heap memory.
             * karena array2 itu hanya variabel lokal yang menyimpan alamat array asli, maka
             * ketika kita mengubah isi di alamat tersebut (yaitu array asli) melalui
             * array2, maka perubahan itu akan terlihat di array asli juga, karena mereka
             * terhubung melalui alamat yang sama.
             * UBAH ISI OBJECT
             * → berubah
             * 
             * GANTI OBJECT
             * → tidak berubah
             * 
             * PRIMITIVE
             * → tidak berubah
             */
            array2[counter] *= 2; // Mengalikan isi di alamat tersebut dengan 2
        }
    }

    // Method untuk mengalikan satu angka (elemen) dengan 2
    public static void modifyElement(int element) {
        element *= 2; // Hanya variabel lokal 'element' yang dikalikan 2
        System.out.printf(
                "Value of element in modifyElement: %d%n", element);
    }
} // Akhir dari class PassArray