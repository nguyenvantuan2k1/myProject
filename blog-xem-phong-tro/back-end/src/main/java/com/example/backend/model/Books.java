package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgroom;
    private String fullname;
    private String email;
    private boolean status;
    private int numberOfUsers;
    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    public Books(int id, String imgroom, String fullname, String email, boolean status,int numberOfUsers, Account account) {
        this.id = id;
        this.imgroom = imgroom;
        this.fullname = fullname;
        this.email = email;
        this.status = status;
        this.numberOfUsers=numberOfUsers;
        this.account = account;
    }
}
