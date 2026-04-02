package OOP;

public class Dosen extends Universitas {
    private String namaDosen;
    private String mataKuliah;

    public Dosen(String namaUniversitas, String lokasiUniversitas, String akreditasiUniversitas, String namaDosen,
            String mataKuliah) {
        super(namaUniversitas, lokasiUniversitas, akreditasiUniversitas);
        this.namaDosen = namaDosen;
        this.mataKuliah = mataKuliah;
    }

    @Override
    public void displayInfoUniversitas() {
        System.out.println("Data DIri Dosen");
        System.out.println("================================");

        System.out.println("Nama Dosen\t: " + namaDosen);
        System.out.println("Mata Kuliah\t: " + mataKuliah);
    }

    @Override
    public void Tugas() {

        System.out.println("Tugas Dosen");
        System.out.println("================================");

        System.out.println("1. Mengajar Mata Kuliah " + mataKuliah);
        System.out.println("2. Membimbing Mahasiswa");
        System.out.println("3. Melakukan Penelitian");
    }

}
