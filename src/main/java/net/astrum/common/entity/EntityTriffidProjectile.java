package net.astrum.common.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

import static net.minecraft.entity.damage.DamageSource.GENERIC;

public class EntityTriffidProjectile extends FlyingEntity {
    private static final int MAX_LIFE_TIME = 100;
    private int lifeTime = 0;

    public EntityTriffidProjectile(EntityType<? extends EntityTriffidProjectile> type, World world) {
        super(type, world);
        this.experiencePoints = 0;
    }

    public static DefaultAttributeContainer.Builder getAttributeContainer() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D);
    }

    public void setParams(LivingEntity owner, Entity target) {
        this.updatePosition(getX(), getEyeY() - this.getHeight(), getZ());
        Vec3d dir = target.getPos().add(0, target.getHeight() * 0.25, 0).subtract(getPos()).normalize().multiply(2);
        this.setVelocity(dir);
        this.prevX = getX() - dir.x;
        this.prevY = getY() - dir.y;
        this.prevZ = getZ() - dir.z;
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Environment(EnvType.CLIENT)
    public boolean shouldRender(double distance) {
        return distance < 128;
    }

    @Override
    public void tick() {
        super.tick();

        world.addParticle(ParticleTypes.ITEM_SLIME,
                getX() + random.nextGaussian() * 0.2,
                getY() + random.nextGaussian() * 0.2,
                getZ() + random.nextGaussian() * 0.2,
                0, 0, 0);
        world.addParticle(ParticleTypes.ITEM_SLIME,
                getX() + random.nextGaussian() * 0.3,
                getY() + random.nextGaussian() * 0.3,
                getZ() + random.nextGaussian() * 0.3,
                0, 0, 0);
        world.addParticle(ParticleTypes.ITEM_SLIME,
                getX() + random.nextGaussian() * 0.1,
                getY() + random.nextGaussian() * 0.1,
                getZ() + random.nextGaussian() * 0.1,
                0.1, 0.1, 0.1);

        HitResult hitResult = ProjectileUtil.getCollision(this, (entity) -> entity.isAlive() && entity instanceof LivingEntity, RayTraceContext.ShapeType.COLLIDER);

        if (hitResult.getType() != HitResult.Type.MISS) {
            this.onCollision(hitResult);
        }

        lifeTime++;
        if (lifeTime > MAX_LIFE_TIME) {
            effectKill();
        }

        if (isSame(this.prevX, this.getX()) && isSame(this.prevY, this.getY()) && isSame(this.prevZ, this.getZ())) {
            effectKill();
        }
    }

    private boolean isSame(double a, double b) {
        return Math.abs(a - b) < 0.1;
    }

    protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if (type == HitResult.Type.BLOCK) {
            effectKill();
        } else if (type == HitResult.Type.ENTITY) {
            Entity entity = ((EntityHitResult) hitResult).getEntity();
            if (entity != this && entity instanceof LivingEntity && !(entity instanceof EntityTriffid)) {
                LivingEntity living = (LivingEntity) entity;

                living.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 400));
                living.damage(GENERIC, 4);

                effectKill();
            }
        }
    }

    private void effectKill() {
        for (int i = 0; i < 10; i++) {
            world.addParticle(ParticleTypes.ITEM_SLIME,
                    getX() + random.nextGaussian() * 0.10,
                    getY() + random.nextGaussian() * 0.10,
                    getZ() + random.nextGaussian() * 0.10,
                    0.1, 0.1, 0.1);
        }
        this.remove();
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        return false;
    }

    @Override
    public boolean isSilent() {
        return true;
    }

    @Override
    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putInt("life", lifeTime);
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        if (tag.contains("life")) {
            lifeTime = tag.getInt("life");
        }
    }

}
