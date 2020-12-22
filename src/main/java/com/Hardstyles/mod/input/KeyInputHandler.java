package com.Hardstyles.mod.input;

import com.Hardstyles.mod.ForgeMod;
import com.Hardstyles.mod.module.mods.ToggleSprint;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputHandler {
    boolean press = false;

    @SubscribeEvent
    public void onKeyInput(TickEvent.ClientTickEvent event) {
        if (ForgeMod.sprint.isKeyDown() && ForgeMod.sprint.isPressed()) {
            ToggleSprint.enabled = !ToggleSprint.enabled;
            if(ToggleSprint.enabled == false){
                new ToggleSprint().onDisable();

            }
        }

    }
}
