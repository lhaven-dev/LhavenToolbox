package fr.lhaven.lhaventoolbox.client.gui;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.client.gui.summary.widgets.ModelWidget;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.RenderablePokemon;
import com.cobblemon.mod.common.pokemon.Species;
import fr.lhaven.lhaventoolbox.client.gui.widgets.Tab;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.block.entity.BeaconBlockEntity.playSound;
import static net.minecraft.client.gui.screen.ingame.InventoryScreen.drawEntity;

public class OnlyBackgroundtest extends Screen {
    private static final int BASE_WIDTH = 349 ;
    private static final int BASE_HEIGHT = 205 ;
    private static final int PORTRAIT_SIZE = 58;
    final Identifier MAIN_BACKGROUND = new Identifier("lhaventoolbox","background.png");

    final Identifier PORTRAIT_BACKGROUND = new Identifier("lhaventoolbox","portrait.png");

    private String usedTab ="";
    private Tab infoTabButton;
    private Tab battleTabButton;
    private Tab evolveTabButton;


    public OnlyBackgroundtest() {
        super(Text.of("Custom Screen"));
    }

    @Override
    protected void init() {
        int x = (width - BASE_WIDTH) / 2 ;
        int y = (height - BASE_HEIGHT) / 2 ;

        infoTabButton = new Tab(x, y, x + 114, y + 178, "test1", button -> {
            infoTabButton.setActive(true);
            usedTab ="test1";
            defaultTabClickEvent();
        });

        battleTabButton = new Tab(x, y, x + 151, y + 178, "test2", button -> {
            battleTabButton.setActive(true);
            usedTab ="test2";
            defaultTabClickEvent();
        });

        evolveTabButton = new Tab(x, y, x + 188, y + 178, "test3", button -> {
            evolveTabButton.setActive(true);
            usedTab ="test3";
            defaultTabClickEvent();
        });
        addDrawableChild(infoTabButton);
        addDrawableChild(battleTabButton);
        addDrawableChild(evolveTabButton);
        super.init();


    }

    // GESTION EVENT BOUTON TAB
    private void defaultTabClickEvent() {
        battleTabButton.setActive(false);
        infoTabButton.setActive(false);
        evolveTabButton.setActive(false);

        if(usedTab.equals("test1")){
            infoTabButton.setActive(true);
        }else if(usedTab.equals("test2")){
            battleTabButton.setActive(true);
        }else if(usedTab.equals("test3")){
            evolveTabButton.setActive(true);
        }
        // On joue un son pour indiquer que le bouton a été cliqué
        playSound(MinecraftClient.getInstance().player.getWorld(),MinecraftClient.getInstance().player.getBlockPos(), CobblemonSounds.POKE_BALL_CAPTURE_SUCCEEDED);
        // On affiche un message dans le chat
        MinecraftClient.getInstance().player.sendMessage(Text.of("Tab clicked: " + usedTab));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Dessiner le fond (un fond noir pour cet exemple)
        // Spécifie la taille de l'interface


        int x = (width - BASE_WIDTH) / 2 ;
        int y = (height - BASE_HEIGHT) / 2 ;

        // Dessiner le fond Principal
        context.drawTexture(MAIN_BACKGROUND, x, y, 0, 0, BASE_WIDTH, BASE_HEIGHT, BASE_WIDTH, BASE_HEIGHT);


        // Dessiner le portrait (element en fond du pokemon)
        int portraitX = x + 13;
        int portraitY = y + 41;
        context.drawTexture(PORTRAIT_BACKGROUND, portraitX, portraitY, 0, 0, PORTRAIT_SIZE, PORTRAIT_SIZE, PORTRAIT_SIZE, PORTRAIT_SIZE);


        // Création d'un Pokémon
        Pokemon pokemon = new Pokemon();
        pokemon.setSpecies(PokemonSpecies.INSTANCE.getByPokedexNumber(1,"cobblemon"));
        RenderablePokemon renderable = pokemon.asRenderablePokemon();

        // Affiche le modèle du Pokémon
        ModelWidget PokemonModel = new ModelWidget(portraitX , portraitY , 66, 66,renderable ,2, 45, 0);
        PokemonModel.render(context,mouseX, mouseY, delta);

        // Affiche le modèle du joueur
        drawEntity(context, portraitX+10, portraitY+60, 30, mouseX-180, mouseY-180, this.client.player);

        // Affiche les coordonnées de la souris
        TextRenderer textRenderer = client.textRenderer;
        context.drawText(
                textRenderer,
                Text.literal("Mouse: (" + mouseX + ", " + mouseY + ")"),
                10,
                10,
                0xFFFFFF,
                false // Pas d'ombre
        );

        // Appel de la méthode render() pour dessiner les éléments de l'écran (si tu en avais)
        super.render(context, mouseX, mouseY, delta);


    }

    @Override
    public boolean shouldPause() {
        // On ne met pas en pause le jeu pour afficher cet écran
        return false;
    }


}
