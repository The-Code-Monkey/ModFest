package net.astrum.common.items;

import net.astrum.common.materials.AstrumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AstrumShovel extends ShovelItem {
    protected AstrumShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings){
        super(material, attackDamage, attackSpeed, settings);
    }

    public static AstrumShovel alienShovel=new AstrumShovel((AstrumToolMaterials.ALIEN_SCRAP), 1.5F, -3.0F, new Item.Settings());
}
