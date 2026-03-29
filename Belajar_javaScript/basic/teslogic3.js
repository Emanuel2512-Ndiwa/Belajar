const user = { nama: "Eman", role: "admin", status: "active" };

function cekAkses(user) {
    try {
        // 1. Validasi Error (Gunakan IF untuk mencegat kegagalan)
        if (user.status !== "active") {
            throw new Error("Akun anda ditangguhkan atau tidak aktif!");
        }

        if (user.role !== "admin") {
            throw new Error("Akses ditolak. Anda bukan admin.");
        }

        // 2. Alur Sukses (Tidak perlu di-throw, langsung jalankan)
        console.log(`✅ Akses Diberikan. Selamat datang, ${user.nama}!`);

    } catch (error) {
        // Hanya menangkap yang benar-benar error
        console.error(`❌ Gagal Memproses: ${error.message}`);
    } finally {
        console.log(`--- Selesai memeriksa akses ---`);
    }
}

cekAkses(user);