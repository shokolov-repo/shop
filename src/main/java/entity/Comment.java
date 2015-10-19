package entity;

/**
 * Created by dmity on 13.10.15.
 */
public class Comment {
    private long id;
    private long productId;
    private String customerName;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long customerId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
