package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.core.registry.LirothSounds;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class ShadeEntity extends Zombie {
    public ShadeEntity(EntityType<? extends Zombie> entity, Level level) {super(entity,level);}

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        return super.finalizeSpawn(level, difficulty, spawnType, new Zombie.ZombieGroupData(false, false));
    }

    public static AttributeSupplier.Builder createShadeAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.MOVEMENT_SPEED, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.ARMOR, 1000)
                .add(Attributes.MAX_HEALTH, 1000)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(LirothTags.TORCHES)) {
            this.level().playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.SOUL_SOIL_BREAK, this.getSoundSource(), 1f, this.random.nextFloat() * 0.4f + 0.8f);
            if (!this.level().isClientSide) {
                this.kill();
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        return super.mobInteract(player, hand);
    }
    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.SHADE_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.SHADE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.SHADE_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SOUL_SAND_STEP;
    }
}
