package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private byte status;
    private int rate;
    @ManyToOne
    @JoinColumn(name = "utilities_id")
    private Utilities utilities;
    @OneToMany(mappedBy = "rooms",cascade = CascadeType.ALL)
    private Set<Bookdetail> bookdetail;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    public Rooms(int id, byte status, int rate, Utilities utilities, Set<Bookdetail> bookdetail) {
        this.id = id;
        this.status = status;
        this.rate = rate;
        this.utilities = utilities;
        this.bookdetail = bookdetail;
    }
}
