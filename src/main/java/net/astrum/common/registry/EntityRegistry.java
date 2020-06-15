package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.entity.EntityTriffid;
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

    public static void register() {
        FabricDefaultAttributeRegistry.register(TRIFFID, EntityTriffid.getAttributeContainer());
    }

}
