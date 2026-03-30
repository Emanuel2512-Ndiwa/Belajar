
import java.util.Scanner;

public class AccountTest {

    private String name;//ini adlaah instance variable yang digunakan untuk menyimpan nama dari akun
    private int balance;//ini adlaah instance variable yang digunakan untuk menyimpan saldo dari akun

    //menggunakan tipe data private agar variabel name dan balance hanya dapat diakses dan dimodifikasi melalui metode yang disediakan dalam kelas AccountTest
    //ini adlaah constructor yang digunakan untuk menginisialisasi nilai dari variabel name dan balance
    //coonstructor ini akan dipanggil ketika kita membuat objek dari kelas AccountTest dan memberikan nilai untuk name dan balance
    //contoh penggunaan constructor ini adalah sebagai berikut:
    public AccountTest(String name, int balance) {

        this.name = name;
        this.balance = balance;

        return;
    }


}
