let username = "JohnDoe"; // String: Teks yang diapit tanda kutip.
let password = "23"; // String: Teks yang diapit tanda kutip.

try {

    if (username === "" || password === "") {
        throw new Error("Username dan Password tidak boleh kosong!");
    }
    if (password.length < 8) {
        throw new Error("Password harus minimal 8 karakter!");
    }

} catch (error) {
    console.error(`❌ Gagal Memproses: ${error.message}`);
} finally {
    console.log(`--- Selesai memeriksa input ---`);
}