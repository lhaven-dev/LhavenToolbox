package fr.lhaven.lhaventoolbox;

import fr.lhaven.lhaventoolbox.item.ModItemGroup;
import fr.lhaven.lhaventoolbox.item.itemManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lhaventoolbox implements ModInitializer {

    public static final String MODID = "lhaventoolbox";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        ModItemGroup.RegisterItemGroup();
        itemManager.RegisterModItems();
    }
}
