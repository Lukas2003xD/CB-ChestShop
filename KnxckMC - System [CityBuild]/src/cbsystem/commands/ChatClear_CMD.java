package cbsystem.commands;

import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.chatclear") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 0) {
                    for (int i = 0; i < 105; i++) {
                        Bukkit.broadcastMessage(" ");
                    }
                    Bukkit.broadcastMessage(Main.getPrefix() + "§7Der §aChat §7wurde von §3§l" + p.getName() + "§a geleert.");
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
