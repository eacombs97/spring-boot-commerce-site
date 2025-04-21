package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursion_cartitem")
@Getter
@Setter

/** CartItem.java Class:
 * @author Emily Combs
 */
public class CartItem {
    //=======================================
    //Fields with JPA Mappings
    //=======================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //=============================================
    //Relationships
    //=============================================
    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;



}
