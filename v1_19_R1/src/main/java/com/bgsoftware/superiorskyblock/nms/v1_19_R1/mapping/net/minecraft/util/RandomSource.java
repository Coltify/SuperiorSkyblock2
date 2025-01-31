package com.bgsoftware.superiorskyblock.nms.v1_19_R1.mapping.net.minecraft.util;

import com.bgsoftware.superiorskyblock.nms.v1_19_R1.mapping.MappedObject;

public final class RandomSource extends MappedObject<net.minecraft.util.RandomSource> {

    public RandomSource(net.minecraft.util.RandomSource handle) {
        super(handle);
    }

    public float nextFloat() {
        return this.handle.i();
    }

}
