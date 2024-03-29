package com.example.projetjsfjpa.Model;

import jakarta.persistence.*;
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double budget;

    @OneToOne(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Employee employe;

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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Employee getEmploye() {
        return employe;
    }

    public void setEmploye(Employee employe) {
        this.employe = employe;
    }
}

