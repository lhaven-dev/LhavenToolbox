package fr.lhaven.lhaventoolbox.client;

import fr.lhaven.lhaventoolbox.client.gui.OnlyBackground;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class LhaventoolboxClient implements ClientModInitializer {
    private static final KeyBinding OPEN_SCREEN_KEY = new KeyBinding(
            "key.myscreen.open",  // Le nom de la touche dans les options
            GLFW.GLFW_KEY_P,      // La touche sur laquelle on veut que l'écran s'ouvre
            "category.myscreen"   // La catégorie sous laquelle il sera dans les options
    );
    @Override
    public void onInitializeClient() {
        // Enregistrement de la touche
        KeyBindingHelper.registerKeyBinding(OPEN_SCREEN_KEY);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Appel de la méthode onKeyPress() à chaque tick
            onKeyPress();
        });
    }

    public static void onKeyPress() {
        // Si la touche est pressée, on ouvre l'écran personnalisé
        if (OPEN_SCREEN_KEY.isPressed()) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Key pressed"));
            // Ouvrir l'écran personnalisé
            MinecraftClient.getInstance().setScreen(new OnlyBackground());
        }
    }
}
