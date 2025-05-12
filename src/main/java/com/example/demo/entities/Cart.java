package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/** Cart.java Class:
 * @author Emily Combs
 */
@Entity
@Table(name="carts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    /*
    =======================================
    Fields with JPA Mappings
    =======================================
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number", nullable = false)
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusType status;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    /*
    =============================================
    Relationships
    =============================================
    */
    //Cart to CartItem One-to-Many Relationship
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>();

    //CustomerID to Cart Many-to-One Relationship
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /*
    =============================================
    Methods
    =============================================
    */

    /**
      add: method to add an CartItem object to the Cart object
      @param item (CartItem)
     */
    public void add(CartItem item){
        this.cartItem.add(item);
    }

    /*
    =============================================
    Getters and setters
    =============================================
    */
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }



}
