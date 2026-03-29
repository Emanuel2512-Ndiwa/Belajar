/**
 * PROJECT: FLOJA ORDER SYSTEM
 * Memadukan: Variabel, Function, Loop, Control Flow, dan Error Handling.
 */

const daftarKripik = [
    { id: 1, rasa: "Original", harga: 15000, stok: 10 },
    { id: 2, rasa: "Pedas Gila", harga: 17000, stok: 5 },
    { id: 3, rasa: "Keju Manja", harga: 18000, stok: 0 } // Habis
];

const prosesPesanan = (idProduk, jumlahBeli) => {
    try {
        // 1. Cari produk berdasarkan ID menggunakan Loop/Array Method
        let produkDitemukan = null;
        for (let i = 0; i < daftarKripik.length; i++) {
            if (daftarKripik[i].id === idProduk) {
                produkDitemukan = daftarKripik[i];
                break;
            }
        }

        // 2. LOGIKA CONTROL FLOW (ERROR HANDLING)
        // Jika produk tidak ditemukan, lempar error: "Produk tidak terdaftar!"
        if (!produkDitemukan) {
            throw new Error("Produk tidak terdaftar!");
        }

        // Jika jumlahBeli kurang dari atau sama dengan 0, lempar error: "Jumlah harus lebih dari 0!"
        if (jumlahBeli <= 0) {
            throw new Error("Jumlah harus lebih dari 0!");
        }

        // Jika stok produk adalah 0, lempar error: "Maaf, stok [Rasa] sedang habis!"
        if (produkDitemukan.stok === 0) {
            throw new Error(`Maaf, stok ${produkDitemukan.rasa} sedang habis!`);
        }

        // Jika jumlahBeli melebihi stok, lempar error: "Stok tidak mencukupi!"
        if (jumlahBeli > produkDitemukan.stok) {
            throw new Error("Stok tidak mencukupi!");
        }

        // 3. HITUNG TOTAL (Jika semua validasi lolos)
        const total = jumlahBeli * produkDitemukan.harga;
        
        // Gunakan Interpolasi Backtick untuk output sukses
        console.log(`✅ Pesanan Berhasil!`);
        console.log(`Item: ${produkDitemukan.rasa}`);
        console.log(`Total: Rp ${total.toLocaleString('id-ID')}`);

    } catch (error) {
        // 4. TANGKAP ERROR
        console.error(`❌ Gagal Memproses: ${error.message}`);
    } finally {
        console.log(`--- Selesai melayani pelanggan ---`);
    }
};

// --- UJI COBA LOGIKA KAMU ---
prosesPesanan(3, 2);  // Harusnya Berhasil (Original)
