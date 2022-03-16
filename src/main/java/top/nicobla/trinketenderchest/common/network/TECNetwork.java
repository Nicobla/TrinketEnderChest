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

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import java.util.List;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Pair;
import top.nicobla.trinketenderchest.common.TrinketEnderChestInventory;

public class TECNetwork {

  public static void register() {
    ServerPlayNetworking.registerGlobalReceiver(TECPackets.OPEN_ENDER_CHEST,
        (server, player, handler, buf, responseSender) -> {
          player.incrementStat(Stats.OPEN_ENDERCHEST);
          TrinketsApi.getTrinketComponent(player).ifPresent(component -> {
            List<Pair<SlotReference, ItemStack>> res =
                component.getEquipped(TECNetwork::isEnderChest);

            if (res.size() > 0) {
              player.openHandledScreen(new TrinketEnderChestInventory(res.get(0).getRight(), player.getEnderChestInventory()));
            }
          });
        });
  }

  private static boolean isEnderChest(ItemStack stack) {

    if (stack.getItem() instanceof BlockItem blockItem) {
      Block block = blockItem.getBlock();
      if (block instanceof EnderChestBlock) {return true;}
    }
    return false;
  }
}
