package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void Sulfuras_Quality_Never_Changes() {
        // given
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void Sulfuras_SellIn_Value_Never_Changes() {
        // given
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(2, gildedRose.items[0].sellIn);
    }

    @Test
    public void Backstage_Passes_Quality_Drops_To_Zero_After_Concert() {
        // given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void Item_Quality_Is_Never_More_Than_50() {
        // given
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(50, gildedRose.items[0].quality);
    }
}
