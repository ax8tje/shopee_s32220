package pl.pjatk.shopee_s32220;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StorageTest {

    @Test
    public void testGetProducts_Exists(){
        Storage storage = new Storage();

        Product product = storage.getProducts("milk");

        assertNotNull(product);
        assertEquals("milk", product.getName());
    }

    @Test
    public void testGetProducts_NotExists(){
        Storage storage = new Storage();

        Product product = storage.getProducts("czosnek");

        assertNull(product);
    }

    @Test
    public void testGetProducts_WhatIfIPutItInAllCaps(){
        Storage storage = new Storage();
        Product product = storage.getProducts("MILK");
        assertNotNull(product);
        assertEquals("milk", product.getName());
        // ;3
    }
}
