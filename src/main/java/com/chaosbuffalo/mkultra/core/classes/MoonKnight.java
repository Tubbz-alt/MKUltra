package com.chaosbuffalo.mkultra.core.classes;

import com.chaosbuffalo.mkultra.MKUltra;
import com.chaosbuffalo.mkultra.core.*;
import com.chaosbuffalo.mkultra.core.abilities.*;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 3/24/2018.
 */
public class MoonKnight extends PlayerClass {
    public static ResourceLocation ID = new ResourceLocation(MKUltra.MODID, "class.moon_knight");

    private static final List<PlayerAbility> abilities = new ArrayList<>(5);

    static {
        abilities.add(new VampiricRevere());
        abilities.add(new CrescentSlash());
        abilities.add(new NocturnalCommunion());
        abilities.add(new DualityRune());
        abilities.add(new MoonTrance());
    }

    public MoonKnight() {
        super(ID);
    }

    @Override
    public List<PlayerAbility> getAbilities() {
        return abilities;
    }

    @Override
    public int getHealthPerLevel(){
        return 1;
    }

    @Override
    public int getBaseHealth(){
        return 26;
    }

    @Override
    public float getBaseManaRegen(){
        return 1;
    }

    @Override
    public float getManaRegenPerLevel(){
        return 0.2f;
    }

    @Override
    public int getBaseMana(){
        return 12;
    }

    @Override
    public int getManaPerLevel(){
        return 1;
    }

    @Override
    public ArmorClass getArmorClass() {
        return ArmorClass.HEAVY;
    }

    @Override
    public IClassClientData getClientData() {
        return ClassClientData.MoonIcon.INSTANCE;
    }
}
