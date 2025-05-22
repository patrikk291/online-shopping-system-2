import java.time.LocalDateTime;

public abstract class Product {
    protected String name;
    protected double price;
    protected LocalDateTime createdAt;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public abstract String getCategory();

    public abstract void displayDetails();
}