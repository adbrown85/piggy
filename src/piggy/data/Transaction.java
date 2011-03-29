package piggy.data;


/**
 * Single change to an account.
 */
public class Transaction {
    
    private String date;
    private float amount;
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
        sb.append(" date='" + date + "'");
        sb.append(" amount='" + amount + "'");
        return sb.toString();
    }
    
    /** Returns a copy of the object. */
    @Override
    public Transaction clone() {
        
        Transaction copy;
        
        try {
            copy = (Transaction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unexpected exception in clone!");
        }
        
        return copy;
    }
    
    //--------------------------------------------------
    // Getters and setters
    //
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public float getAmount() {
        return amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
