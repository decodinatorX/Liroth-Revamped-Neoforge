package com.decodinator.liroth.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.PortalParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class LirothPortalParticle extends PortalParticle {
    private LirothPortalParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, TextureAtlasSprite sprite) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed, sprite);
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new LirothPortalParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites.get(random));
        }
    }
}
