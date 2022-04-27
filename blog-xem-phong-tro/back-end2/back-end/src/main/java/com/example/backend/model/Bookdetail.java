package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bookdetail")
public class Bookdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private double price;
    private String fullname;
    private String phoneNumber;
    private boolean status;
    private String comments;

    @ManyToOne()
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;
    @ManyToOne()
    @JoinColumn(name = "books_id")
    private Books books;
    public Bookdetail(int id, String address, double price, String fullname, String phoneNumber, boolean status, String comments, Rooms rooms) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.comments = comments;
        this.rooms = rooms;
    }
}
