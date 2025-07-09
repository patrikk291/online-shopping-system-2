# Aplikasi Belanja Online Sederhana
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


---

**Dibuat oleh:** 
1. Celvin Saputra
2. Nizar Awaludin

**Lisensi:** [Opsional: Contoh: MIT License, atau tinggalkan jika tidak ada lisensi spesifik]
