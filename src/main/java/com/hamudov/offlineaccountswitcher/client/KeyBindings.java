package com.hamudov.offlineaccountswitcher.client;

import com.hamudov.offlineaccountswitcher.OfflineAccountSwitcher;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = OfflineAccountSwitcher.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBindings {
    public static final String CATEGORY = "key.categories." + OfflineAccountSwitcher.MOD_ID;
    
    public static final KeyMapping OPEN_ACCOUNT_SWITCHER = new KeyMapping(
        "key." + OfflineAccountSwitcher.MOD_ID + ".open_account_switcher",
        KeyConflictContext.IN_GAME,
        GLFW.GLFW_KEY_RIGHT_ALT,
        CATEGORY
    );
}
