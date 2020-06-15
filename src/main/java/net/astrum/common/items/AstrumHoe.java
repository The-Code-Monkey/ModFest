package net.astrum.common.items;

import net.astrum.common.materials.AstrumToolMaterials;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class AstrumHoe extends HoeItem {
    protected AstrumHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings){
        super(material, attackDamage, attackSpeed, settings);
    }

    public static AstrumHoe alienHoe=new AstrumHoe((AstrumToolMaterials.ALIEN_SCRAP), -2, 0.0F, new Item.Settings());

}
