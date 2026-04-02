package OOP;

public class Inventaris {

    private Barang[] daftarBarang;
    private Supplier[] daftarSupplier;

    public Inventaris() {
        daftarBarang = new Barang[100];
        daftarSupplier = new Supplier[100];
    }

    public void tambahSupplier(Supplier supplier) {
        for (int i = 0; i < daftarSupplier.length; i++) {
            if (daftarSupplier[i] == null) {
                daftarSupplier[i] = supplier;
                System.out.println("Supplier berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Daftar supplier penuh.");
    }

    public void tampilkanSemuaSupplier() {
        System.out.println("Daftar Supplier:");
        System.out.println("------------------------");

        boolean adaSupplier = false;
        for (int i = 0; i < daftarSupplier.length; i++) {
            if (daftarSupplier[i] != null) {
                adaSupplier = true;
                daftarSupplier[i].tampilkanInfo();
            }
        }

        if (!adaSupplier) {
            System.out.println("Belum ada supplier.");
        }
    }

    public Supplier cariSupplierById(String idSupplier) {
        for (int i = 0; i < daftarSupplier.length; i++) {
            if (daftarSupplier[i] != null && daftarSupplier[i].getIdSupplier().equalsIgnoreCase(idSupplier)) {
                return daftarSupplier[i];
            }
        }
        return null;
    }

    public void tambahBarang(Barang barang) {
        for (int i = 0; i < daftarBarang.length; i++) {
            if (daftarBarang[i] == null) {
                daftarBarang[i] = barang;
                System.out.println("Barang berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Inventaris penuh. Barang tidak bisa ditambahkan.");
    }

    public void tampilkanSemuaBarang() {
        System.out.println("Daftar Barang:");
        System.out.println("------------------------");

        boolean adaBarang = false;
        for (int i = 0; i < daftarBarang.length; i++) {
            if (daftarBarang[i] != null) {
                adaBarang = true;
                daftarBarang[i].tampilkanInfo();
            }
        }

        if (!adaBarang) {
            System.out.println("Belum ada barang di inventaris.");
        }
    }

    public int cariBarangByKode(String kodeBarang) {
        for (int i = 0; i < daftarBarang.length; i++) {
            if (daftarBarang[i] != null && daftarBarang[i].getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                return i;
            }
        }
        return -1;
    }

    public void jualBarang(String kodeBarang, int jumlah) {
        int indexBarang = cariBarangByKode(kodeBarang);

        if (indexBarang != -1) {
            daftarBarang[indexBarang].kurangiStok(jumlah);
            System.out.println("Stok barang " + daftarBarang[indexBarang].getNamaBarang()
                    + " sekarang: " + daftarBarang[indexBarang].getStok());
        } else {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        }
    }

    public void hitungTotalNilaiStok() {
        int totalNilai = 0;
        for (int i = 0; i < daftarBarang.length; i++) {
            if (daftarBarang[i] != null) {
                totalNilai += daftarBarang[i].hitungNilaiStok();
            }
        }

        System.out.println("Total nilai stok seluruh barang: " + totalNilai);
    }
}
