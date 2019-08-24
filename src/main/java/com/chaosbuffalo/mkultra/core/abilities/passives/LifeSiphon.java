package com.chaosbuffalo.mkultra.core.abilities.passives;

import com.chaosbuffalo.mkultra.MKUltra;
import com.chaosbuffalo.mkultra.core.IPlayerData;
import com.chaosbuffalo.mkultra.core.PlayerAbility;
import com.chaosbuffalo.mkultra.core.PlayerPassiveAbility;
import com.chaosbuffalo.mkultra.effects.passives.PassiveAbilityPotionBase;
import com.chaosbuffalo.mkultra.effects.spells.LifeSiphonPotion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MKUltra.MODID)
public class LifeSiphon extends PlayerPassiveAbility {

    public static final LifeSiphon INSTANCE = new LifeSiphon();

    @SubscribeEvent
    public static void register(RegistryEvent.Register<PlayerAbility> event) {
        event.getRegistry().register(INSTANCE.finish());
    }

    public LifeSiphon() {
        super(MKUltra.MODID, "ability.life_siphon");
    }

    @Override
    public PassiveAbilityPotionBase getPassiveEffect() {
        return LifeSiphonPotion.INSTANCE;
    }

    @Override
    public void applyEffect(EntityPlayer entity, IPlayerData pData, World theWorld) {
        entity.addPotionEffect(getPassiveEffect().createInstance(entity));
    }
}