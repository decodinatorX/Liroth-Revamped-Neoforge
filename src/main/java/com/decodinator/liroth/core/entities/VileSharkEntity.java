package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.core.registry.LirothFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.TagKey;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class VileSharkEntity extends AbstractFish {
    @Nullable
    private Vec3 roamingDirection;
    private int roamingTicks;

    public VileSharkEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType,
                                        @Nullable SpawnGroupData spawnGroupData) {
        this.setAirSupply(this.getMaxAirSupply());
        this.setXRot(0.0F);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected void handleAirSupply(int airSupply) {
    }

    @Override
    public boolean isInWater() {
        return super.isInWater() || this.getFluidTypeHeight(LirothFluids.LIROTH_FLUID_TYPE) > 0.0D;
    }

    @Override
    public boolean isEyeInFluid(TagKey<Fluid> fluidTag) {
        return super.isEyeInFluid(fluidTag)
                || (fluidTag == FluidTags.WATER && this.getEyeInFluidType() == LirothFluids.LIROTH_FLUID_TYPE);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        this.setAirSupply(this.getMaxAirSupply());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide || !this.isInWater()) {
            return;
        }

        LivingEntity target = this.getTarget();
        if (!isValidPlayerTarget(target)) {
            this.setTarget(null);
            target = null;
        }

        Vec3 swimDirection;
        double fluidSurfaceY = this.findFluidSurfaceY();
        if (target != null) {
            double targetY = target.getY() + target.getBbHeight() * 0.5D;
            if (Double.isFinite(fluidSurfaceY)) {
                targetY = Math.min(targetY, fluidSurfaceY - this.getBbHeight() * 0.5D - 0.08D);
            }
            Vec3 targetCenter = new Vec3(target.getX(), targetY, target.getZ());
            Vec3 sharkCenter = this.position().add(0.0D, this.getBbHeight() * 0.5D, 0.0D);
            Vec3 toTarget = targetCenter.subtract(sharkCenter);
            swimDirection = toTarget.lengthSqr() > 3.0D ? toTarget.normalize() : Vec3.ZERO;
        } else {
            if (this.roamingDirection == null || --this.roamingTicks <= 0
                    || this.horizontalCollision || this.verticalCollision) {
                this.roamingDirection = new Vec3(
                        this.random.nextDouble() * 2.0D - 1.0D,
                        this.random.nextDouble() * 0.3D - 0.2D,
                        this.random.nextDouble() * 2.0D - 1.0D
                ).normalize();
                this.roamingTicks = 30 + this.random.nextInt(41);
            }
            swimDirection = this.roamingDirection;
        }

        if (Double.isFinite(fluidSurfaceY)
                && this.getY() + this.getBbHeight() >= fluidSurfaceY - 0.08D
                && swimDirection.y > 0.0D) {
            swimDirection = new Vec3(swimDirection.x, 0.0D, swimDirection.z).normalize();
        }

        this.setYRot((float) (Math.atan2(swimDirection.z, swimDirection.x) * 180.0D / Math.PI) - 90.0F);
        this.yBodyRot = this.getYRot();
        this.setXRot((float) (-Math.asin(swimDirection.y) * 180.0D / Math.PI));
        this.move(MoverType.SELF, swimDirection.scale(0.14D));

        if (Double.isFinite(fluidSurfaceY)) {
            double maxY = fluidSurfaceY - this.getBbHeight() - 0.08D;
            if (this.getY() > maxY) {
                this.move(MoverType.SELF, new Vec3(0.0D, maxY - this.getY(), 0.0D));
            }
        }
    }

    private static boolean isValidPlayerTarget(@Nullable LivingEntity target) {
        return target != null && target.isAlive()
                && (!(target instanceof Player player) || (!player.isCreative() && !player.isSpectator()));
    }

    private double findFluidSurfaceY() {
        int startY = (int) Math.floor(this.getY()) - 2;
        double surfaceY = Double.NaN;
        boolean foundFluid = false;

        for (int y = startY; y <= startY + 64 && y < this.level().getMaxBuildHeight(); y++) {
            BlockPos pos = BlockPos.containing(this.getX(), y, this.getZ());
            FluidState fluidState = this.level().getFluidState(pos);
            boolean isSwimFluid = fluidState.is(FluidTags.WATER)
                    || fluidState.getFluidType() == LirothFluids.LIROTH_FLUID_TYPE;

            if (isSwimFluid) {
                foundFluid = true;
                surfaceY = y + fluidState.getHeight(this.level(), pos);
            } else if (foundFluid) {
                return surfaceY;
            }
        }

        return Double.NaN;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        WaterBoundPathNavigation navigation = new WaterBoundPathNavigation(this, level);
        navigation.setCanFloat(true);
        return navigation;
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader level) {
        return level.isUnobstructed(this);
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean canBeLeashed() {
        return false;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return ItemStack.EMPTY;
    }

    public static AttributeSupplier.Builder createVileSharkAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 30.0)
                .add(Attributes.FOLLOW_RANGE, 48.0)
                .add(Attributes.MOVEMENT_SPEED, 1.2)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.ATTACK_SPEED, 1.0)
                .add(Attributes.ARMOR, 2.0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0, 40));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
