import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.text.DecimalFormat; //

public abstract class Product {
    protected int id;
    protected String name;
    protected double price;
    protected String category;
    protected LocalDate createdDate;
    protected LocalTime createdTime;

    // DecimalFormat untuk memformat harga menjadi Rupiah dengan pemisah ribuan dan dua desimal
    private static final DecimalFormat df = new DecimalFormat("#,##0.00"); //

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now.toLocalDate();
        this.createdTime = now.toLocalTime();
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateFinalPrice();
    public abstract String getCategory();
    public abstract String getProductInfo();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        // Menggunakan format Rupiah di toString()
        return String.format("ID: %d, Nama: %s, Harga: Rp%s, Kategori: %s",
                           id, name, df.format(price), category); //
    }

    // Metode helper statis untuk memformat jumlah ke Rupiah
    public static String formatRupiah(double amount) {
        return "Rp" + df.format(amount); //
    }
}
