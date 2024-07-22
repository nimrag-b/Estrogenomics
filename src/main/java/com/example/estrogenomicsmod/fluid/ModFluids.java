package com.example.estrogenomicsmod.fluid;

import com.example.estrogenomicsmod.EstrogenomicsMod;
import com.example.estrogenomicsmod.block.ModBlocks;
import com.example.estrogenomicsmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, EstrogenomicsMod.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_GENDER_FLUID = FLUIDS.register("gender_fluid",() -> new ForgeFlowingFluid.Source(ModFluids.GENDER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_GENDER_FLUID = FLUIDS.register("flowing_gender_fluid",() -> new ForgeFlowingFluid.Flowing(ModFluids.GENDER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties GENDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.GENDER_FLUID_TYPE,SOURCE_GENDER_FLUID,FLOWING_GENDER_FLUID).block(ModBlocks.GENDER_FLUID_BLOCK).bucket(ModItems.GENDER_FLUID_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
