# Aplikasi Belanja Online Sederhana

![Gambar Tampilan GUI Aplikasi](https://googleusercontent.com/image_generation_content/0)
*(Gambaran umum antarmuka pengguna aplikasi)*

Aplikasi ini adalah simulasi sederhana dari sebuah toko belanja online berbasis Java Swing yang dibangun menggunakan NetBeans IDE. Aplikasi memungkinkan pengguna untuk melihat daftar produk, menambahkan produk ke keranjang belanja, dan melakukan checkout.

## Fitur Utama

* **Daftar Produk:** Menampilkan berbagai macam produk (elektronik dan pakaian) dengan detail seperti ID, nama, harga, kategori, dan detail spesifik (ukuran/bahan untuk pakaian, brand/berat untuk elektronik).
* **Perhitungan Harga Final:** Otomatis menghitung harga final produk, termasuk penerapan diskon untuk produk yang memenuhi syarat (`Discountable`).
* **Keranjang Belanja:** Memungkinkan pengguna menambahkan produk berdasarkan ID dan jumlah ke keranjang belanja.
* **Total Harga Keranjang:** Menampilkan total harga keseluruhan dari item-item di dalam keranjang secara real-time.
* **Checkout Sederhana:** Fungsi checkout untuk menyelesaikan transaksi (simulasi).
* **Penanganan Error:** Validasi input dan penanganan error dasar (misalnya, produk tidak ditemukan, input tidak valid).

## Struktur Proyek

Proyek ini terdiri dari beberapa kelas Java yang diorganisir sebagai berikut:

* `MainApp.java`: Kelas utama untuk menjalankan aplikasi (saat ini akan meluncurkan GUI).
* `ShoppingAppGUI.java`: Kelas utama untuk antarmuka pengguna grafis (GUI) menggunakan Java Swing.
* `Product.java`: Kelas abstrak dasar untuk produk, dengan atribut umum dan metode untuk memformat harga.
* `Clothing.java`: Sub-kelas dari `Product` untuk produk pakaian, dengan atribut tambahan seperti ukuran, bahan, dan warna. Mengimplementasikan `Discountable`.
* `Electronics.java`: Sub-kelas dari `Product` untuk produk elektronik, dengan atribut tambahan untuk spesifikasi (brand, berat). Mengimplementasikan `Discountable`.
* `Size.java`: Enum untuk mendefinisikan ukuran pakaian.
* `Discountable.java`: Antarmuka yang mendefinisikan kontrak untuk produk yang dapat didiskon.
* `ProductNotFoundException.java`: Custom exception untuk menangani kasus produk tidak ditemukan.
* `ProductManager.java`: Mengelola daftar produk yang tersedia di toko.
* `ShoppingCart.java`: Mengelola item-item di dalam keranjang belanja, termasuk penambahan item dan tampilan detail keranjang.
* `TransactionManager.java`: (Opsional/Future Work) Dapat digunakan untuk mengelola riwayat transaksi.

## Persyaratan Sistem

* Java Development Kit (JDK) 8 atau yang lebih baru (disarankan JDK 11+).
* NetBeans IDE (versi 8.2 atau yang lebih baru, disarankan NetBeans 12+).

## Cara Menjalankan Aplikasi

1.  **Clone atau Unduh Proyek:**
    * Jika Anda menggunakan Git:
        ```bash
        git clone <URL_repository_anda>
        ```
    * Jika tidak, unduh file ZIP proyek dan ekstrak ke lokasi yang Anda inginkan.

2.  **Buka Proyek di NetBeans:**
    * Buka NetBeans IDE.
    * Pilih `File` > `Open Project...`.
    * Navigasikan ke direktori tempat Anda menyimpan/mengekstrak proyek dan pilih folder proyeknya.
    * Klik `Open Project`.

3.  **Pastikan Semua File Ada:**
    * Pastikan semua file Java yang disebutkan di atas (`.java`) berada di dalam folder `Source Packages` -> `[nama_paket_anda]` (misalnya, `onlineshop`) di proyek NetBeans Anda.

4.  **Lakukan "Clean and Build":**
    * Di jendela "Projects", klik kanan pada nama proyek Anda.
    * Pilih `Clean and Build`. Ini akan mengkompilasi semua kode sumber. Pastikan tidak ada error kompilasi.

5.  **Jalankan Aplikasi:**
    * Klik kanan pada nama proyek Anda.
    * Pilih `Run` atau tekan `F6`.

    Aplikasi GUI akan muncul dalam jendela baru.

## Cara Menggunakan Aplikasi

1.  **Melihat Produk:** Tabel di sisi kiri akan menampilkan daftar produk yang tersedia beserta detailnya.
2.  **Menambahkan ke Keranjang:**
    * Masukkan `Product ID` (kolom pertama di tabel produk) di kolom input `Product ID`.
    * Masukkan `Quantity` (jumlah) yang diinginkan di kolom input `Quantity`.
    * Klik tombol `Add to Cart`.
    * Akan muncul pesan konfirmasi dan `Cart Contents` di area teks akan diperbarui. `Total` juga akan berubah.
3.  **Checkout:**
    * Setelah menambahkan semua item yang diinginkan, klik tombol `Checkout`.
    * Anda akan melihat konfirmasi total pembayaran.
    * Klik `Yes` untuk melanjutkan checkout (ini akan mengosongkan keranjang dan menampilkan pesan berhasil).

## Pengembangan Lebih Lanjut (Future Work)

* **Persistent Data:** Menyimpan data produk dan transaksi ke file atau database.
* **Manajemen Stok:** Melacak jumlah stok produk dan mencegah pembelian melebihi stok.
* **Login/Registrasi Pengguna:** Sistem autentikasi pengguna.
* **Pembayaran Asli:** Integrasi dengan gateway pembayaran.
* **UI/UX yang Lebih Baik:** Desain antarmuka yang lebih modern dan responsif.
* **Fitur Pencarian/Filter:** Memungkinkan pengguna mencari atau memfilter produk.

---

**Dibuat oleh:** 
1. Celvin Saputra
2. Nizar Awaludin

**Lisensi:** [Opsional: Contoh: MIT License, atau tinggalkan jika tidak ada lisensi spesifik]
