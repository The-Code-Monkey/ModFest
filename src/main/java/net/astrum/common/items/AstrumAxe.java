package net.astrum.common.items;

import net.astrum.common.materials.AstrumToolMaterials;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class AstrumAxe extends AxeItem {
    protected AstrumAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings){
        super(material, attackDamage, attackSpeed, settings);
    }

    public static AstrumAxe alienAxe=new AstrumAxe((AstrumToolMaterials.ALIEN_SCRAP), 6, -3.1F, new Item.Settings());
}
