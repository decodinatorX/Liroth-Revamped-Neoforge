package com.decodinator.liroth.core.entities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class PierPeepEntity extends Vex {
    public PierPeepEntity(EntityType<? extends Vex> entity, Level level) {
        super(entity, level);
        this.setNoGravity(true);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PierPeepEntity.PeepChargeAttackGoal());
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, Raider.class).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);
        this.resetFallDistance();
    }

    @Override
    public void move(MoverType type, Vec3 movement) {
        boolean previousNoPhysics = this.noPhysics;
        this.noPhysics = false;
        try {
            super.move(type, movement);
        } finally {
            this.noPhysics = previousNoPhysics;
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    public static AttributeSupplier.Builder createPierPeepAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 14)
                .add(Attributes.ATTACK_DAMAGE, 4);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    protected SoundEvent getStepSound() {
        return null;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
    }

    class PeepChargeAttackGoal extends Goal {
        public PeepChargeAttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            LivingEntity livingentity = PierPeepEntity.this.getTarget();
            return livingentity != null
                    && livingentity.isAlive()
                    && !PierPeepEntity.this.getMoveControl().hasWanted()
                    && PierPeepEntity.this.random.nextInt(reducedTickDelay(7)) == 0
                    ? PierPeepEntity.this.distanceToSqr(livingentity) > 4.0
                    : false;
        }

        @Override
        public boolean canContinueToUse() {
            return PierPeepEntity.this.getMoveControl().hasWanted() && PierPeepEntity.this.isCharging() && PierPeepEntity.this.getTarget() != null && PierPeepEntity.this.getTarget().isAlive();
        }

        @Override
        public void start() {
            LivingEntity livingentity = PierPeepEntity.this.getTarget();
            if (livingentity != null) {
                Vec3 vec3 = livingentity.getEyePosition();
                PierPeepEntity.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0);
            }

            PierPeepEntity.this.setIsCharging(true);
        }

        @Override
        public void stop() {
            PierPeepEntity.this.setIsCharging(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity livingentity = PierPeepEntity.this.getTarget();
            if (livingentity != null) {
                if (PierPeepEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                    PierPeepEntity.this.doHurtTarget(livingentity);
                    PierPeepEntity.this.setIsCharging(false);
                } else {
                    double d0 = PierPeepEntity.this.distanceToSqr(livingentity);
                    if (d0 < 9.0) {
                        Vec3 vec3 = livingentity.getEyePosition();
                        PierPeepEntity.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0);
                    }
                }
            }
        }
    }
}
