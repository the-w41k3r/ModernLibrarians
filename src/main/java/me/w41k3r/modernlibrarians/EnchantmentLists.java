package me.w41k3r.modernlibrarians;
import org.bukkit.enchantments.Enchantment;
import java.util.Arrays;
import java.util.List;

public class EnchantmentLists {
    // Enchantment lists for each biome and trade category
    public static final List<Enchantment> DESERT_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.PROTECTION_FIRE, Enchantment.THORNS, Enchantment.ARROW_INFINITE
    );

    public static final List<Enchantment> DESERT_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.DIG_SPEED
    );

    public static final List<Enchantment> JUNGLE_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.ARROW_DAMAGE, Enchantment.PROTECTION_PROJECTILE, Enchantment.PROTECTION_FALL
    );

    public static final List<Enchantment> JUNGLE_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.DURABILITY
    );

    public static final List<Enchantment> PLAINS_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.ARROW_KNOCKBACK, Enchantment.DAMAGE_ARTHROPODS, Enchantment.DAMAGE_UNDEAD
    );

    public static final List<Enchantment> PLAINS_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.PROTECTION_ENVIRONMENTAL
    );

    public static final List<Enchantment> SAVANNA_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.KNOCKBACK, Enchantment.BINDING_CURSE, Enchantment.SWEEPING_EDGE
    );

    public static final List<Enchantment> SAVANNA_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.DAMAGE_ALL
    );

    public static final List<Enchantment> SNOW_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.WATER_WORKER, Enchantment.LOOT_BONUS_MOBS, Enchantment.FROST_WALKER
    );

    public static final List<Enchantment> SNOW_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.SILK_TOUCH
    );

    public static final List<Enchantment> SWAMP_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.DEPTH_STRIDER, Enchantment.OXYGEN, Enchantment.VANISHING_CURSE
    );

    public static final List<Enchantment> SWAMP_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.MENDING
    );

    public static final List<Enchantment> TAIGA_NORMAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.PROTECTION_EXPLOSIONS, Enchantment.FIRE_ASPECT, Enchantment.ARROW_FIRE
    );

    public static final List<Enchantment> TAIGA_SPECIAL_ENCHANTMENTS = Arrays.asList(
            Enchantment.LOOT_BONUS_BLOCKS
    );
}
