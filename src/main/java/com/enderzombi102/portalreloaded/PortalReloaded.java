package com.enderzombi102.portalreloaded;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static com.enderzombi102.portalreloaded.Content.portalGun;

public class PortalReloaded implements ModInitializer {

	public static ItemGroup creativeTab = FabricItemGroupBuilder.build(
			new Identifier("portalreloaded", "itemgroup"),
			() -> new ItemStack( portalGun )
	);

	@Override
	public void onInitialize() {

	}
}
