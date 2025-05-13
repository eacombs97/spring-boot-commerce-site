package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**Country.java Class:
 * @author Emily Combs
 */
@Entity
@Table(name = "countries")
@Setter
@Getter

public class Country {
    /*
    =======================================
    Fields with JPA Mappings
    =======================================
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    /*
    =============================================
    Relationships
    =============================================
    */
    //Cart to CartItem One-to-Many Relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions = new HashSet<>();

}
