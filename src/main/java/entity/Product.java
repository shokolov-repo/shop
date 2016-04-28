package entity;

import javax.persistence.*;

/**
 * @author Shokolov Dmitry
 */
@Entity
@Table(name = "PRODUCTS",schema = "shop")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE", length = 20, nullable = false)
    private String title;
    @Column(name = "PRICE", length = 10, nullable = false)
    private double price;
    @Column(name = "QUANTITY", length = 10, nullable = false)
    private int quantity;
    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        if (this.id == product.getId()) {
            return true;
        }
        return false;
    }
}
