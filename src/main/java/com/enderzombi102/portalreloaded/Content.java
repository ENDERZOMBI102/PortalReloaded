package com.enderzombi102.portalreloaded;

import com.enderzombi102.portalreloaded.entity.GunProjectileEntity;
import com.enderzombi102.portalreloaded.item.PortalGun;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Content {

	public static Item portalGun = new PortalGun();
	public static final EntityType<GunProjectileEntity> GunProjectileEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("portalreloaded", "gun_projectile"),
			FabricEntityTypeBuilder.<GunProjectileEntity>create(SpawnGroup.MISC, GunProjectileEntity::new)
					.dimensions( EntityDimensions.fixed(0.25F, 0.25F) )
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);



}
