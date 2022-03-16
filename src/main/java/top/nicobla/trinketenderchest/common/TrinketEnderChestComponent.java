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

import dev.onyxstudios.cca.api.v3.item.ItemComponent;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.item.ItemStack;

public class TrinketEnderChestComponent extends ItemComponent {

  protected final ItemStack stack;

  // private EnderChestBlockEntity.AnimationStage animationStage = EnderChestBlockEntity.AnimationStage.CLOSED;
  private float animationProgress;
  private float prevAnimationProgress;

  public TrinketEnderChestComponent(ItemStack stack) {
    super(stack);
    this.stack = stack;
    this.stack.getOrCreateSubNbt("BlockEntityTag");
  }

  // public void setAnimationStage(EnderChestBlockEntity.AnimationStage stage) {
  //   this.animationStage = stage;
  // }

  public float getAnimationProgress(float delta) {
    return this.prevAnimationProgress + (this.animationProgress - this.prevAnimationProgress) * delta;
  }

  public void tick() {
    this.prevAnimationProgress = this.animationProgress;

    // switch (this.animationStage) {
    //   case CLOSED -> this.animationProgress = 0.0F;
    //   case OPENING -> {
    //     this.animationProgress += 0.1F;
    //     if (this.animationProgress >= 1.0F) {
    //       this.animationStage = EnderChestBlockEntity.AnimationStage.OPENED;
    //       this.animationProgress = 1.0F;
    //     }
    //   }
    //   case CLOSING -> {
    //     this.animationProgress -= 0.1F;
    //     if (this.animationProgress <= 0.0F) {
    //       this.animationStage = EnderChestBlockEntity.AnimationStage.CLOSED;
    //       this.animationProgress = 0.0F;
    //     }
    //   }
    //   case OPENED -> this.animationProgress = 1.0F;
    // }
  }
}
