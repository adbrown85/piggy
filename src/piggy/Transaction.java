package piggy;


public class Transaction {
    
    private String date;
    private String amount;
    private String description;
    private String category;
    
    //--------------------------------------------------
    // Converters
    //
    
    /** Returns a string representation of the object. */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Transaction");
        sb.append("date='" + date + "'");
        sb.append("amount='" + amount + "'");
        return sb.toString();
    }
    
    //--------------------------------------------------
    // Getters and setters
    //
    
    String getCategory() {
        return category;
    }
    
    void setCategory(String category) {
        this.category = category;
    }
    
    String getDate() {
        return date;
    }
    
    void setDate(String date) {
        this.date = date;
    }
    
    String getDescription() {
        return description;
    }
    
    void setDescription(String description) {
        this.description = description;
    }
    
    String getAmount() {
        return amount;
    }
    
    void setAmount(String amount) {
        this.amount = amount;
    }
}
