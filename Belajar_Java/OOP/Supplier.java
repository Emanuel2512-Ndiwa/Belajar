package OOP;

public class Supplier {
    private String idSupplier;
    private String namaSupplier;
    private String alamat;
    private String telepon;

    public Supplier(String idSupplier, String namaSupplier, String alamat, String telepon) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void tampilkanInfo() {
        System.out.println("ID Supplier   : " + idSupplier);
        System.out.println("Nama Supplier : " + namaSupplier);
        System.out.println("Alamat        : " + alamat);
        System.out.println("Telepon       : " + telepon);
        System.out.println("-----------------------------");
    }
}
