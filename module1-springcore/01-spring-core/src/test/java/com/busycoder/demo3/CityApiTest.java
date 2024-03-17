package com.busycoder.demo3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CityApiTest {

    private CityApi cityApi;

    @BeforeEach
    void setUp() {
        cityApi=new CityApi();
    }
    @Test
    void getCity() {
        Assertions.assertTimeout(Duration.ofMillis(2000),()->cityApi.getCity(45));
    }
    @AfterEach
    void tearDown() {
        cityApi=null;
    }
}