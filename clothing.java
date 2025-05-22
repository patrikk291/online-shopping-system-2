    public class clothing extends Product implements Discountable {
    private Size size;
    private String color;

    public clothing(String name, double price, Size size, String color) {
        super(name, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getCategory() {
        return "Clothing";
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
        System.out.println("Ukuran: " + size);
        System.out.println("Warna: " + color);
        System.out.println("Tanggal Dibuat: " + createdAt);
    }
}
    

