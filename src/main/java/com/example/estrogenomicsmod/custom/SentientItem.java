package com.example.estrogenomicsmod.custom;

import com.example.estrogenomicsmod.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jline.utils.Log;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SentientItem extends Item {
    public SentientItem(Properties properties) {
        super(properties);
    }

    Random rand = new Random();

    private int TickCountDown = -1;

    private void resetTimer(){
        try {
            TickCountDown = rand.nextInt(Config.minSentientItemTalkTicks,Config.maxSentientItemTalkTicks);
        }
        catch (Exception e){
            throw new RuntimeException(Config.minSentientItemTalkTicks + " : " +Config.maxSentientItemTalkTicks);
        }
        TickCountDown = rand.nextInt(0,500);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {

        if(TickCountDown < 0){
            resetTimer();
        }
        TickCountDown--;

        if(TickCountDown == 0){
            String message = Config.sentientItemLines.get(rand.nextInt(Config.sentientItemLines.size()));

            player.sendSystemMessage(Component.literal("<"+stack.getDisplayName().getString()+ "> " + message));

            resetTimer();
        }

        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }

    private static final List<String> ItemWhispers = Arrays.asList(
        "I'm Different.",
        "Hi!",
        "Nice to meet you!",
        "Nice Inventory",
        "Whatcha doing?"
    );
}
