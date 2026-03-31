package Basic;

import java.util.Scanner;

public class Comparasion {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner input = new Scanner(System.in);

        int number1, number2;

        // Meminta pengguna untuk memasukkan dua angka
        System.out.print("Masukkan angka pertama: ");
        number1 = input.nextInt();
        System.out.print("Masukkan angka kedua: ");
        number2 = input.nextInt();
        // Membandingkan kedua angka dan menampilkan hasilnya

        if(number1 == number2){
            System.out.printf("%d == %d%n", number1, number2);

        }

        if(number1 != number2){
            System.out.printf("%d != %d%n", number1, number2);

        }

        if(number1 < number2){
            System.out.printf("%d < %d%n", number1, number2);

        }
        if(number1 > number2){
            System.out.printf("%d > %d%n", number1, number2);

        }
        if(number1 <= number2){
            System.out.printf("%d <= %d%n", number1, number2);

        }
        if(number1 >= number2){
            System.out.printf("%d >= %d%n", number1, number2);

        }
    }

}
