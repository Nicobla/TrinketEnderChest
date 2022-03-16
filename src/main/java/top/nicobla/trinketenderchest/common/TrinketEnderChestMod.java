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

package top.nicobla.trinketenderchest.common;

import dev.emi.trinkets.api.TrinketsApi;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.nicobla.trinketenderchest.common.network.TECNetwork;

public class TrinketEnderChestMod implements ModInitializer, ItemComponentInitializer {

  public static final String MOD_ID = "trinketenderchest";
  public static final Logger LOGGER = LogManager.getLogger();
  public static final ComponentKey<TrinketEnderChestComponent> TRINKET_ENDER_CHEST_COMPONENT =
      ComponentRegistry
          .getOrCreate(new Identifier(MOD_ID, "ender_chest"), TrinketEnderChestComponent.class);

  public static boolean isEnderiteLoaded = false;
  public static boolean isNetheriteLoaded = false;

  @Override
  public void onInitialize() {
    Item[] enderChest = new Item[] {Items.ENDER_CHEST};

    for (Item item : enderChest) {
      TrinketsApi.registerTrinket(item, new TrinketEnderChest());
    }
    TECNetwork.register();

    // Integrations
//    FabricLoader loader = FabricLoader.getInstance();
//
//    if (loader.isModLoaded("enderitemod")) {
//      isEnderiteLoaded = true;
//      EnderiteIntegration.setup();
//    }
//
//    if (loader.isModLoaded("netherite_plus")) {
//      isNetheriteLoaded = true;
//      NetheriteIntegration.setup();
//    }
  }

  @Override
  public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {
    Item[] enderChest = new Item[] {Items.ENDER_CHEST};

    for (Item item : enderChest) {
      registry.register(item, TRINKET_ENDER_CHEST_COMPONENT, TrinketEnderChestComponent::new);
    }
  }
}
