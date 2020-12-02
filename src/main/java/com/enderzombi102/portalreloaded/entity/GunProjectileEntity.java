package com.enderzombi102.portalreloaded.entity;

import com.enderzombi102.portalreloaded.Content;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalManipulation;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GunProjectileEntity extends PersistentProjectileEntity {

	Text color;


	public GunProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public GunProjectileEntity(World world, LivingEntity owner) {
		super(Content.GunProjectileEntityType, owner, world);
	}

	public GunProjectileEntity(World world, double x, double y, double z) {
		super(Content.GunProjectileEntityType, x, y, z, world);
	}

	@Override
	protected void initDataTracker() {

	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {

		if ( this.getOwner() instanceof PlayerEntity ) {

			BlockPos blockPos = blockHitResult.getBlockPos();

			Portal portal = Portal.entityType.create(
					(ServerWorld) this.getEntityWorld(),
					null,
					this.color,
					(PlayerEntity) this.getOwner(),
					blockPos,
					SpawnReason.EVENT,
					true,
					false
			);
			( (ServerWorld) this.getEntityWorld() ).loadEntity(portal);
		}
		this.remove();
	}

	@Override
	protected ItemStack asItemStack() {
		return null;
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return null;
	}
}
