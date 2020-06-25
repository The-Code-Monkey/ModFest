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
    public EntityTriffid(EntityType<? extends EntityTriffid> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0D, 30, 15F));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
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

    public static DefaultAttributeContainer.Builder getAttributeContainer() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }

}