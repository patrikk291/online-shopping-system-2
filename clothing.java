import java.text.DecimalFormat;

public class Clothing extends Product implements Discountable {
    private Size size;
    private String material;
    private String color;
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");

    public Clothing(int id, String name, double price, Size size, String material, String color) {
        super(id, name, price, "Clothing");
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public double calculateFinalPrice() {
        // Pajak 5%
        double tax = getPrice() * 0.05;
        return getPrice() + tax;
    }

    @Override
    public double getDiscountedPrice(double discountPercentage) {
        if (isEligibleForDiscount()) { // Metode ini tetap digunakan secara internal
            double discountAmount = calculateFinalPrice() * (discountPercentage / 100);
            return calculateFinalPrice() - discountAmount;
        }
        return calculateFinalPrice();
    }

    private boolean isEligibleForDiscount() { 
        // Hanya produk dengan harga > 100
        return getPrice() > 100.0;
    }

    @Override
    public String getProductInfo() {
        return String.format("%-5d | %-20s | %-12s | %-15s | %-40s | %s",
                getId(),
                getName(),
                Product.formatRupiah(getPrice()),
                getCategory(),
                String.format("Ukuran: %-5s, Bahan: %-10s, Warna: %-10s", size, material, color),
                Product.formatRupiah(calculateFinalPrice()));
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %d) - Rp%s", getName(), getId(), df.format(getPrice()));
    }

    // Getters
    public Size getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    // Setters (if needed, not directly used in MainApp for this flow)
    public void setSize(Size size) {
        this.size = size;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
