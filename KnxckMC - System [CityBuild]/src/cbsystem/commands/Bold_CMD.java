package cbsystem.commands;

import cbsystem.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Bold_CMD implements CommandExecutor {

    public static ArrayList<Player> bold = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.bold") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 0) {
                    if(!bold.contains(p)) {
                        bold.add(p);
                        p.sendMessage(Main.getPrefix() + "§7Du §aschreibst §7nun §a§ldick!");
                    } else {
                        bold.remove(p);
                        p.sendMessage(Main.getPrefix() + "§7Du §cschreibst §7nun §c§lnicht mehr dick!");
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
