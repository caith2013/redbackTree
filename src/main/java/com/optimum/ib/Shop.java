package com.optimum.ib;

import java.util.ArrayList;
import java.util.List;

public class Shop
{
    private List<Item> items;
    public Shop(List<Item> items)
    {
        this.items = items;
    }
    public List<Item> getItems()
    {
        return items;
    }
    public void setItems(List<Item> items)
    {
        this.items = items;
    }
    public void addItem(Item item)
    {
        if  (this.items == null) this.items = new ArrayList<Item>();
        this.items.add(item);
    }
}
