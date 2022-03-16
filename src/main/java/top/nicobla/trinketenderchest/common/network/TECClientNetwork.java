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

import dev.emi.trinkets.api.TrinketInventory;
import dev.emi.trinkets.api.TrinketsApi;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
// import net.minecraft.block.entity.EnderChestBlockEntity.AnimationStage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import top.nicobla.trinketenderchest.common.TrinketEnderChest;
import top.nicobla.trinketenderchest.common.TrinketEnderChestComponent;
import top.nicobla.trinketenderchest.common.TrinketEnderChestMod;

public class TECClientNetwork {

  public static void register() {
    ClientPlayNetworking
        .registerGlobalReceiver(TECPackets.OPENING_CHEST, (client, handler, buf, responseSender) -> {
          int entityId = buf.readInt();
          client.execute(() -> {
            ClientWorld clientWorld = MinecraftClient.getInstance().world;

            if (clientWorld != null) {
              Entity entity = clientWorld.getEntityById(entityId);

              if (entity instanceof LivingEntity livingEntity) {
                TrinketsApi.getTrinketComponent(livingEntity).ifPresent(component -> {

                  for (Map.Entry<String, Map<String, TrinketInventory>> group : component
                      .getInventory().entrySet()) {

                    for (Map.Entry<String, TrinketInventory> slotType : group.getValue()
                        .entrySet()) {
                      TrinketInventory inv = slotType.getValue();

                      for (int i = 0; i < inv.size(); i++) {
                        Optional<TrinketEnderChestComponent> trinket =
                            TrinketEnderChestMod.TRINKET_ENDER_CHEST_COMPONENT
                                .maybeGet(inv.getStack(i));

                        if (trinket.isPresent()) {
                          TrinketEnderChestComponent TrinketEnderChest = trinket.get();
                          // TrinketEnderChest.setAnimationStage(AnimationStage.OPENING);
                          return;
                        }
                      }
                    }
                  }
                });
              }
            }
          });
        });
    ClientPlayNetworking
        .registerGlobalReceiver(TECPackets.CLOSING_CHEST, (client, handler, buf, responseSender) -> {
          int entityId = buf.readInt();
          client.execute(() -> {
            ClientWorld clientWorld = MinecraftClient.getInstance().world;

            if (clientWorld != null) {
              Entity entity = clientWorld.getEntityById(entityId);

              if (entity instanceof LivingEntity livingEntity) {
                TrinketsApi.getTrinketComponent(livingEntity).ifPresent(component -> {

                  for (Map.Entry<String, Map<String, TrinketInventory>> group : component
                      .getInventory().entrySet()) {

                    for (Map.Entry<String, TrinketInventory> slotType : group.getValue()
                        .entrySet()) {
                      TrinketInventory inv = slotType.getValue();

                      for (int i = 0; i < inv.size(); i++) {
                        Optional<TrinketEnderChestComponent> trinket =
                            TrinketEnderChestMod.TRINKET_ENDER_CHEST_COMPONENT
                                .maybeGet(inv.getStack(i));

                        if (trinket.isPresent()) {
                          TrinketEnderChestComponent TrinketEnderChest = trinket.get();
                          // TrinketEnderChest.setAnimationStage(AnimationStage.CLOSING);
                          return;
                        }
                      }
                    }
                  }
                });
              }
            }
          });
        });
  }
}
