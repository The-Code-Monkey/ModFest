package net.astrum.common.entity;

import jdk.internal.jline.internal.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Objects;

public class EntityTriffid extends HostileEntity {
    private static final double HEALTH = 10.0D;
    private static final double BASE_SPEED = 0.23D;
    private static final double MAX_SPEED = 1.0D;
    private static final double DAMAGE = 2.0D;
    private static final double FOLLOW_RANGE = 30.0D;
    private static final double KNOCKBACK = 0.5D;
    private LivingEntity cachedLineTarget;

    protected WanderAroundGoal wanderGoal;
    private int lineTicks;

    private static final TrackedData<Integer> LINE_TARGET_ID;

    public EntityTriffid(EntityType<? extends EntityTriffid> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    public int getWarmupTime() {
        return 30;
    }

    static {
        LINE_TARGET_ID = DataTracker.registerData(EntityTriffid.class, TrackedDataHandlerRegistry.INTEGER);
    }

    @Override
    protected void initGoals() {
        this.wanderGoal = new WanderAroundGoal(this, MAX_SPEED);
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new MeleeAttackGoal(this, MAX_SPEED, true));
//        this.targetSelector.add(2, );
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, this.wanderGoal);
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LINE_TARGET_ID, 0);
    }

    protected void initCustomGoals() {

    }

    public static DefaultAttributeContainer.Builder getAttributeContainer() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, HEALTH)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, BASE_SPEED)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, DAMAGE)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, FOLLOW_RANGE)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, KNOCKBACK);
    }

    private void setLineTarget(int progress) {
        this.dataTracker.set(LINE_TARGET_ID, progress);
    }

    public boolean hasLineTarget() {
        return this.dataTracker.get(LINE_TARGET_ID) != 0;
    }

    @Nullable
    public LivingEntity getLineTarget() {
        if (!this.hasLineTarget()) {
            return null;
        } else if (this.world.isClient) {
            if(this.cachedLineTarget != null) {
                return this.cachedLineTarget;
            } else {
                Entity entity = this.world.getEntityById(this.dataTracker.get(LINE_TARGET_ID));
                if (entity instanceof LivingEntity) {
                    this.cachedLineTarget = (LivingEntity)entity;
                    return this.cachedLineTarget;
                } else {
                    return null;
                }
            }
        } else {
            return this.getTarget();
        }
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        if (LINE_TARGET_ID.equals(data)) {
            this.lineTicks = 0;
            this.cachedLineTarget = null;
        }

    }
}