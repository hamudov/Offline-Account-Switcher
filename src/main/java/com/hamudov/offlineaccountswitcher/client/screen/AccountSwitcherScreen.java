package com.hamudov.offlineaccountswitcher.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class AccountSwitcherScreen extends Screen {
    private EditBox nicknameInput;
    private List<String> recentNicknames = new ArrayList<>();
    private static final int MAX_RECENT = 10;

    public AccountSwitcherScreen() {
        super(Component.literal("Account Switcher"));
        loadRecentNicknames();
    }

    @Override
    protected void init() {
        this.clearWidgets();
        
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int inputWidth = 200;
        int inputX = centerX - inputWidth / 2;

        // Input field for nickname
        this.nicknameInput = new EditBox(this.font, inputX, centerY - 30, inputWidth, 20, Component.literal("Nickname"));
        this.nicknameInput.setMaxLength(16);
        this.nicknameInput.setFocus(true);
        
        if (this.minecraft != null && this.minecraft.player != null) {
            this.nicknameInput.setValue(this.minecraft.player.getName().getString());
        }
        
        this.addRenderableWidget(this.nicknameInput);

        // Apply button
        this.addRenderableWidget(Button.builder(Component.literal("Apply"), (btn) -> applyNickname())
            .pos(centerX - 55, centerY + 10)
            .size(50, 20)
            .build());

        // Cancel button
        this.addRenderableWidget(Button.builder(Component.literal("Cancel"), (btn) -> this.onClose())
            .pos(centerX + 5, centerY + 10)
            .size(50, 20)
            .build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        
        guiGraphics.drawCenteredString(this.font, "Change Nickname", centerX, centerY - 80, 0xFFFFFF);
        
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        
        if (this.nicknameInput != null) {
            this.nicknameInput.render(guiGraphics, mouseX, mouseY, partialTick);
        }

        if (!recentNicknames.isEmpty()) {
            guiGraphics.drawString(this.font, "Recent:", centerX - 100, centerY + 50, 0xAAAAAA);
            for (int i = 0; i < Math.min(5, recentNicknames.size()); i++) {
                guiGraphics.drawString(this.font, 
                    (i + 1) + ". " + recentNicknames.get(i), centerX - 100, centerY + 65 + (i * 12), 0x888888);
            }
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC key
            this.onClose();
            return true;
        } else if (keyCode == 257) { // ENTER key
            applyNickname();
            return true;
        }
        
        if (this.nicknameInput != null) {
            return this.nicknameInput.keyPressed(keyCode, scanCode, modifiers) || super.keyPressed(keyCode, scanCode, modifiers);
        }
        
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void applyNickname() {
        if (this.nicknameInput != null && this.minecraft != null && this.minecraft.player != null) {
            String newNickname = this.nicknameInput.getValue().trim();
            
            if (!newNickname.isEmpty() && newNickname.length() <= 16) {
                try {
                    NicknameManager.setPlayerNickname(this.minecraft.player, newNickname);
                    addRecentNickname(newNickname);
                    this.minecraft.gui.getChat().addMessage(Component.literal("§aNickname changed to: §f" + newNickname));
                    this.onClose();
                } catch (Exception e) {
                    this.minecraft.gui.getChat().addMessage(Component.literal("§cFailed to change nickname: " + e.getMessage()));
                }
            } else {
                this.minecraft.gui.getChat().addMessage(Component.literal("§cInvalid nickname! (1-16 characters)"));
            }
        }
    }

    private void addRecentNickname(String nickname) {
        if (!recentNicknames.contains(nickname)) {
            recentNicknames.add(0, nickname);
            if (recentNicknames.size() > MAX_RECENT) {
                recentNicknames.remove(recentNicknames.size() - 1);
            }
        }
    }

    private void loadRecentNicknames() {
        recentNicknames = new ArrayList<>();
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(null);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
