package cbsystem.commands;

import cbsystem.api.KopfAPI;
import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Kopf_CMD implements CommandExecutor {

    private static ArrayList<Player> kopf = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.kopf") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 1) {
                    String kopfInhaber = args[0];
                    if(p.getInventory().getItemInHand().getType() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
                        if(!kopf.contains(p)) {
                            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), KopfAPI.erschaffeKopf(kopfInhaber, "§7Kopf von §a" + kopfInhaber, null));
                            p.sendMessage(Main.getPrefix() + "§7Du hast dir §aerfolgreich §7den Kopf von §a" + kopfInhaber + " gegeben.");

                            kopf.add(p);
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {
                                    kopf.remove(p);
                                }
                            }, 12096000L);
                        } else {
                            p.sendMessage(Main.getPrefix() + "§cDu kannst den §e/kopf Befehl §cnur §aeinmal §cin der §aWoche §cbenutzen!");
                        }
                    } else {
                        p.sendMessage(Main.getPrefix() + "§cDer Slot ist besetzt, bitte entferne das Item auf dem Slot.");
                    }
                } else {
                    commandSender.sendMessage(Main.getPrefix() + "§cVerwendung: §e/kopf <name>");
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
