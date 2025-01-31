package com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.net.minecraft.world.entity;

import com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.MappedObject;
import com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.net.minecraft.server.level.WorldServer;
import com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.net.minecraft.nbt.NBTTagCompound;
import com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.net.minecraft.network.PlayerConnection;
import com.bgsoftware.superiorskyblock.nms.v1_18_R1.mapping.net.minecraft.world.entity.boss.enderdragon.phases.DragonControllerManager;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.animal.EntityAnimal;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import net.minecraft.world.entity.item.EntityItem;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Entity extends MappedObject<net.minecraft.world.entity.Entity> {

    public Entity(net.minecraft.world.entity.Entity handle) {
        super(handle);
    }

    @Nullable
    public static Entity ofNullable(net.minecraft.world.entity.Entity handle) {
        return handle == null ? null : new Entity(handle);
    }

    public void setRemoved(net.minecraft.world.entity.Entity.RemovalReason removalReason) {
        handle.b(removalReason);
    }

    public float getXRot() {
        return handle.dn();
    }

    public float getYRot() {
        return handle.dm();
    }

    public UUID getUniqueID() {
        return handle.cm();
    }

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        handle.a(x, y, z, yaw, pitch);
    }

    public boolean isBreedItem(ItemStack itemStack) {
        return ((EntityAnimal) handle).n(itemStack);
    }

    public GameProfile getProfile() {
        return ((EntityHuman) handle).fp();
    }

    public UUID getThrower() {
        return ((EntityItem) handle).j();
    }

    public void save(NBTTagCompound nbtTagCompound) {
        handle.f(nbtTagCompound.getHandle());
    }

    public DragonControllerManager getDragonControllerManager() {
        return new DragonControllerManager(((EntityEnderDragon) handle).fw());
    }

    public PlayerConnection getPlayerConnection() {
        return new PlayerConnection(((EntityPlayer) handle).b);
    }

    public CraftEntity getBukkitEntity() {
        return handle.getBukkitEntity();
    }

    public void setWorld(WorldServer worldServer) {
        handle.t = worldServer.getHandle();
    }

    public WorldServer getWorld() {
        return new WorldServer((net.minecraft.server.level.WorldServer) handle.t);
    }

    public boolean isInWorld(WorldServer worldServer) {
        return worldServer.getHandle().equals(handle.t);
    }

}
