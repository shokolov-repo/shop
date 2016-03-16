package view;

import entity.Product;

/**
 * Created by dmity on 13.10.15.
 */
public class ProductCart {
    private long id;
    private String title;
    private double price;
    private int quantity = 1;

    public ProductCart(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();

    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        ProductCart product = (ProductCart) obj;
        if (this.id == product.getId()) {
            return true;
        }
        return false;
    }
}
