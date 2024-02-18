package com.greta.packer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ItemCalculatorTest {
    private ItemRepository repository;
    private ItemCalculator itemCalculator;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(ItemRepository.class);
        itemCalculator = new ItemCalculator(repository);
    }

    @Test
    void calculateScalesItemByDistance() {
        Mockito.when(repository.findAll()).thenReturn(List.of(
                new Item(1L, "Water", 0.1, 3, "litres", true, false, null)
        ));
        var result = itemCalculator.calculate(11, YearSeason.SPRING, 0);

        assertEquals(1.1, result.get(0).amount());
        assertEquals("Water", result.get(0).name());
        assertEquals("litres", result.get(0).unit());
    }

    // TODO: write more tests
}
