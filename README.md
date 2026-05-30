# Offline Account Switcher

A Minecraft Forge mod for version 1.21.1 that allows players to change their nickname in-game on offline servers (like TLauncher) without restarting the game.

## 🎮 Features

- ✨ **In-Game Nickname Changing** - Change your nickname without restarting Minecraft
- ⌨️ **Customizable Keybindings** - Bind the mod to your preferred keys (default: Right Alt)
- 📝 **Simple UI** - Clean and intuitive menu interface
- 💾 **Recent Nicknames** - Quick access to previously used nicknames
- 🔒 **Offline Server Support** - Perfect for TLauncher and other offline servers

## 📥 Installation

1. Download Minecraft Forge for version 1.21.1
2. Install Forge to your Minecraft launcher
3. Download the mod JAR file
4. Place it in your `.minecraft/mods` folder
5. Launch the game with the Forge profile

## 🎯 Usage

### Opening the Account Switcher Menu
- Press **Right Alt** (by default) to open the nickname change menu
- Or bind a different key in Minecraft Controls settings

### Changing Your Nickname
1. Open the Account Switcher menu (Right Alt)
2. Type your desired nickname (1-16 characters)
3. Press **Enter** to apply or click the **Apply** button
4. Your nickname will change immediately
5. Press **Esc** or click **Cancel** to close without changes

## ⌨️ Keybindings

Default keybindings can be customized in-game:
- **Minecraft Controls** → Search for "Account Switcher" → Set your preferred key

Available keys:
- Mouse buttons (Side buttons recommended)
- Keyboard keys (Right Alt, Right Ctrl, etc.)
- Any other key you prefer

## 🖥️ System Requirements

- **Minecraft**: 1.21.1+
- **Forge**: 52.0.0+
- **Java**: 21+
- **RAM**: Minimal impact (less than 5MB)

## 🔨 Building from Source

### Prerequisites
- Java Development Kit (JDK) 21+
- Git

### Building
```bash
git clone https://github.com/hamudov/Offline-Account-Switcher.git
cd Offline-Account-Switcher
./gradlew build
```

The compiled mod will be in `build/libs/offlineaccountswitcher-1.0.0.jar`

## ✅ Compatibility

- ✅ Minecraft 1.21.1+
- ✅ Forge 52.0.0+
- ✅ TLauncher
- ✅ Offline Servers
- ⚠️ Microsoft Accounts: Limited (designed for offline mode)
- ⚠️ Online Servers: Not recommended (may cause issues)

## 🐛 Troubleshooting

### Keybinding not working?
- Check your Minecraft Controls settings
- Make sure no other mod is conflicting with your keybinding
- Try rebinding to a different key

### Nickname not changing?
- Make sure you're on an offline server
- Ensure your nickname is 1-16 characters
- Check if any other mod is conflicting

### Crash on startup?
- Make sure you're using Forge 52.0.0 or later
- Verify Java 21+ is installed
- Remove conflicting mods one by one

## 👏 Credits

Inspired by [In-Game Account Switcher](https://github.com/The-Fireplace-Minecraft-Mods/In-Game-Account-Switcher) by The_Fireplace and VidTu

## 📜 License

This mod is licensed under the GNU Lesser General Public License v3.0 (GNU LGPLv3).

See the [LICENSE](LICENSE) file for details.

## ⚠️ Disclaimer

This mod is designed for offline servers and single-player worlds. Use at your own risk on multiplayer servers, as changing your nickname may violate server rules or cause unexpected behavior. The author is not responsible for any consequences resulting from the use of this mod.

## 📞 Support

If you find any bugs or have feature requests, please [create an issue](https://github.com/hamudov/Offline-Account-Switcher/issues) on GitHub.
