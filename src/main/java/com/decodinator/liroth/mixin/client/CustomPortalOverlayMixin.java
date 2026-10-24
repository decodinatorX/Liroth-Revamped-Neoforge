package com.decodinator.liroth.mixin.client;

import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.CustomPortalsMod;
import net.kyrptonaught.customportalapi.mixin.client.PortalManagerAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.entity.PortalProcessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModelShaper.class)
public abstract class CustomPortalOverlayMixin {
    @Unique
    private static CustomPortalBlock lastPortalBlock;
    @Unique
    private static int fadeFrames;

    @Inject(method = "getParticleIcon", at = @At("HEAD"), cancellable = true)
    private void liroth$useActivePortalIcon(BlockState state, CallbackInfoReturnable<TextureAtlasSprite> cir) {
        Block block = state.getBlock();
        if (block != CustomPortalsMod.portalBlock.get() && block != Blocks.NETHER_PORTAL) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && minecraft.player.portalProcess != null) {
            PortalProcessor portalProcess = minecraft.player.portalProcess;
            if (portalProcess.isInsidePortalThisTick()) {
                Portal portal = ((PortalManagerAccessor) portalProcess).getPortal();
                if (portal instanceof CustomPortalBlock customPortal) {
                    lastPortalBlock = customPortal;
                    fadeFrames = 0;
                } else {
                    lastPortalBlock = null;
                }
            }
        }

        if (block == Blocks.NETHER_PORTAL && lastPortalBlock != null) {
            if (++fadeFrames > 45) {
                lastPortalBlock = null;
            }
        }

        if (lastPortalBlock != null) {
            cir.setReturnValue(((BlockModelShaper) (Object) this).getBlockModel(lastPortalBlock.defaultBlockState()).getParticleIcon());
        }
    }
}
