package com.epic312.fruitful.core;

import com.epic312.fruitful.core.other.FruitfulBlockData;
import com.epic312.fruitful.core.other.FruitfulEvents;
import com.epic312.fruitful.core.registry.FruitfulFeatures;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fruitful")
@Mod.EventBusSubscriber(modid = "fruitful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Fruitful
{
    public static final String MODID = "fruitful";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    private static final Logger LOGGER = LogManager.getLogger();

    public Fruitful() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRY_HELPER.getDeferredItemRegister().register(eventBus);
        REGISTRY_HELPER.getDeferredBlockRegister().register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::commonSetup);
        DistExecutor.runWhenOn(Dist.CLIENT, ()->()->{
            eventBus.addListener(this::clientSetup);
        });
    }

    @SuppressWarnings("deprecation")
    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new FruitfulEvents());
        DeferredWorkQueue.runLater(() -> {
            FruitfulBlockData.registerCompostables();
            FruitfulBlockData.registerFlammables();
            FruitfulFeatures.generateFeatures();
        });
    }

    @SuppressWarnings("deprecation")
    private void clientSetup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            FruitfulBlockData.registerBlockColors();
            FruitfulBlockData.setupRenderLayer();
        });
    }
}
