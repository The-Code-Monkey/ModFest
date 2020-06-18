package net.astrum.common.entity;

import net.astrum.common.registry.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EntityTriffid extends HostileEntity implements RangedAttackMob {
    private static final double HEALTH = 10.0D;
    private static final double BASE_SPEED = 0.23D;
    private static final double MAX_SPEED = 1.0D;
    private static final double DAMAGE = 2.0D;
    private static final double FOLLOW_RANGE = 30.0D;
    private static final float PROJECTILE_RANGE = 20.0F;
    private static final double KNOCKBACK = 0.5D;

    public EntityTriffid(EntityType<? extends EntityTriffid> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, MAX_SPEED, 30, PROJECTILE_RANGE));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new WanderAroundGoal(this, MAX_SPEED));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        EntityTriffidProjectile projectile = EntityRegistry.TRIFFID_PROJECTILE.create(world);
        assert projectile != null;
        projectile.updatePositionAndAngles(getX(), getEyeY() + 0.5D, getZ(), 0, 0);
        projectile.setParams(this, target);
        world.spawnEntity(projectile);
        // PLAY SOUND
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
}