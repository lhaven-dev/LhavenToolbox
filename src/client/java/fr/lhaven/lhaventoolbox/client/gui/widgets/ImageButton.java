package fr.lhaven.lhaventoolbox.client.gui.widgets;

import com.cobblemon.mod.common.CobblemonSounds;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ImageButton extends ButtonWidget {

    private final Identifier texture;

    public ImageButton(Identifier texture, int width, int height, int pX, int pY, PressAction onPress) {
        super(pX, pY, width, height, Text.of("ImageButton"), onPress, DEFAULT_NARRATION_SUPPLIER);
        this.texture = texture;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        if (context == null) return;

        context.drawTexture(
                texture,                   // Texture à dessiner
                this.getX(), this.getY(),  // Position X et Y
                0, 0,                      // Coordonnées d'origine dans la texture
                this.width, this.height,   // Dimensions du bouton
                this.width, this.height    // Dimensions totales de la texture
        );

    }

    @Override
    public void playDownSound(SoundManager soundManager) {
        soundManager.play(PositionedSoundInstance.master(CobblemonSounds.GUI_CLICK, 1.0f));
    }
}