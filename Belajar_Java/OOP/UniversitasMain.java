package OOP;

public class UniversitasMain {
    public static void main(String[] args) {
        Universitas Universitas1 = new Universitas("Universitas Sanata Dharma", "Maguwoharjo, Depok", "A");
        Universitas1.displayInfoUniversitas();

        Dosen Dosen1 = new Dosen("Universitas Sanata Dharma", "Maguwoharjo, Depok", "A", "Bapak Agus", "Pemrograman Berorientasi Objek");
        Dosen1.displayInfoUniversitas();
        Dosen1.Tugas();
    }
    
}
