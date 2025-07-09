import java.util.InputMismatchException; // Import untuk menangani input non-angka
import java.util.Scanner;

public class MainApp {
    private static int nextProductId = 1; // Untuk menghasilkan ID produk yang unik

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        ProductManager productManager = new ProductManager(); // Menggunakan ProductManager
        boolean lanjut = true;

        // Inisialisasi produk dalam ProductManager
        productManager.addProduct(new Electronics(nextProductId++, "Laptop Asus", 10000000, 1.5, "ASUS"));
        productManager.addProduct(new Electronics(nextProductId++, "Iphone 20 Pro Max", 55000000, 2.0, "Apple"));
        productManager.addProduct(new Electronics(nextProductId++, "Pulpen Samsung 30cm", 7000000, 0.3, "Samsung"));
        productManager.addProduct(new Electronics(nextProductId++, "Kulkas 7 Pintu", 33000000, 20.0, "Lahkokgini"));
        productManager.addProduct(new Clothing(nextProductId++, "Baju Beruang Petir", 99999, Size.M, "Katun", "Hitam"));
        productManager.addProduct(new Clothing(nextProductId++, "Celana Kulot", 149999, Size.L, "Katun", "Cokelat"));
        productManager.addProduct(new Clothing(nextProductId++, "Polo", 250000, Size.S, "Katun", "Hitam"));
        productManager.addProduct(new Clothing(nextProductId++, "Celana CutBray", 200000, Size.XL, "Denim", "Hitam"));
        productManager.addProduct(new Clothing(nextProductId++, "Jaket Gengster", 150000, Size.M, "Polyester", "Hitam"));


        System.out.println("=================================");
        System.out.println("  SELAMAT DATANG DI ONLINE SHOP!");
        System.out.println("=================================");

        while (lanjut) {
            System.out.println("\n--- DAFTAR PRODUK TERSEDIA ---");
            productManager.displayAllProducts(); // Menampilkan produk dari ProductManager

            int pilihanId = -1;
            int jumlah = -1;

            try {
                System.out.print("Masukkan ID produk yang ingin dibeli: ");
                pilihanId = scanner.nextInt();

                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                jumlah = scanner.nextInt();
                scanner.nextLine(); // Mengonsumsi newline

                Product selectedProduct = productManager.findProductById(pilihanId); // Mencari produk berdasarkan ID
                cart.addItem(selectedProduct, jumlah); // Menambahkan ke keranjang
                System.out.println("Produk '" + selectedProduct.getName() + "' berhasil ditambahkan ke keranjang.");

            } catch (InputMismatchException e) { // Menangani input yang bukan angka
                System.out.println("Input tidak valid. Harap masukkan angka untuk ID produk dan jumlah.");
                scanner.nextLine(); // Membersihkan input yang tidak valid dari scanner
            } catch (ProductNotFoundException e) { // Menangani produk tidak ditemukan
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) { // Menangani kesalahan lain, misal Enum.valueOf (jika ada input ukuran salah)
                System.out.println("Error: " + e.getMessage());
            }


            System.out.print("\nIngin belanja lagi? (y/n): ");
            String jawaban = scanner.nextLine();
            lanjut = jawaban.equalsIgnoreCase("y");
        }

        // Tampilkan keranjang dengan diskon 10%
        cart.printCart(10);

        System.out.println("\nTerima kasih sudah berbelanja!");
        scanner.close();
    }
}
