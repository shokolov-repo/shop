package entity;

import javax.persistence.*;

/**
 * @author Shokolov Dmitry
 */
@Entity
@Table(name = "USERS",schema = "shop")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;
    @Column(name = "LAST_NAME", length = 20)
    private String lastName;
    @Column(name = "ADDRESS", length = 100)
    private String address;
    @Column(name = "PHONE", length = 13)
    private String phone;
    @Column(name = "EMAIL", length = 30, unique = true, nullable = false)
    private String email;
    @Column(name = "PASSWORD", length = 10, nullable = false)
    private String password;
    @Column(name = "ROLE", length = 10, nullable = false)
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
