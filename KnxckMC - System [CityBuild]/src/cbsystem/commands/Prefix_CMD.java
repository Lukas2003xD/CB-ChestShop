package cbsystem.commands;

import cbsystem.api.KopfAPI;
import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Prefix_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.prefix") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 0) {
                    Inventory inv = Bukkit.createInventory(null, 1*9, "§cWähle einen Prefix!");

                    inv.setItem(0, KopfAPI.createItem(Material.STAINED_GLASS_PANE, "§8» §cRoter Prefix", null, 1, 14));
                    inv.setItem(1, KopfAPI.createItem(Material.STAINED_GLASS_PANE, "§8» §aGrüner Prefix", null, 1, 5));
                    inv.setItem(2, KopfAPI.createItem(Material.STAINED_GLASS_PANE, "§8» §9Blauer Prefix", null, 1, 11));
                    inv.setItem(3, KopfAPI.createItem(Material.STAINED_GLASS_PANE, "§8» §dPinker Prefix", null, 1, 10));


                    inv.setItem(8, KopfAPI.createItem(Material.BARRIER, "§8» §4Prefix entfernen", null, 1, 10));
                    p.openInventory(inv);
                }
            } else {
                commandSender.sendMessage(Main.getNoPerms());
            }
        } else {
            commandSender.sendMessage(Main.getInst());
        }
        return false;
    }

}
