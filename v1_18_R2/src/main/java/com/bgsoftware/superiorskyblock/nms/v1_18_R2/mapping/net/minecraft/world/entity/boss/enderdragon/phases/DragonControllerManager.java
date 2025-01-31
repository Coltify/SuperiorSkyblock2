package com.bgsoftware.superiorskyblock.nms.v1_18_R2.mapping.net.minecraft.world.entity.boss.enderdragon.phases;

import com.bgsoftware.superiorskyblock.nms.v1_18_R2.mapping.MappedObject;
import net.minecraft.world.entity.boss.enderdragon.phases.DragonControllerPhase;
import net.minecraft.world.entity.boss.enderdragon.phases.IDragonController;

import javax.annotation.Nullable;

public class DragonControllerManager extends
        MappedObject<net.minecraft.world.entity.boss.enderdragon.phases.DragonControllerManager> {

    public DragonControllerManager(net.minecraft.world.entity.boss.enderdragon.phases.DragonControllerManager handle) {
        super(handle);
    }

    public void setControllerPhase(DragonControllerPhase<?> dragonControllerPhase) {
        handle.a(dragonControllerPhase);
    }

    @Nullable
    public IDragonController getDragonController() {
        return handle.a();
    }

}
