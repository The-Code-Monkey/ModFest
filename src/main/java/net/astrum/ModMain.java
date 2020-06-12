package net.astrum;

import net.fabricmc.api.ModInitializer;
import net.astrum.common.registry.BlocksRegistry;
import net.astrum.common.registry.ItemsRegistry;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModMain implements ModInitializer {

	public static final Tag<Item> SHEARS = TagRegistry.item(new Identifier("fabric", "shears"));
	public static final String MOD_ID = "astrum";

	@Override
	public void onInitialize() {
		BlocksRegistry.register();
		ItemsRegistry.register();
	}
}
