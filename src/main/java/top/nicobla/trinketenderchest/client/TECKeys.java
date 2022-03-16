/*
 * Copyright (c) 2019-2021 C4
 *
 * This file is part of Trinket Ender Chest, a mod made for Minecraft.
 *
 * Trinket Ender Chest is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Trinket Ender Chest is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Trinket Ender Chest. If not, see <https://www.gnu.org/licenses/>.
 */

package top.nicobla.trinketenderchest.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class TECKeys {

  public static final String CONFIG_OPEN_DESC = "key.trinketenderchest.open.desc";
  public static final String CONFIG_CATEGORY = "key.trinketenderchest.category";

  public static KeyBinding openEnderChest;

  public static void registerKeys() {
    openEnderChest = registerKeybinding(
        new KeyBinding(CONFIG_OPEN_DESC, GLFW.GLFW_KEY_V, CONFIG_CATEGORY));
  }

  private static KeyBinding registerKeybinding(KeyBinding key) {
    KeyBindingHelper.registerKeyBinding(key);
    return key;
  }
}
