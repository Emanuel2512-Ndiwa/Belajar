const keranjang = [{nama:'kripik', harga: 1000, jumlah: 2}];

function hargaBarang(keranjang){

    for(const i=0; i<keranjang.length; i++){
        try {
            if(typeof keranjang[i].harga !== 'number' || isNaN(keranjang[i].jumlah)){
                throw new Error("Harga dan jumlah harus berupa angka!");
            }
            const totalHarga = keranjang[i].harga * keranjang[i].jumlah;
            console.log(`✅ Perhitungan Berhasil:`);
            console.log(`- Nama Barang: ${keranjang[i].nama}`);
            console.log(`- Harga Satuan: Rp ${keranjang[i].harga.toLocaleString('id-ID')}`);
            console.log(`- Jumlah: ${keranjang[i].jumlah}`);
            console.log(`- Total Harga: Rp ${totalHarga.toLocaleString('id-ID')}`);
            
        } catch (error) {
            console.error(`❌ Gagal Memproses: ${error.message}`);
        }

    }

}