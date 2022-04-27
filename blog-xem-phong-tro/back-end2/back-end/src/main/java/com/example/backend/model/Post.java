package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgroom;
    private String description;
    private int quantity;
    private double price;
    private boolean active;
    private String datepost;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Rooms> rooms;
    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    public Post( String imgroom, String description, int quantity, double price,boolean active, String datepost, Set<Rooms> rooms, Account account) {
        this.imgroom = imgroom;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.active=active;
        this.datepost = datepost;
        this.rooms = rooms;
        this.account = account;
    }

    public Post(String imgroom, String description, int quantity, double price,boolean active) {
        this.imgroom = imgroom;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.active=active;
    }
}
