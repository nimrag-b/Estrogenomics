package com.example.estrogenomicsmod.fluid;

import com.example.estrogenomicsmod.EstrogenomicsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation GENDERFLUID_OVERLAY_RL = new ResourceLocation(EstrogenomicsMod.MODID,"misc/in_gender_fluid");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES,EstrogenomicsMod.MODID);

    public static final RegistryObject<FluidType> GENDER_FLUID_TYPE = register("gender_fluid",FluidType.Properties.create().canDrown(true).canExtinguish(true).canPushEntity(true).canSwim(true).canConvertToSource(false).density(2).viscosity(4));

    private  static RegistryObject<FluidType> register(String name, FluidType.Properties properties){
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL,WATER_FLOWING_RL,GENDERFLUID_OVERLAY_RL,0xA1FCF0FB, new Vector3f(252f/255f, 240f/255f, 251f/255f),properties));
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
