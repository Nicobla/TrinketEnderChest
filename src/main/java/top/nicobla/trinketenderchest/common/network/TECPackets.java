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

package top.nicobla.trinketenderchest.common.network;

import net.minecraft.util.Identifier;
import top.nicobla.trinketenderchest.common.TrinketEnderChestMod;

public class TECPackets {

  public static final Identifier OPEN_ENDER_CHEST = new Identifier(TrinketEnderChestMod.MOD_ID,
      "open_ender_chest");
  public static final Identifier OPENING_CHEST = new Identifier(TrinketEnderChestMod.MOD_ID,
      "opening_chest");
  public static final Identifier CLOSING_CHEST = new Identifier(TrinketEnderChestMod.MOD_ID,
      "closing_chest");
}
