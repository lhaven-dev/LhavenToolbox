package fr.lhaven.lhaventoolbox.item;

import fr.lhaven.lhaventoolbox.Lhaventoolbox;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class itemManager {
public static final Item POKE_KEY = registerItem("poke_key", new Item(new FabricItemSettings()));


private static void addItemsToIngredientTab(FabricItemGroupEntries entries)
{
    entries.add(POKE_KEY);
}

private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Lhaventoolbox.MODID, name), item);
    } 

    public static void RegisterModItems() {
        // Register items here
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemManager::addItemsToIngredientTab);
    }
}
