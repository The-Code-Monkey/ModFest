package net.astrum.common.items;

import net.astrum.common.materials.AstrumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class AstrumSword extends SwordItem {
    protected AstrumSword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings){
        super(material, attackDamage, attackSpeed, settings);
    }

    public static AstrumSword alienSword=new AstrumSword((AstrumToolMaterials.ALIEN_SCRAP), 3, -2.4F, new Item.Settings());

}
