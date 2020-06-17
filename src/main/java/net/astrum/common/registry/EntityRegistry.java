package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.entity.EntityTriffid;
import net.astrum.common.entity.EntityTriffidProjectile;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static final EntityType<EntityTriffid> TRIFFID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(AstrumCore.MOD_ID, "triffid"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EntityTriffid::new).dimensions(EntityDimensions.fixed(1.25F, 4F)).build()
    );

    public static final EntityType<EntityTriffidProjectile> TRIFFID_PROJECTILE = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EntityTriffidProjectile::new).dimensions(EntityDimensions.changing(2F, 5F)).fireImmune().trackable(150, 1).build();

    public static void register() {
        FabricDefaultAttributeRegistry.register(TRIFFID, EntityTriffid.getAttributeContainer());
        FabricDefaultAttributeRegistry.register(TRIFFID_PROJECTILE, EntityTriffidProjectile.getAttributeContainer());
    }

}
