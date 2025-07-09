import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat; //

public class ShoppingCart {
    private static class CartItem {
        Product product;
        int quantity;

        CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }

    private List<CartItem> items = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("#,##0.00"); // Mengubah format DecimalFormat

    public void addItem(Product item, int quantity) {
        // Cek jika produk sudah ada di keranjang, tambahkan kuantitasnya
        for (CartItem cartItem : items) {
            if (cartItem.product.getId() == item.getId()) {
                cartItem.quantity += quantity;
                System.out.println("Kuantitas produk '" + item.getName() + "' ditambahkan menjadi " + cartItem.quantity);
                return;
            }
        }
        // Jika belum ada, tambahkan sebagai item baru
        items.add(new CartItem(item, quantity));
    }

    public void printCart(double discountPercentage) {
        System.out.println("\n=================================");
        System.out.println("     DETAIL ISI KERANJANG");
        System.out.println("=================================");
        double totalKeseluruhan = 0;
        int itemNumber = 1;

        if (items.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
            System.out.println("=================================");
            return;
        }

        for (CartItem cartItem : items) {
            Product item = cartItem.product;
            int qty = cartItem.quantity;
            double itemPriceAfterDiscountOrTax;
            double subtotal;

            System.out.println("\n--- Item " + itemNumber + " ---"); //
            System.out.println("ID Produk        : " + item.getId()); //
            System.out.println("Nama Produk      : " + item.getName()); //
            System.out.println("Kategori         : " + item.getCategory()); //

            if (item instanceof Clothing) {
                Clothing clothing = (Clothing) item;
                System.out.println("Ukuran           : " + clothing.getSize()); //
                System.out.println("Bahan            : " + clothing.getMaterial()); //
                System.out.println("Warna            : " + clothing.getColor()); //
            } else if (item instanceof Electronics) {
                Electronics electronics = (Electronics) item;
                // Menggunakan getBrand() dan getWeight() dari Specification secara terpisah untuk tampilan rapi
                System.out.println("Brand            : " + electronics.getSpecification().getBrand()); //
                System.out.println("Berat            : " + df.format(electronics.getSpecification().getWeight()) + " kg"); //
            }

            System.out.println("Harga Satuan     : " + Product.formatRupiah(item.getPrice())); // Menggunakan formatRupiah
            System.out.println("Jumlah           : " + qty); //
            System.out.println("Tanggal Dibuat   : " + item.getCreatedDate()); //
            System.out.println("Waktu Dibuat     : " + item.getCreatedTime().withNano(0)); //

            // Calculate item price considering discounts and final price calculation
            if (item instanceof Discountable) {
                itemPriceAfterDiscountOrTax = ((Discountable) item).getDiscountedPrice(discountPercentage);
                System.out.println("Harga Setelah Diskon (per item) : " + Product.formatRupiah(itemPriceAfterDiscountOrTax)); // Menggunakan formatRupiah
            } else {
                itemPriceAfterDiscountOrTax = item.calculateFinalPrice(); // Price might include tax
                System.out.println("Harga Final (per item)  : " + Product.formatRupiah(itemPriceAfterDiscountOrTax)); // Menggunakan formatRupiah
            }

            subtotal = itemPriceAfterDiscountOrTax * qty;
            totalKeseluruhan += subtotal;
            System.out.println("Subtotal Item    : " + Product.formatRupiah(subtotal)); // Menggunakan formatRupiah
            itemNumber++;
        }
        System.out.println("=================================");
        System.out.println("TOTAL HARGA KESELURUHAN : " + Product.formatRupiah(totalKeseluruhan)); // Menggunakan formatRupiah
        System.out.println("=================================");
    }
}
