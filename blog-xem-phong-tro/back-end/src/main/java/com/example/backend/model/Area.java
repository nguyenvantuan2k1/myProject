package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String imgroom;
    @OneToMany(mappedBy ="area",cascade = CascadeType.ALL)
    private Set<Post> post;

    public Area(int id, String name,String imgroom) {
        this.id = id;
        this.name = name;
        this.imgroom = imgroom;
    }
}

