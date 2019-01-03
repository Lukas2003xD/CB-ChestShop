package cbsystem.commands;

import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import scoreboardapi.utils.ScoreboardAPI;

import java.util.ArrayList;

public class SlowChat_CMD implements CommandExecutor {

    public static ArrayList<Player> usedChat = new ArrayList();
    public static ArrayList<Player> usedSlowChat = new ArrayList();

    public static boolean slowChat = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.commands.slowchat") || p.hasPermission("cbsystem.commands.*")) {
                if (args.length == 0) {

                    if (usedSlowChat.contains(p))
                    {
                        p.sendMessage(Main.getPrefix() + "§cDu kannst diesen Befehl nur alle 30 Minuten benutzen!");
                        return false;
                    }

                    if (slowChat == true) {
                        slowChat = false;
                        Bukkit.broadcastMessage("§7§lDer §c§lSlowChat §7§lwurde von §c§l" + p.getName() + " §c§ldeaktiviert!");
                    } else {
                        slowChat = true;
                        Bukkit.broadcastMessage("§7§lDer §c§lSlowChat §7§lwurde von §c§l" + p.getName() + " §a§laktiviert!");
                    }
                    usedSlowChat.add(p);
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        public void run() {
                            usedSlowChat.remove(p);
                        }
                    }, 36000L);

                }
            } else {
                commandSender.sendMessage(Main.getNoPerms());
            }
        } else

        {
            commandSender.sendMessage(Main.getInst());
        }
        return false;
    }

}
