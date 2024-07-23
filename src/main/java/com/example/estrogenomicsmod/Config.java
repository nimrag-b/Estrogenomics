package com.example.estrogenomicsmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = EstrogenomicsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue MIN_SENTIENT_ITEM_TALK_TICKS = BUILDER
            .comment("Minimum ticks before a Sentient item talks.")
            .defineInRange("minSentientItemTalkTicks", 1200, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue MAX_SENTIENT_ITEM_TALK_TICKS = BUILDER
            .comment("Maximum ticks before a Sentient item talks.")
            .defineInRange("maxSentientItemTalkTicks", 10000, 0, Integer.MAX_VALUE);

    // a list of strings that are treated as resource locations for items
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> SENTIENT_ITEM_LINES = BUILDER
            .comment("A list of lines for sentient items to choose from.")
            .defineListAllowEmpty("sentientItemLines", List.of(
                    "I'm Different.",
                    "Hi!",
                    "Nice to meet you!",
                    "Nice Inventory!",
                    "Whatcha doing?"),
                    Config::validateItemName);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int minSentientItemTalkTicks;
    public static int maxSentientItemTalkTicks;
    public static List<String> sentientItemLines;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        minSentientItemTalkTicks = MIN_SENTIENT_ITEM_TALK_TICKS.get();
        maxSentientItemTalkTicks = MAX_SENTIENT_ITEM_TALK_TICKS.get();

        sentientItemLines = new ArrayList<>(SENTIENT_ITEM_LINES.get());
    }
}
