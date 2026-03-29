// Gunakan input manual untuk testing di Node.js
const inputGaji = 6000000; 

function hitungPajak(gaji) {
    try {
        // 1. FAIL EARLY (Validasi di awal)
        if (typeof gaji !== 'number' || isNaN(gaji)) {
            throw new Error("Input gaji harus berupa angka!");
        }
        if (gaji < 0) {
            throw new Error("Gaji tidak masuk akal (negatif)!");
        }

        // 2. LOGIKA BISNIS (Hanya jalan jika validasi lolos)
        let persentasePajak = 0;
        if (gaji >= 5000000) {
            persentasePajak = 0.1; // 10%
        }

        const totalPajak = gaji * persentasePajak;
        
        // 3. OUTPUT SUKSES
        console.log(`✅ Perhitungan Berhasil:`);
        console.log(`- Gaji Bruto: Rp ${gaji.toLocaleString('id-ID')}`);
        console.log(`- Pajak (${persentasePajak * 100}%): Rp ${totalPajak.toLocaleString('id-ID')}`);

    } catch (error) {
        // Menangkap semua kegagalan di atas
        console.error(`❌ Gagal Memproses: ${error.message}`);
    } finally {
        console.log(`--- Proses perhitungan pajak selesai ---`);
    }
}

hitungPajak(inputGaji);