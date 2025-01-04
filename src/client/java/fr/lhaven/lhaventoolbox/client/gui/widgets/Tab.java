package fr.lhaven.lhaventoolbox.client.gui.widgets;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Tab extends ButtonWidget {

    public static final int TAB_WIDTH = 110;
    public static final int TAB_HEIGHT = 11;
    public static final int BUTTON_WIDTH = 36;
    public static final int BUTTON_HEIGHT = 11;

    final Identifier TAB_BACKGROUND = new Identifier("lhaventoolbox","highlighted_tab.png");


    private boolean isActive = false;
    private final int xOffset;
    private final int yOffset;

    private  int x ;
    private  int y ;
    private final String label;

    public Tab(int xOffset, int yOffset, int pX, int pY, String label, PressAction onPress) {
        super(pX, pY, BUTTON_WIDTH, BUTTON_HEIGHT, Text.of(label), onPress, DEFAULT_NARRATION_SUPPLIER);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.label = label;
        x = pX;
        y = pY;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float partialTicks) {
        // Dessiner la mise en surbrillance si l'onglet est actif
        if (isActive) {
            int widthLimit = x + width;
            int heightLimit = y + height;
            context.enableScissor(x, y, widthLimit, heightLimit);
            context.drawTexture(TAB_BACKGROUND, xOffset + 114, yOffset + 178, 0, 0, TAB_WIDTH, TAB_HEIGHT, TAB_WIDTH, TAB_HEIGHT);
            context.disableScissor();


        }
    }

    public void setActive(boolean state) {
        this.isActive = state;
    }
}
