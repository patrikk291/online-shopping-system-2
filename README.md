**1. Inisialisasi Objek Produk**
Program dimulai dari kelas MainApp.
Di dalamnya, dua objek dibuat:
1. Satu objek dari kelas Electronics
2. Satu objek dari kelas Clothing

**2. Encapsulation**
Setiap objek dibuat dengan memanggil konstruktor yang mengisi atribut seperti name, price, dan productId.
Semua atribut bersifat private (enkapsulasi) dan hanya dapat diakses melalui method get dan set.

**3. Inheritance**
Kelas Electronics dan Clothing merupakan subclass dari Product.
Mereka mewarisi atribut umum dari Product dan menambahkan atribut spesifik:

**4. Polymorphism**
Electronics dan Clothing mengimplementasikan interface Discountable.

**5. Struktur Direktori**
1. Product.java = Kelas induk produk (abstract)
2. Electronics.java = Subclass dengan inner class + implementasi Discountable
3. Clothing.java = Subclass menggunakan enum Size + implementasi Discountable
4. Size.java = Enum ukuran
5. Discountable.java = Interface diskon
6. ShoppingCart.java = Menyimpan dan menampilkan isi belanja
7. MainApp.java = Menjalankan program dan menerima input user

**ANGGOTA KELOMPOK**
1. Nizar Awaludin (51424044)

