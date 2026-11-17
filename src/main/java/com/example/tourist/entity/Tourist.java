
package com.example.tourist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tourist {

    @Id
    private Long id;

    private String name;
    private String destination;
    private String contact;

    public Tourist() {
    }

    public Tourist(Long id, String name,
                   String destination, String contact) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.contact = contact;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
