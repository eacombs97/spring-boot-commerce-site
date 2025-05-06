package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**Excursion.java Class:
 * @author Emily Combs
 **/
@Entity
@Table(name = "excursions")
@Getter
@Setter

public class Excursion {
    /*
    ==================================
    Fields with JPA Mappings
    ==================================
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false)
    private Long id;

    @Column(name = "excursion_title")
    @JsonProperty("excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    /*
    =====================================
    Relationships
    =====================================
    */
    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;


    //Excursion to Cart Items One-To-Many Relationship
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();

}
