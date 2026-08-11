package cursedflames.bountifulbaubles.client;

import cursedflames.bountifulbaubles.BountifulBaubles;
import cursedflames.bountifulbaubles.registry.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = BountifulBaubles.MODID, bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT)
public final class ClientEvents {
    private static final ResourceLocation BLOCKING = new ResourceLocation("blocking");
    private static final ResourceLocation USING = new ResourceLocation("using");

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerShieldProperties(ModItems.SHIELD_COBALT.get());
            registerShieldProperties(ModItems.SHIELD_OBSIDIAN.get());
            registerShieldProperties(ModItems.SHIELD_ANKH.get());
            registerUsingProperty(ModItems.MAGIC_MIRROR.get());
            registerUsingProperty(ModItems.WORMHOLE_MIRROR.get());

            CuriosRendererRegistry.register(ModItems.SUNGLASSES.get(),
                    SunglassesCurioRenderer::new);
            registerAmulet(ModItems.AMULET_CROSS.get(), "amulet_cross");
            registerAmulet(ModItems.AMULET_SIN_EMPTY.get(), "amulet_sin_empty");
            registerAmulet(ModItems.AMULET_SIN_GLUTTONY.get(), "amulet_sin_gluttony");
            registerAmulet(ModItems.AMULET_SIN_PRIDE.get(), "amulet_sin_pride");
            registerAmulet(ModItems.AMULET_SIN_WRATH.get(), "amulet_sin_wrath");

            CuriosRendererRegistry.register(ModItems.SHIELD_COBALT.get(),
                    BodyItemCurioRenderer::new);
            CuriosRendererRegistry.register(ModItems.SHIELD_OBSIDIAN.get(),
                    BodyItemCurioRenderer::new);
            CuriosRendererRegistry.register(ModItems.SHIELD_ANKH.get(),
                    BodyItemCurioRenderer::new);
        });
    }

    private static void registerShieldProperties(Item item) {
        ItemProperties.register(item, BLOCKING, (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack
                        ? 1.0F : 0.0F);
    }

    private static void registerUsingProperty(Item item) {
        ItemProperties.register(item, USING, (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack
                        ? 1.0F : 0.0F);
    }

    private static void registerAmulet(Item item, String texture) {
        ResourceLocation location = new ResourceLocation(BountifulBaubles.MODID,
                "textures/equipped/" + texture + ".png");
        CuriosRendererRegistry.register(item, () -> new AmuletCurioRenderer(location));
    }

    private ClientEvents() {
    }
}
