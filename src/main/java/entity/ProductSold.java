package entity;

import javax.persistence.*;

/**
 * @author Shokolv Dmitry
 */
@Entity
@Table(name = "PRODUCTS_SOLD",schema = "shop")
public class ProductSold {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE", length = 250, nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable=false)
    private Order order;
    @Column(name = "QUANTITY", length = 10, nullable = false)
    private int quantity;
    @Column(name = "PRICE", length = 10, nullable = false)
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductSold{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", order=" + order +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSold)) return false;

        ProductSold sold = (ProductSold) o;

        if (id != sold.id) return false;
        if (Double.compare(sold.price, price) != 0) return false;
        if (quantity != sold.quantity) return false;
        if (title != null ? !title.equals(sold.title) : sold.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
