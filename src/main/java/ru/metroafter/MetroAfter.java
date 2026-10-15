package ru.metroafter;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ru.metroafter.registry.ModItems;

@Mod(MetroAfter.MODID)
public class MetroAfter {
    public static final String MODID = "metroafter";
    public MetroAfter() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(new RadiationHandler());
    }
}
