package cbsystem.api;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class KopfAPI {

    public static ItemStack erschaffeKopf(String kopfInhaber, String ItemName, String lor) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        skullMeta.setOwner(kopfInhaber);
        skullMeta.setDisplayName(ItemName);
        skull.setItemMeta(skullMeta);
        return skull;
    }

    public static ItemStack createItem(Material Material, String name, int anzahl, int nebenID) {
        ItemStack is = new ItemStack(Material, (short) nebenID);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setAmount(anzahl);
        is.setItemMeta(im);

        return is;
    }

    public static ItemStack createItem(Material m, String name, String lore, int anzahl, int nebenID) {
        ItemStack is = new ItemStack(m, anzahl, (short) nebenID);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(Arrays.asList(lore));
        is.setAmount(anzahl);
        is.setItemMeta(im);

        return is;

    }

}
