package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter

/**Division.java Class:
 * @author Emily Combs
 */
public class Division {
    //=======================================
    //Fields with JPA Mappings
    //=======================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //=============================================
    //Relationships
    //=============================================
    /*
     * Country Many-to-One Relationship
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    /*
     * Customer One-To-Many Relationship
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "country_id")
    private long country_id;

    //============================================
    //Setter and Getters
    //============================================
    /** Setter method to retrieve a Country object
     *
     * @param country
     */
    public void setCountry(Country country){
        setCountry_id((country.getId()));
        this.country = country;
    }
}
