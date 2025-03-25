package com.example.labemt.model.dto;

import com.example.labemt.model.Category;
import com.example.labemt.model.Host;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class BookingDto {
    private String name;

    private Category category;

    private Long hostId;

    private int numRooms;

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

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }
}
