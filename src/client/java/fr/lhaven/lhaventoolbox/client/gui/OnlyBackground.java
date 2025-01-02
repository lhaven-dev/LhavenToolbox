package fr.lhaven.lhaventoolbox.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class OnlyBackground extends Screen {
    public OnlyBackground() {
        super(Text.of("Custom Screen"));
    }

    @Override
    protected void init() {
        super.init();
        // On peut ajouter des boutons ici si besoin, mais pour l'instant, on garde le fond vide !
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Dessiner le fond (un fond noir pour cet exemple)
        this.renderBackground(context);
        // Dessiner un fond simple
        RenderSystem.setShaderColor(0.1f, 0.1f, 0.1f, 1.0f);  // Un fond sombre
        context.fill(0, 0, this.width, this.height, 0x80000000); // Couleur noire avec transparence

        // Appel de la méthode render() pour dessiner les éléments de l'écran (si tu en avais)
        super.render(context, mouseX, mouseY, delta);
    }
}
