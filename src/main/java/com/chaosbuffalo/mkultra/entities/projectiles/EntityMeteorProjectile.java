package com.chaosbuffalo.mkultra.entities.projectiles;

import com.chaosbuffalo.mkultra.GameConstants;
import com.chaosbuffalo.mkultra.MKUltra;
import com.chaosbuffalo.mkultra.effects.AreaEffectBuilder;
import com.chaosbuffalo.mkultra.effects.SpellCast;
import com.chaosbuffalo.mkultra.effects.spells.MobFireballEffectPotion;
import com.chaosbuffalo.mkultra.fx.ParticleEffects;
import com.chaosbuffalo.mkultra.network.packets.ParticleEffectSpawnPacket;
import com.chaosbuffalo.targeting_api.Targeting;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityMeteorProjectile extends EntityBaseProjectile {

    public EntityMeteorProjectile(World worldIn) {
        super(worldIn);
    }

    @Override
    public void setup() {
        super.setup();
        this.setDeathTime(GameConstants.TICKS_PER_SECOND * 5);
        this.setSize(0.3f, 0.3f);
        setGraphicalEffectTickInterval(1);
    }

    public EntityMeteorProjectile(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityMeteorProjectile(World worldIn, EntityLivingBase throwerIn, double offset) {
        super(worldIn, throwerIn, offset);
    }

    @Override
    public void clientGraphicalUpdate() {
        super.clientGraphicalUpdate();
        Vec3d motion = new Vec3d(0, 0, 0);
        ParticleEffects.spawnParticle(EnumParticleTypes.FLAME.ordinal(), 0.0, getPositionVector(), motion, world);
        ParticleEffects.spawnParticle(EnumParticleTypes.SMOKE_LARGE.ordinal(), 0.0, getPositionVector(), motion, world);
    }

    @Override
    protected boolean onImpact(EntityLivingBase entity, RayTraceResult result, int level) {

        if (world.isRemote) {
            // No client code
            return false;
        }

//        if (entity != null && result.entityHit instanceof EntityLivingBase) {
//            EntityLivingBase targetEntity = (EntityLivingBase) result.entityHit;
//            SpellCast projectileEffect = MobFireballEffectPotion.Create(entity, 4.0f, .75f);
//
//
//            AreaEffectBuilder.Create(entity, this)
//                    .spellCast(projectileEffect, level, Targeting.TargetType.ENEMY)
//                    .instant()
//                    .color(16737330).radius(2.0f, true)
//                    .spawn();
//
//            Vec3d lookVec = entity.getLookVec();
//            MKUltra.packetHandler.sendToAllAround(
//                    new ParticleEffectSpawnPacket(
//                            EnumParticleTypes.DRIP_LAVA.getParticleID(),
//                            ParticleEffects.SPHERE_MOTION, 20, 4,
//                            targetEntity.posX, targetEntity.posY + 1.0,
//                            targetEntity.posZ, 0.25f, 0.25f, 0.25f, 0.25f,
//                            lookVec),
//                    entity.dimension, targetEntity.posX,
//                    targetEntity.posY, targetEntity.posZ, 50.0f);
//            return true;
//        } else if (entity != null) {
//            MKUltra.packetHandler.sendToAllAround(
//                    new ParticleEffectSpawnPacket(
//                            EnumParticleTypes.FIREWORKS_SPARK.getParticleID(),
//                            ParticleEffects.SPHERE_MOTION, 15, 3,
//                            result.hitVec.x, result.hitVec.y + 1.0,
//                            result.hitVec.z, 0.25f, 0.25f, 0.25f, 0.25f,
//                            new Vec3d(0., 1.0, 0.0)),
//                    entity.dimension, result.hitVec.x,
//                    result.hitVec.y, result.hitVec.z, 50.0f);
//            return true;
//        }
        return false;
    }

    @Override
    protected Targeting.TargetType getTargetType() {
        return Targeting.TargetType.ENEMY;
    }

    @Override
    protected boolean shouldExcludeCaster() {
        return true;
    }
}
