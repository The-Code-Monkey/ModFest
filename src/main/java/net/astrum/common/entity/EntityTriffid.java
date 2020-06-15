package net.astrum.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EntityTriffid extends MobEntityWithAi {
    private static final double HEALTH = 10.0D;
    private static final double BASE_SPEED = 0.23D;
    private static final double MAX_SPEED = 1.0D;
    private static final double DAMAGE = 2.0D;
    private static final double FOLLOW_RANGE = 30.0D;
    private static final double KNOCKBACK = 0.5D;

    public EntityTriffid(EntityType<? extends MobEntityWithAi> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.lookDirection = 1.0F;

        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new MeleeAttackGoal(this, MAX_SPEED, true));
//        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
//        this.goalSelector.add(4, new WanderAroundFarGoal(this, MAX_SPEED));
//        this.goalSelector.add(5, new LookAroundGoal(this));
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