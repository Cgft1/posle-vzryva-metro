package ru.metroafter.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.metroafter.MetroAfter;
import ru.metroafter.item.FilterItem;
import ru.metroafter.item.GasMaskItem;
import ru.metroafter.item.ScrapWeaponItem;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MetroAfter.MODID);
    public static final RegistryObject<Item> SCRAP_METAL = ITEMS.register("scrap_metal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WIRE = ITEMS.register("wire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPRING = ITEMS.register("spring", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter", () -> new FilterItem(new Item.Properties().durability(120)));
    public static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask", () -> new GasMaskItem(new Item.Properties().durability(240).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PIPE_PISTOL = ITEMS.register("pipe_pistol", () -> new ScrapWeaponItem(new Item.Properties().durability(90), 7.0F, 1.4F));
    public static final RegistryObject<Item> SCRAP_SHOTGUN = ITEMS.register("scrap_shotgun", () -> new ScrapWeaponItem(new Item.Properties().durability(65), 11.0F, 1.9F));
    public static final RegistryObject<Item> SCRAP_CLUB = ITEMS.register("scrap_club", () -> new Item(new Item.Properties().durability(180).stacksTo(1)));
    private ModItems() {}
}
