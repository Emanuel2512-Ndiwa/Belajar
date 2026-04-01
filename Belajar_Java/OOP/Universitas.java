package OOP;

public class Universitas {

    private String namaUniversitas;
    private String lokasiUniversitas;
    private String AkreditasiUniversitas;

    public Universitas(String namaUniversitas, String lokasiUniversitas, String akreditasiUniversitas) {
        this.namaUniversitas = namaUniversitas;
        this.lokasiUniversitas = lokasiUniversitas;
        this.AkreditasiUniversitas = akreditasiUniversitas;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }

    public String getLokasiUniversitas() {
        return lokasiUniversitas;
    }

    public String getAkreditasiUniversitas() {
        return AkreditasiUniversitas;
    }

    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public void setLokasiUniversitas(String lokasiUniversitas) {
        this.lokasiUniversitas = lokasiUniversitas;
    }

    public void setAkreditasiUniversitas(String akreditasiUniversitas) {
        this.AkreditasiUniversitas = akreditasiUniversitas;
    }

    public void displayInfoUniversitas() {
        System.out.println();
        System.out.println();
        System.out.println("=================================");
        System.out.println("Informasi Universitas");
        System.out.println("=================================");

        System.out.println("Nama Universitas\t: " + namaUniversitas);
        System.out.println("Lokasi Universitas\t: " + lokasiUniversitas);
        System.out.println("Akreditasi Universitas\t: " + AkreditasiUniversitas);
        System.out.println("================================");
        System.out.println();
        ruangan();
    }

    public void ruangan() {
        String[][] ruangan = { { "Labolaturium Komputer", "Labolatorium Fisika", "Labolatorium Kimia" },
                { "Aula", "Perpustakaan", "Kantin" },
                { "Sekretariat Informatika", "Sekretariat Fisika", "Sekretariat Kimia" },
                { "Ruang Dosen Informatika", "Ruang Dosen Fisika", "Ruang Dosen Kimia" }
        };
        System.out.println("=================================");
        System.out.println("Daftar Ruangan:");
        System.out.println("=================================");
        for (String[] baris : ruangan) {
            for (String ruang : baris) {

                System.out.printf("%-30s", ruang);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("=================================");
        System.out.println();

    }

    public void Tugas() {

    }

}
