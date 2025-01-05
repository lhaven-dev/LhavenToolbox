package fr.lhaven.lhaventoolbox.item;

import fr.lhaven.lhaventoolbox.Lhaventoolbox;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    // Create a new item group
    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(Lhaventoolbox.MODID, "item_group"),
            FabricItemGroup.builder().displayName(Text.of("item_group")).icon(() -> new ItemStack(Items.DIAMOND)).entries((displayContext, entries) -> {
                // Add items to the item group
                entries.add(itemManager.POKE_KEY);
            }).build());

public static void RegisterItemGroup() {
    // Register item group here
}
}
