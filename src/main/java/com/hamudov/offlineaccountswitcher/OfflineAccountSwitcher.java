package com.hamudov.offlineaccountswitcher;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("offlineaccountswitcher")
public class OfflineAccountSwitcher {
    public static final String MOD_ID = "offlineaccountswitcher";
    public static final String MOD_NAME = "Offline Account Switcher";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public OfflineAccountSwitcher(ModContainer modContainer) {
        IEventBus modEventBus = modContainer.getEventBus();
        modEventBus.addListener(this::onClientSetup);
        
        LOGGER.info("Offline Account Switcher initializing...");
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Offline Account Switcher client setup complete!");
    }
}
