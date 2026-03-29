let inputUmur = "23"; // Contoh input umur dari pengguna

try{
    if(typeof inputUmur !== 'number') {
        throw new Error("Input harus berupa angka!");
    }
    if(inputUmur <18) {
        throw new Error("Maaf, Anda belum cukup umur untuk mengakses konten ini.");
    }
}catch(error) {
    console.error(`❌ Gagal Memproses: ${error.message}`);
} finally {
    console.log(`--- Selesai memeriksa input ---`);
}