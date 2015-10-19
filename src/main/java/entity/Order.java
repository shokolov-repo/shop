package entity;


import java.sql.Date;

/**
 * Created by dmity on 13.10.15.
 */
public class Order {
    private long id;
    private long customerId;
    private long sellerId;
    private Date dateOrder;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", sellerId=" + sellerId +
                ", dateOrder=" + dateOrder +
                ", status='" + status + '\'' +
                '}';
    }
}
