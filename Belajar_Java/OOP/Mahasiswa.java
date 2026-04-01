package OOP;

public class Mahasiswa extends Universitas {

    private String namaMahasiswa;
    private String jurusan;

    public Mahasiswa(String namaUniversitas, String lokasiUniversitas, String akreditasiUniversitas,
            String namaMahasiswa, String jurusan) {
        super(namaUniversitas, lokasiUniversitas, akreditasiUniversitas);
        this.namaMahasiswa = namaMahasiswa;
        this.jurusan = jurusan;
    }

    @Override
    public void displayInfoUniversitas() {
        System.out.println("Data Diri Mahasiswa");
        System.out.println("================================");

        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("Jurusan: " + jurusan);
    }

    @Override
    public void Tugas() {
        System.out.println("Tugas Mahasiswa");
        System.out.println("================================");

        System.out.println("1. Mengikuti Perkuliahan");
        System.out.println("2. Mengerjakan Tugas");
        System.out.println("3. Melakukan Penelitian");
    }

}
