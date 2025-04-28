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
    /*
    =======================================
    Fields with JPA Mappings
    =======================================
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "country_id", nullable = false)
    private Long country_id;
    /*
    =============================================
    Relationships
    =============================================
    */
    //Countries to Division Many-to-One Relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    //Division to Customers One-To-Many Relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    /*
    ============================================
    Setter and Getters
    ============================================
    */
    /** Setter method to retrieve a Country object
     *
     * @param country
     */
    public void setCountry(Country country){
        this.country_id = country.getId();
        this.country = country;
    }

}
