package cursedflames.bountifulbaubles;

import com.mojang.logging.LogUtils;
import cursedflames.bountifulbaubles.registry.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import net.minecraftforge.fml.ModList;

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
        if (ModList.get().isLoaded("firstaid")) {
            MinecraftForge.EVENT_BUS.register(BrokenHeartFirstAidCompat.class);
        }
    }
}
