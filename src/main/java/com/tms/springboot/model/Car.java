package com.tms.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @Enumerated(EnumType.STRING)
    private CARMODEL model;
    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;
    private boolean availability;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
    @Version
    private int version;

    public Car(CARMODEL model, Date dateOfIssue, boolean availability) {
        this.model = model;
        this.dateOfIssue = dateOfIssue;
        this.availability = availability;
    }
}
