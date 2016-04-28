package entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * @author Shokolv Dmitry
 */
@Entity
@Table(name = "ORDERS",schema = "shop")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_ID", nullable = false)
    private long userId;
    @Column(name = "DATE_ORDER", nullable = false)
    private Date dateOrder;
    @Column(name = "STATUS", length = 10, nullable = false)
    private String status;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="order")
    private Set<ProductSold> productsSold;

    public Set<ProductSold> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<ProductSold> productsSold) {
        this.productsSold = productsSold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", dateOrder=" + dateOrder +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (userId != order.userId) return false;
        if (dateOrder != null ? !dateOrder.equals(order.dateOrder) : order.dateOrder != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (dateOrder != null ? dateOrder.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
