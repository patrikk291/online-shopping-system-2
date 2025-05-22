public class Electronics extends Product implements Discountable {
    private Specification spec;

    public Electronics(String name, double price, String brand, double weight) {
        super(name, price);
        this.spec = new Specification(weight, brand);
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
    public void displayDetails() {
        System.out.println("Nama Produk: " + name);
        System.out.println("Kategori: " + getCategory());
        System.out.println("Harga: Rp" + price);
        System.out.println("Spesifikasi: " + spec.getSpecs());
        System.out.println("Tanggal Dibuat: " + createdAt);
    }

    // Inner Class
    public class Specification {
        private double weight;
        private String brand;

        public Specification(double weight, String brand) {
            this.weight = weight;
            this.brand = brand;
        }

        public String getSpecs() {
            return brand + ", " + weight + " kg";
        }
    }
}