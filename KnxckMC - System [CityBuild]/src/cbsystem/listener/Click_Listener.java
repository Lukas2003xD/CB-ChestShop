package cbsystem.listener;

import cbsystem.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import scoreboardapi.utils.ScoreboardAPI;

public class Click_Listener implements Listener {

    @EventHandler
    public void onCl(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) {
            return;
        }

        if (e.getInventory().getName().equalsIgnoreCase("§cWähle einen Prefix!")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cRoter Prefix")) {
                p.sendMessage(Main.getPrefix() + "§7Du hast nun einen §cRoten Prefix.");
                ScoreboardAPI.setDefaultPrefix(p, "rot");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aGrüner Prefix")) {
                p.sendMessage(Main.getPrefix() + "§7Du hast nun einen §aGrünen Prefix.");
                ScoreboardAPI.setDefaultPrefix(p, "grüner");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9Blauer Prefix")) {
                p.sendMessage(Main.getPrefix() + "§7Du hast nun einen §9blauen Prefix.");
                ScoreboardAPI.setDefaultPrefix(p, "BlauerPrefix");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §dPinker Prefix")) {
                p.sendMessage(Main.getPrefix() + "§7Du hast nun einen §dpinken Prefix.");
                ScoreboardAPI.setDefaultPrefix(p, "PinkerPrefix");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §4Prefix entfernen")) {
                p.closeInventory();
                ScoreboardAPI.setDefaultPrefix(p, "null");
            }
        }
    }
}