package com.greta.packer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PackerApplicationTests {
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void getItemsWithDefaultParameters_responseExists() {
        var result = restTemplate.getForObject("http://localhost:8080/packer/?lengthInKm=10&season=SPRING", PackerController.PackerResponse.class);

        assertEquals(3, result.items().size());
    }
}
