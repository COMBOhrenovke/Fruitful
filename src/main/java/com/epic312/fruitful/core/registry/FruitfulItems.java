package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.common.item.OrangeJuiceItem;
import com.epic312.fruitful.core.Fruitful;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SoupItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulItems {
    public static final RegistryHelper HELPER = Fruitful.REGISTRY_HELPER;

    public static final RegistryObject<Item> APPLE_PIE = HELPER.createItem("apple_pie", ()->new Item(new Item.Properties().food(FruitfulFoods.APPLE_PIE).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PEACH = HELPER.createItem("peach", ()->new Item(new Item.Properties().food(FruitfulFoods.PEACH).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> PEACH_COBBLER = HELPER.createItem("peach_cobbler", ()->new SoupItem(new Item.Properties().food(FruitfulFoods.PEACH_COBBLER).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> ORANGE = HELPER.createItem("orange", ()->new Item(new Item.Properties().food(FruitfulFoods.ORANGE).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> ORANGE_JUICE = HELPER.createItem("orange_juice", ()->new OrangeJuiceItem(new Item.Properties().food(FruitfulFoods.ORANGE_JUICE).group(ItemGroup.FOOD)));
}
