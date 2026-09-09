package com.optimum.ib;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @org.junit.jupiter.api.Test
    void getItems() {
        Shop shop = new Shop(null);
        assertNull(shop.getItems());
        shop.addItem(new Item(0,"item1"));
        shop.addItem(new Item(1,"item2"));
        assertNotNull(shop.getItems());
        assertEquals(2, shop.getItems().size());
        Assertions.assertEquals("item1", shop.getItems().get(0).getName());
        Assertions.assertEquals("item2", shop.getItems().get(1).getName());
    }

    @org.junit.jupiter.api.Test
    void setItems() {
    }

    @org.junit.jupiter.api.Test
    void addItem() {
    }
}