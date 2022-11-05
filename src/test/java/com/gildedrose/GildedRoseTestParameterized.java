package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTestParameterized {

    @ParameterizedTest
    @CsvSource({"0, -3, 1",
                "0, 1, 1",
                "0, 3, 0",
                "0, 0, 0"})
    public void Item_Quality_Is_Never_Negative(int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", sellIn, actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"0, -5, 0",
                "4, 3, 5",
                "0, 0, 1",
                "1, -1, 3"})
    public void Item_Quality_Decreases(int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[] {new Item("Elixir of the Mongoose", sellIn,  actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"2, -5, 0",
                "2, 3, 1",
                "3, 0, 1"})
    public void Aged_Brie_Quality_Increases(int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[] {new Item("Aged Brie", sellIn,  actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"31, 15, 30",
                "1, 11, 0",
                "5, 10, 3",
                "17, 7, 15",
                "12, 5, 9",
                "8, 1, 5"})
    public void Backstage_Passes_Quality_Increases(int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", sellIn,  actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }
}
