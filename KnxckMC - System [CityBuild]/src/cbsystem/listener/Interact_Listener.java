package cbsystem.listener;

import cbsystem.api.KopfAPI;
import cbsystem.main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Interact_Listener implements Listener {

    @SuppressWarnings("static-access")
    @EventHandler
    public void onj(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        try {

            if (e.getItem() == null) {
                return;
            }

            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cItemCrate §8» §6Premium")) {
                p.setItemInHand(new ItemStack(Material.AIR));
                p.getInventory().addItem(new KopfAPI().createItem(Material.EXP_BOTTLE, null, 32, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.ENDER_PEARL, null, 2, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.DIAMOND, null, 1, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.BREAD, null, 20, 0));
                // 50 Coins hinzufügen

                p.sendMessage(Main.getPrefix() + "§7Du hast das §6Premium§7-§6Crate §a§nerfolgreich§r §7eingelöst!");
            }
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cItemCrate §8» §6Premium")) {
                p.setItemInHand(new ItemStack(Material.AIR));
                p.getInventory().addItem(new KopfAPI().createItem(Material.EXP_BOTTLE, null, 64, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.ENDER_PEARL, null, 4, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.DIAMOND, null, 5, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.BEACON, null, 1, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.BREAD, null, 20, 0));
                // 700 Coins hinzufügen

                p.sendMessage(Main.getPrefix() + "§7Du hast das §aKnock§7-§6Crate §a§nerfolgreich§r §7eingelöst!");
            }
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cItemCrate §8» §cLegende")) {
                p.setItemInHand(new ItemStack(Material.AIR));
                p.getInventory().addItem(new KopfAPI().createItem(Material.EXP_BOTTLE, null, 40, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.ENDER_PEARL, null, 4, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.DIAMOND, null, 10, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.BREAD, null, 20, 0));
                // 120 Coins hinzufügen

                p.sendMessage(Main.getPrefix() + "§7Du hast das §cLegende§7-§6Crate §a§nerfolgreich§r §7eingelöst!");
            }
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cItemCrate §8» §3Titan")) {
                p.setItemInHand(new ItemStack(Material.AIR));
                p.getInventory().addItem(new KopfAPI().createItem(Material.EXP_BOTTLE, null, 64, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.ENDER_PEARL, null, 6, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.DIAMOND, null, 15, 0));
                p.getInventory().addItem(new KopfAPI().createItem(Material.BREAD, null, 20, 0));
                // 450 Coins hinzufügen

                p.sendMessage(Main.getPrefix() + "§7Du hast das §cLegende§7-§6Crate §a§nerfolgreich§r §7eingelöst!");
            }

        } catch (NullPointerException e1) {
            // TODO: handle exception
        }
    }

}