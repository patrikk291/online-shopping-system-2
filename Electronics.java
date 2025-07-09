import java.text.DecimalFormat; //

public class Electronics extends Product implements Discountable {
    private Specification specification;
    private static final DecimalFormat df = new DecimalFormat("#,##0.00"); // Untuk format berat

    public Electronics(int id, String name, double price, double weight, String brand) { // Menambahkan ID
        super(id, name, price, "Electronics"); //
        this.specification = new Specification(weight, brand);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public double getDiscountedPrice(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public double calculateFinalPrice() {
        // Untuk Elektronik, diasumsikan tidak ada pajak tambahan atau perhitungan kompleks untuk saat ini
        return getPrice(); //
    }

    @Override
    public String getProductInfo() {
        // Merapikan format output untuk tabel di ProductManager
        return String.format("%-5d | %-20s | %-12s | %-15s | %-40s | %s",
                getId(),
                getName(),
                Product.formatRupiah(getPrice()), // Menggunakan formatRupiah untuk harga asli
                getCategory(),
                specification.getSpecs(), // Menggunakan getSpecs() untuk detail brand dan weight
                Product.formatRupiah(calculateFinalPrice())); // Menggunakan formatRupiah untuk harga final
    }

    public Specification getSpecification() {
        return specification;
    }

    public class Specification {
        private double weight;
        private String brand;

        public Specification(double weight, String brand) {
            this.weight = weight;
            this.brand = brand;
        }

        public String getSpecs() {
            // Merapikan format di sini juga agar lebih mudah dibaca di output
            return "Brand: " + brand + ", Berat: " + df.format(weight) + " kg"; //
        }

        public double getWeight() {
            return weight;
        }

        public String getBrand() { // Menambahkan getter untuk brand agar bisa diakses jika diperlukan
            return brand;
        }
    }
}
