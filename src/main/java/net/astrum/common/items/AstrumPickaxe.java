package net.astrum.common.items;

import net.astrum.common.materials.AstrumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AstrumPickaxe extends PickaxeItem {
    protected AstrumPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings){
        super(material, attackDamage, attackSpeed, settings);
    }

    public static AstrumPickaxe alienPickaxe=new AstrumPickaxe((AstrumToolMaterials.ALIEN_SCRAP), 1, -2.8F, new Item.Settings());
}
