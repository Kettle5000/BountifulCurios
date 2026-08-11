package cursedflames.bountifulbaubles;

import com.mojang.logging.LogUtils;
import cursedflames.bountifulbaubles.registry.ModBlocks;
import cursedflames.bountifulbaubles.registry.ModEffects;
import cursedflames.bountifulbaubles.registry.ModItems;
import cursedflames.bountifulbaubles.registry.ModLootModifiers;
import cursedflames.bountifulbaubles.registry.ModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BountifulBaubles.MODID)
public final class BountifulBaubles {
    public static final String MODID = "bountifulbaubles";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BountifulBaubles() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modBus);
        ModBlocks.BLOCK_ITEMS.register(modBus);
        ModEffects.EFFECTS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModLootModifiers.SERIALIZERS.register(modBus);
        ModTabs.TABS.register(modBus);
    }
}
