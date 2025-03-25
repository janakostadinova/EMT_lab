package com.example.labemt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Host host;

    private int numRooms;

    private boolean booked = false;

    public Booking() {
    }

    public Booking(String name, Category category, Host host, int numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
