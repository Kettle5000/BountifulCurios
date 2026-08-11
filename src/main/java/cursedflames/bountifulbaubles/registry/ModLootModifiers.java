package cursedflames.bountifulbaubles.registry;

import com.mojang.serialization.Codec;
import cursedflames.bountifulbaubles.BountifulBaubles;
import cursedflames.bountifulbaubles.loot.OriginalLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    BountifulBaubles.MODID);

    public static final RegistryObject<Codec<OriginalLootModifier>> ORIGINAL_LOOT =
            SERIALIZERS.register("original_loot", () -> OriginalLootModifier.CODEC);

    private ModLootModifiers() {
    }
}
