package cbsystem.commands;

import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Globalmute_CMD implements CommandExecutor {

    public static boolean isGlobalMute;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.globalmute") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 0) {
                    if(isGlobalMute == true) {
                        isGlobalMute = false;
                        Bukkit.broadcastMessage(Main.getPrefix() + "§4Der Globalmute wurde §adeaktiviert!");
                    } else {
                        isGlobalMute = true;
                        Bukkit.broadcastMessage(Main.getPrefix() + "§4Der Globalmute wurde §caktiviert!");
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
