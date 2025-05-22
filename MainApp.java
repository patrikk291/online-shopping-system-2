public class MainApp {
    public static void main(String[] args) {
        // Membuat satu objek Electronics
        Product laptop = new Electronics("Laptop Asus", 8500000, "Asus", 2.1);
        // Membuat satu objek Clothing
        Product tshirt = new clothing("Kaos Distro", 120000, Size.M, "Hitam");

        // Polymorphism: Panggil method secara dinamis
        System.out.println("\n=== Detail Produk 1 ===");
        laptop.displayDetails();
        if (laptop instanceof Discountable) {
            double discount = ((Discountable) laptop).getDiscountedPrice(10);
            System.out.println("Harga Setelah Diskon 10%: Rp" + discount);
        }

        System.out.println("\n=== Detail Produk 2 ===");
        tshirt.displayDetails();
        if (tshirt instanceof Discountable) {
            double discount = ((Discountable) tshirt).getDiscountedPrice(15);
            System.out.println("Harga Setelah Diskon 15%: Rp" + discount);
        }
    }
}