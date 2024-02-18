package com.greta.packer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/packer")
@EnableWebMvc
public class PackerController {

    @Autowired
    private ItemCalculator itemCalculator;

    @GetMapping({"/", ""})
    public PackerResponse getItems(
            @RequestParam int lengthInKm,
            @RequestParam YearSeason season,
            @RequestParam(required = false, defaultValue = "0") int nights
    ) {
        List<ItemCalculator.PackedItem> items = itemCalculator.calculate(lengthInKm, season, nights);

        return new PackerResponse(items);
    }

    public record PackerResponse(List<ItemCalculator.PackedItem> items) {
    }
}

