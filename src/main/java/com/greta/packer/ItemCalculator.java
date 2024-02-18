package com.greta.packer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemCalculator {

    private final ItemRepository itemRepository;

    public ItemCalculator(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<PackedItem> calculate(int lengthInKm, YearSeason season, int nights) {
        var allItems = itemRepository.findAll();

        return allItems.stream()
                .filter(item -> isInSeason(season, item))
                .map(item -> {
                    double amount = Math.min(item.maxAmount(), calculateAmount(lengthInKm, nights, item));
                    return new PackedItem(
                            item.id(),
                            item.name(),
                            Math.round(amount * 100.0) / 100.0,
                            item.unit()
                    );
                })
                .filter(item -> item.amount != 0)
                .toList();
    }

    private static double calculateAmount(int lengthInKm, int nights, Item item) {
        if (item.scalableByDistance()) {
            return lengthInKm * item.amount();
        } else if (item.scalableByNight()) {
            return nights * item.amount();
        } else {
            return item.amount();
        }
    }

    private static boolean isInSeason(YearSeason season, Item item) {
        return item.seasons().isEmpty() || item.seasons().contains(season);
    }

    public record PackedItem(Long id, String name, double amount, String unit) {
    }
}
