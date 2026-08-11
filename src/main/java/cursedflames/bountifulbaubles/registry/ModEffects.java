package cursedflames.bountifulbaubles.registry;

import cursedflames.bountifulbaubles.BountifulBaubles;
import cursedflames.bountifulbaubles.effect.SinfulEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BountifulBaubles.MODID);

    public static final RegistryObject<MobEffect> SINFUL =
            EFFECTS.register("sinful", SinfulEffect::new);

    private ModEffects() {
    }
}
