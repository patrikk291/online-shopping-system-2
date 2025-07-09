import java.util.*;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        // Cek duplikat berdasarkan ID
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                System.out.println("Produk dengan ID " + product.getId() + " sudah ada!"); //
                return false;
            }
        }
        products.add(product);
        System.out.println("Produk berhasil ditambahkan: " + product.getName()); //
        return true;
    }

    public ArrayList<Product> getAllProducts() {
        return new ArrayList<>(products); // Mengembalikan salinan untuk mencegah modifikasi eksternal
    }

    public Product findProductById(int id) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException(id);
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk tersedia.");
            return;
        }

        System.out.println("=====================================================================================================================================================");
        // Header tabel yang lebih rapi dengan lebar kolom yang disesuaikan
        System.out.printf("%-5s | %-20s | %-12s | %-15s | %-40s | %s\n",
                          "ID", "Nama Produk", "Harga Asli", "Kategori", "Detail", "Harga Final");
        System.out.println("=====================================================================================================================================================");
        for (Product product : products) {
            System.out.println(product.getProductInfo());
        }
        System.out.println("=====================================================================================================================================================");
    }

    public int getTotalProducts() {
        return products.size();
    }
}
