package com.hamudov.offlineaccountswitcher.client;

import com.hamudov.offlineaccountswitcher.OfflineAccountSwitcher;
import com.hamudov.offlineaccountswitcher.client.screen.AccountSwitcherScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(modid = OfflineAccountSwitcher.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        
        if (minecraft.screen == null && minecraft.player != null) {
            if (KeyBindings.OPEN_ACCOUNT_SWITCHER.consumeClick()) {
                minecraft.setScreen(new AccountSwitcherScreen());
            }
        }
    }
}
