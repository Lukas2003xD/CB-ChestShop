package cbsystem.commands;

import cbsystem.api.KopfAPI;
import cbsystem.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCrates_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("Lottery.createKey") || p.hasPermission("Lottery.*")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("premium")) {
                        if (p.getInventory().getItemInHand().getType() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
                            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), KopfAPI.erschaffeKopf("MHF_Chest", "§cItemCrate §8» §6Premium", null));
                            p.sendMessage(Main.getPrefix() + "§7Du hast das §6Premium§7-§6Crate §a§nerfolgreich§r §7erhalten!");
                        }
                    } else if (args[0].equalsIgnoreCase("legende")) {
                        if (p.getInventory().getItemInHand().getType() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
                            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), KopfAPI.erschaffeKopf("MHF_Chest", "§cItemCrate §8» §cLegende", null));
                            p.sendMessage(Main.getPrefix() + "§7Du hast das §cLegende§7-§6Crate §a§nerfolgreich§r §7erhalten!");
                        }
                    } else if (args[0].equalsIgnoreCase("titan")) {
                        if (p.getInventory().getItemInHand().getType() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
                            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), KopfAPI.erschaffeKopf("MHF_Chest", "§cItemCrate §8» §3Titan", null));
                            p.sendMessage(Main.getPrefix() + "§7Du hast das §3Titan§7-§6Crate §a§nerfolgreich§r §7erhalten!");
                        }
                    } else if (args[0].equalsIgnoreCase("knock")) {
                        if (p.getInventory().getItemInHand().getType() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
                            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), KopfAPI.erschaffeKopf("MHF_Chest", "§cItemCrate §8» §aKnock", null));
                            p.sendMessage(Main.getPrefix() + "§7Du hast das §aKnock§7-§6Crate §a§nerfolgreich§r §7erhalten!");
                        }
                    }
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