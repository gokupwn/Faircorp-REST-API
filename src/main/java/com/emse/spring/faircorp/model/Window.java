package com.emse.spring.faircorp.model;

import javax.persistence.*;

// (1)
@Entity
// (2)
@Table(name="RWINDOW")
public class Window {
    // (3)
    @Id
    @GeneratedValue
    private Long id;

    // (4)
    @Column(nullable=false)
    private String name;

    // (5)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    @ManyToOne
    public Room room;

    public Window() {
    }

    public Window(String name, WindowStatus windowStatus, Room room) {
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    @Override
    public String toString() {
        return "Window{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", windowStatus=" + windowStatus +
                '}';
    }
}