package com.example.estrogenomicsmod.creativetabs;

import com.example.estrogenomicsmod.EstrogenomicsMod;
import com.example.estrogenomicsmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EstrogenomicsMod.MODID);

    public static final List<Supplier<? extends ItemLike>> ESTROGENOMICS_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> ESTROGENOMICS_TAB = CREATIVE_MODE_TABS.register("estrogenomics_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.estrogenomics_tab"))
                    .icon(() -> ModItems.GENDER_FLUID_BUCKET.get().getDefaultInstance())
                    .displayItems((displayParams,output) ->{

                        ESTROGENOMICS_TAB_ITEMS.forEach(itemsLike -> output.accept(itemsLike.get()));

                    })
                    .build());

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike){
        ESTROGENOMICS_TAB_ITEMS.add(itemLike);
        return itemLike;

    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
