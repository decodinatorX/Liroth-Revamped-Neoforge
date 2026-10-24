package com.decodinator.liroth.core.entities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.DifficultyInstance;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ForsakenCorpseEntity extends Zombie implements GeoAnimatable {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public ForsakenCorpseEntity(EntityType<? extends Zombie> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 20;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        return super.finalizeSpawn(level, difficulty, spawnType, new Zombie.ZombieGroupData(false, false));
    }

    public static AttributeSupplier.Builder createForsakenCorpseAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.MOVEMENT_SPEED, 0.23f)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.ARMOR, 4.0)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.DROWNED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.DROWNED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DROWNED_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.DROWNED_STEP;
    }
    private static final RawAnimation CORPSE_WALK = RawAnimation.begin().thenPlay("corpse_walk");
    private static final RawAnimation CORPSE_CHASE = RawAnimation.begin().thenPlay("corpse_chase");
    private static final RawAnimation CORPSE_IDLE = RawAnimation.begin().thenPlay("corpse_idle");

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F) && !this.isAggressive()) {
            event.getController().setAnimation(CORPSE_WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving()&& !this.isAggressive()) {
            event.getController().setAnimation(CORPSE_WALK);
            return PlayState.CONTINUE;
        }

        if (!(swingTime > -0.15F && swingTime < 0.15F) && this.isAggressive()) {
            event.getController().setAnimation(CORPSE_CHASE);
            return PlayState.CONTINUE;
        }

        if (event.isMoving() && this.isAggressive()) {
            event.getController().setAnimation(CORPSE_CHASE);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(CORPSE_IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<ForsakenCorpseEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public double getTick(Object o) {
        return ((Entity)o).tickCount;
    }
}
