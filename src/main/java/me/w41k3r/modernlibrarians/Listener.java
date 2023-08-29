package me.w41k3r.modernlibrarians;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

import static me.w41k3r.modernlibrarians.ModernLibrarians.plugin;
import static org.bukkit.Bukkit.getLogger;

public class Listener implements org.bukkit.event.Listener {
    Enchantment specialEnchantment = null;

    Random random = new Random();



    @EventHandler
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {



        Villager villager = (Villager) event.getEntity();

        ItemStack result = event.getRecipe().getResult();
        if(!villager.getProfession().equals(Villager.Profession.LIBRARIAN)) return;

        if (villager.getVillagerLevel() == 5){

            new BukkitRunnable() {
                @Override
                public void run() {
                    special(villager);
                }
            }.runTaskLater(plugin, 10);
    }


        if(!(result.getType().equals(Material.ENCHANTED_BOOK))){
            return;
        }


        List<Enchantment> enchantmentList = null;

//        getLogger().info("Running modifier at: " + event.getEntity().getLocation().getBlockX() + ", " + event.getEntity().getLocation().getBlockY() + ", " + event.getEntity().getLocation().getBlockZ());

        String type = "";
        switch (villager.getVillagerType()) {
            case DESERT:
                type = "Desert";
                enchantmentList = EnchantmentLists.DESERT_NORMAL_ENCHANTMENTS;
                break;
            case JUNGLE:
                type = "Junlge";
                enchantmentList = EnchantmentLists.JUNGLE_NORMAL_ENCHANTMENTS;
                break;
            case PLAINS:
                type = "Plains";
                enchantmentList = EnchantmentLists.PLAINS_NORMAL_ENCHANTMENTS;
                break;
            case SAVANNA:
                type = "Savanna";
                enchantmentList = EnchantmentLists.SAVANNA_NORMAL_ENCHANTMENTS;
                break;
            case SNOW:
                type = "Snow";
                enchantmentList = EnchantmentLists.SNOW_NORMAL_ENCHANTMENTS;
                break;
            case SWAMP:
                type = "Swamp";
                enchantmentList = EnchantmentLists.SWAMP_NORMAL_ENCHANTMENTS;
                break;
            case TAIGA:
                type = "Taiga";
                enchantmentList = EnchantmentLists.TAIGA_NORMAL_ENCHANTMENTS;
                break;
            default:
                getLogger().info("Villager Type Error. Contact plugin Author! Villager Type:" + villager.getVillagerType());
        }

        if (enchantmentList != null) {
            limit(villager, result, event, enchantmentList, type);
        }
    }


    private void limit(Villager villager, ItemStack result, VillagerAcquireTradeEvent event, List<Enchantment> NormalEnchantments, String s) {
        List<Enchantment> allowedEnchantments = NormalEnchantments;

        for (Enchantment allowedEnchantment : allowedEnchantments) {
            if (result.containsEnchantment(allowedEnchantment)) {
                return; // Return if any allowed enchantment is found
            }
        }

        Enchantment randomEnchantment = allowedEnchantments.get(random.nextInt(allowedEnchantments.size()));
        int randomLevel = random.nextInt(randomEnchantment.getMaxLevel()) + 1;
        randomLevel = Math.min(randomLevel, randomEnchantment.getMaxLevel());

        ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) newBook.getItemMeta();
        meta.addStoredEnchant(randomEnchantment, randomLevel, true);
        newBook.setItemMeta(meta);

        event.setCancelled(true);

        // Calculate the new experience for the villager
        MerchantRecipe newTrade = new MerchantRecipe(newBook, 0, event.getRecipe().getMaxUses(),true, event.getRecipe().getVillagerExperience(), event.getRecipe().getPriceMultiplier(), event.getRecipe().getDemand(), event.getRecipe().getSpecialPrice());

        for (ItemStack ingredient : event.getRecipe().getIngredients()) {
            newTrade.addIngredient(ingredient);
        }

        List<MerchantRecipe> updatedRecipes = new ArrayList<>(villager.getRecipes());
        updatedRecipes.add(newTrade);
        villager.setRecipes(updatedRecipes);


//        getLogger().info("Librarian Modified at: " + event.getEntity().getLocation().getBlockX() + ", " + event.getEntity().getLocation().getBlockY() + ", " + event.getEntity().getLocation().getBlockZ() + " with " + randomEnchantment);

    }
    

    //-------------------------------------------------------------
    //-------------------------------------------------------------
    //-------------------------------------------------------------


    private void special(Villager villager) {
        int enchantmentLevel;
        switch (villager.getVillagerType()) {
            case DESERT:
                enchantmentLevel = 3;
                specialEnchantment = EnchantmentLists.DESERT_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case JUNGLE:
                enchantmentLevel = 2;
                specialEnchantment = EnchantmentLists.JUNGLE_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case PLAINS:
                enchantmentLevel = 3;
                specialEnchantment = EnchantmentLists.PLAINS_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case SAVANNA:
                enchantmentLevel = 3;
                specialEnchantment = EnchantmentLists.SAVANNA_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case SNOW:
                enchantmentLevel = 1;
                specialEnchantment = EnchantmentLists.SNOW_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case SWAMP:
                enchantmentLevel = 1;
                specialEnchantment = EnchantmentLists.SWAMP_SPECIAL_ENCHANTMENTS.get(0);
                break;
            case TAIGA:
                enchantmentLevel = 2;
                specialEnchantment = EnchantmentLists.TAIGA_SPECIAL_ENCHANTMENTS.get(0);
                break;
            default:
                enchantmentLevel = 1;
                getLogger().info("Villager Type Error. Contact plugin Author! Villager Type:" + villager.getVillagerType());
        }






        int min,max;
        if(specialEnchantment.equals(Enchantment.MENDING)){
            min = 8;
            max = 41;
        }
        else {
            switch (enchantmentLevel){
                case 1:
                    min = 5;
                    max = 20;
                    break;
                case 2:
                    min = 8;
                    max = 33;
                    break;
                case 3:
                    min = 11;
                    max = 46;
                    break;
                case 4:
                    min = 14;
                    max = 60;
                    break;
                case 5:
                    min = 17;
                    max = 65;
                    break;
                default:
                    min = 17;
                    max = 72;
            }
        }



        int price = random.nextInt(max-min) + min;
        ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) newBook.getItemMeta();
        meta.addStoredEnchant(specialEnchantment, enchantmentLevel, true);
        newBook.setItemMeta(meta);
        MerchantRecipe recipe = new MerchantRecipe(newBook, 0, 12, true, 30, 0.2F);


        ItemStack emeralds = new ItemStack(Material.EMERALD, price);
        ItemStack book = new ItemStack(Material.BOOK);
        recipe.addIngredient(emeralds);
        recipe.addIngredient(book);

        List<MerchantRecipe> updatedRecipes = new ArrayList<>(villager.getRecipes());
        updatedRecipes.add(recipe);
        villager.setRecipes(updatedRecipes);
    }

}
