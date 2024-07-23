package com.example.estrogenomicsmod.item;

import com.example.estrogenomicsmod.EstrogenomicsMod;
import com.example.estrogenomicsmod.creativetabs.ModCreativeTabs;
import com.example.estrogenomicsmod.custom.SentientItem;
import com.example.estrogenomicsmod.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EstrogenomicsMod.MODID);

    public static final RegistryObject<Item> GENDER_FLUID_BUCKET = registerItem("gender_fluid_bucket",() -> new BucketItem(ModFluids.SOURCE_GENDER_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> FIVE_DIMENSIONAL_MATRIX = registerItem("five_dimensional_matrix",() -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FOLDED_DIMENSION = registerItem("folded_dimension",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SENTIENT_COAL = registerItem("sentient_coal",() -> new SentientItem(new Item.Properties()));


    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item){
        return ModCreativeTabs.addToTab(ITEMS.register(name,item));
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
