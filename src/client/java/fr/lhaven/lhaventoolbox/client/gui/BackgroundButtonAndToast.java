package fr.lhaven.lhaventoolbox.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.Text;

public class BackgroundButtonAndToast extends Screen {

    public BackgroundButtonAndToast() {
        super(Text.of("Custom Screen"));
    }

    @Override
    protected void init() {
        super.init();

        // Création du bouton
        ButtonWidget button = ButtonWidget.builder(
                        Text.of("Cliquez-moi"),  // Texte affiché sur le bouton
                        buttonWidget -> onButtonClick()  // Action à effectuer lorsqu'on clique
                ).dimensions(this.width / 2 - 50, this.height / 2 - 10, 100, 20) // Position et taille du bouton
                .build();

        // Ajouter le bouton à l'écran
        this.addDrawableChild(button);
    }
    private void onButtonClick() {
        // Action exécutée lors du clic sur le bouton
        System.out.println("Bouton cliqué !");

        // Affichage d'un toast
        ToastManager toastManager = this.client.getToastManager();
        SystemToast toast = new SystemToast(
                SystemToast.Type.NARRATOR_TOGGLE,  // Utilise un type existant
                Text.of("Notification"),
                Text.of("Bouton cliqué !")
        );
        toastManager.add(toast);
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
