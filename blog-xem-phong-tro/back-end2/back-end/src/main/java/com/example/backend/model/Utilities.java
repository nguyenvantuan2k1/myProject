package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "utilities")
public class Utilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean wifi,aircondition,fridge,washingmachine,kitchen;
    @OneToMany(mappedBy ="utilities",cascade = CascadeType.ALL)
    private Set<Rooms> rooms;

    public Utilities(int id, boolean wifi, boolean aircondition, boolean fridge, boolean washingmachine, boolean kitchen, Set<Rooms> rooms) {
        this.id = id;
        this.wifi = wifi;
        this.aircondition = aircondition;
        this.fridge = fridge;
        this.washingmachine = washingmachine;
        this.kitchen = kitchen;
        this.rooms = rooms;
    }
}
