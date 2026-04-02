package OOP;

public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int harga;
    private int stok;
    private Supplier supplier;

    public Barang(String kodeBarang, String namaBarang, int harga, int stok, Supplier supplier) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.supplier = supplier;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah tambah stok harus lebih dari 0.");
            return;
        }

        stok += jumlah;
        System.out.println("Stok berhasil ditambahkan.");
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah pengurangan stok harus lebih dari 0.");
            return;
        }

        if (jumlah > stok) {
            System.out.println("Stok tidak cukup untuk dikurangi.");
        } else {
            stok -= jumlah;
            System.out.println("Stok berhasil dikurangi.");
        }
    }

    public int hitungNilaiStok() {
        return harga * stok;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Barang   : " + kodeBarang);
        System.out.println("Nama Barang   : " + namaBarang);
        System.out.println("Harga         : " + harga);
        System.out.println("Stok          : " + stok);
        System.out.println("Supplier      : " + supplier.getNamaSupplier());
        System.out.println("-----------------------------");
    }
}
