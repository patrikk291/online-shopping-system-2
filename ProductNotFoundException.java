/**
 * Custom exception class for handling cases where a product is not found
 * in the product management system.
 *
 * This exception is thrown when:
 * - A product search by ID returns no results
 * - An invalid product ID is provided to any product operation
 *
 * @author Online Shopping System
 * @version 1.0
 */
public class ProductNotFoundException extends Exception {

    /** The ID of the product that was not found */
    private int productId;

    /**
     * Constructs a ProductNotFoundException with the specified product ID.
     * Uses a default error message format.
     *
     * @param productId the ID of the product that was not found
     */
    public ProductNotFoundException(int productId) {
        super("Product with ID " + productId + " not found");
        this.productId = productId;
    }

    /**
     * Constructs a ProductNotFoundException with the specified product ID
     * and a custom error message.
     *
     * @param productId the ID of the product that was not found
     * @param message   the custom error message
     */
    public ProductNotFoundException(int productId, String message) {
        super(message);
        this.productId = productId;
    }

    /**
     * Constructs a ProductNotFoundException with a custom message only.
     * Sets productId to -1 to indicate unknown product ID.
     *
     * @param message the custom error message
     */
    public ProductNotFoundException(String message) {
        super(message);
        this.productId = -1;
    }

    /**
     * Gets the ID of the product that was not found.
     *
     * @return the product ID, or -1 if no specific ID was associated with this exception
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the product ID for this exception.
     *
     * @param productId the product ID to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Returns a detailed string representation of this exception,
     * including the product ID and error message.
     *
     * @return a string representation of this exception
     */
    @Override
    public String toString() {
        if (productId == -1) {
            return "ProductNotFoundException: " + getMessage();
        }
        return "ProductNotFoundException: " + getMessage() + " (Product ID: " + productId + ")";
    }

    /**
     * Creates a formatted error message for logging or display purposes.
     *
     * @return a formatted error message with timestamp and details
     */
    public String getFormattedErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ERROR] ProductNotFoundException occurred\n");
        sb.append("Product ID: ").append(productId == -1 ? "Unknown" : productId).append("\n");
        sb.append("Message: ").append(getMessage()).append("\n");
        sb.append("Timestamp: ").append(java.time.LocalDateTime.now()).append("\n");
        return sb.toString();
    }

    /**
     * Checks if this exception has a valid product ID associated with it.
     *
     * @return true if a valid product ID is set, false otherwise
     */
    public boolean hasValidProductId() {
        return productId > 0;
    }
}
