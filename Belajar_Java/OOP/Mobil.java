package OOP;

public class Mobil {
    private String[] merk;
    private String[] warna;
    private int []tahun;
    private String []NamaPemilik;

    public Mobil(String[] merk, String[] warna, int []tahun, String []NamaPemilik) {
        this.merk = merk;
        this.warna = warna;
        this.tahun = tahun;
        this.NamaPemilik = NamaPemilik;
    }
    public String getNamaPemilik() {
        return []NamaPemilik;
    }
    public void setNamaPemilik(String NamaPemilik) {
        this.NamaPemilik = NamaPemilik;
    }

    public String getMerk() {
        return merk;
    }

    public String getWarna() {
        return warna;
    }

    public int getTahun() {
        return tahun;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void maju() {
        System.out.println("Mobil " + merk + " maju");
    }

    public void mundur() {
        System.out.println("Mobil " + merk + " mundur");
    }

    public void arah(String arah) {
        System.out.println("Mobil " + merk + " belok ke " + arah);
    }

}
