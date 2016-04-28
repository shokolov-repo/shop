package entity;

import javax.persistence.*;

/**
 * @author Shokolov Dmitry
 */
@Entity
@Table(name = "COMMENTS",schema = "shop")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "PRODUCT_ID", nullable = false)
    private long productId;
    @Column(name = "USER_ID", nullable = false)
    private long userId;
    @Column(name = "USER_NAME", length = 20, nullable = false)
    private String userName;
    @Column(name = "CONTENT", length = 250, nullable = false)
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
