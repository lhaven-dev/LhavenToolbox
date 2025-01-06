package fr.lhaven.lhaventoolbox;

import fr.lhaven.lhaventoolbox.block.CustomBlock;
import fr.lhaven.lhaventoolbox.item.ModItemGroups;
import fr.lhaven.lhaventoolbox.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lhaventoolbox implements ModInitializer {
    public static final String MOD_ID = "lhaventoolbox";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        CustomBlock.registerModBlocks();
    }
}
