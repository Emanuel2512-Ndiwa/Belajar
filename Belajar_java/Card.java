public class Card { // Nama Class: Kartu
    // Variabel Instans (Atribut)
    // 'private' berarti hanya bisa diakses di dalam class ini
    // 'final' berarti nilainya tidak bisa diubah setelah pertama kali diisi
    private final String face; // face = Nilai/Muka kartu (contoh: Ace, Deuce, King)
    private final String suit; // suit = Lambang/Jenis kartu (contoh: Hearts, Spades)

    // Constructor: Method khusus yang dipanggil saat membuat objek baru
    // Namanya harus sama persis dengan nama Class
    public Card(String cardFace, String cardSuit) { 
        this.face = cardFace; // 'this' merujuk ke variabel face milik class ini
        this.suit = cardSuit; // Mengisi nilai lambang kartu dari parameter
    }

    // Method toString: Mengubah objek menjadi bentuk teks (String)
    // Berguna saat kita ingin mencetak objek langsung menggunakan System.out.print
    public String toString() { 
        return face + " of " + suit; // Mengembalikan teks contoh: "Ace of Spades"
    }
}