package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"Aged Brie",
        "Backstage passes to a TAFKAL80ETC concert"})
    public void Item_Quality_Is_Never_More_Than_50(String itemName) {
        // given
        Item[] items = new Item[]{new Item(itemName, 3, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(50, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"+5 Dexterity Vest",
        "Elixir of the Mongoose"})
    public void Item_Quality_Is_Never_Negative(String itemName) {
        // given
        Item[] items = new Item[]{new Item(itemName, 1, 0)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(0, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"+5 Dexterity Vest",
        "Elixir of the Mongoose"})
    public void Item_Quality_Decreases_By_One_Until_Sell_By_Date(String itemName) {
        // given
        Item[] items = new Item[]{new Item(itemName, 3, 5)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        //then
        assertEquals(4, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"+5 Dexterity Vest",
        "Elixir of the Mongoose"})
    public void Item_Quality_Decreases_By_Two_After_Sell_By_Date_Is_Passed(String itemName) {
        // given
        Item[] items = new Item[]{new Item(itemName, -3, 5)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        //then
        assertEquals(3, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"2, -5, 0",
        "2, 3, 1"})
    public void Aged_Brie_Quality_Increases_By_One_Until_And_By_Two_After_Sell_By_Date_Is_Passed
        (int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[]{new Item("Aged Brie", sellIn, actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource({"31, 15, 30",
        "5, 10, 3",
        "12, 5, 9"})
    public void Backstage_Passes_Quality_Increases_By_One_Two_Or_Three_Depending_On_Sell_By_Date
        (int expectedQuality, int sellIn, int actualQuality) {
        // given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, actualQuality)};
        GildedRose gildedRose = new GildedRose(items);

        // when
        gildedRose.updateQuality();

        // then
        assertEquals(expectedQuality, gildedRose.items[0].quality);
    }
}
