package ru.metroafter.item;

import net.minecraft.world.item.Item;

public class FilterItem extends Item {
    public FilterItem(Properties properties) {
        // Filters have durability, so they must remain unstackable.
        super(properties);
    }
}
