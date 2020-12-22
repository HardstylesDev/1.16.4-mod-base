package com.Hardstyles.mod.gui;

import com.Hardstyles.mod.ForgeMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;


public class ModGui extends Screen {

    private static final int WIDTH = 179;
    private static final int HEIGHT = 151;

    // private ResourceLocation GUI = new ResourceLocation(MyTutorial.MODID, "textures/gui/spawner_gui.png");


    public ModGui() {
        super(new TranslationTextComponent("screen.mytutorial.spawn"));
    }

    @Override
    protected void init() {
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;

        addButton(new Button(relX + 10, relY + 10, 160, 20, new StringTextComponent("Example"), button -> click(1)));

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void click(int id) {
        switch (id) {
            case 1:
                //Example    Module module = ForgeMod.moduleManager.getModule("Coords HUD");
                //Example    ForgeMod.moduleManager.enableModule(module);
            default:
                minecraft.displayGuiScreen(null);

        }
        ForgeMod.moduleManager.getEnabledModules().forEach(module -> ForgeMod.send(module.getName()));

    }
    //   Networking.sendToServer(new PacketSpawn(new ResourceLocation(id), minecraft.player.dimension, minecraft.player.getPosition()));

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        super.render(matrixStack, mouseX, mouseY, partialTicks);

    }


    public static void open() {
        Minecraft.getInstance().displayGuiScreen(new ModGui());
    }

    public String status(boolean b) {
        if (b)
            return TextFormatting.DARK_GREEN + "Enabled";
        else
            return TextFormatting.RED + "Disabled";
    }
}