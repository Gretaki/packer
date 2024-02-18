package com.greta.packer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private double amount;
    private double maxAmount;
    private String unit;
    private boolean scalableByDistance;
    private boolean scalableByNight;
    private String seasons;

    public Item() {
    }

    public Item(Long id, String name, double amount, double maxAmount, String unit, boolean scalableByDistance, boolean scalableByNight, String seasons) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.maxAmount = maxAmount;
        this.unit = unit;
        this.scalableByDistance = scalableByDistance;
        this.scalableByNight = scalableByNight;
        this.seasons = seasons;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public double amount() {
        return amount;
    }

    public double maxAmount() {
        return maxAmount;
    }

    public String unit() {
        return unit;
    }

    public boolean scalableByDistance() {
        return scalableByDistance;
    }

    public boolean scalableByNight() {
        return scalableByNight;
    }

    public List<YearSeason> seasons() {
        if (seasons == null) {
            return List.of();
        }

        return Arrays.stream(seasons.split(","))
                .map(YearSeason::valueOf)
                .toList();
    }
}
