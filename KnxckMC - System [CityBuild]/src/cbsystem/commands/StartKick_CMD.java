package cbsystem.commands;

import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class StartKick_CMD implements CommandExecutor {

    public static int ja;
    public static int nein;

    public static boolean isActive;

    public static HashMap<String, Integer> list = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("cbsystem.command.startkick") || p.hasPermission("cbsystem.command.*")) {
                if (args.length == 1) {
                    String name = args[0];

                    ja = 0;
                    nein = 0;
                    isActive = true;

                    Bukkit.broadcastMessage("§7[]§7§m------------§7[§cStart§4Kick§7]§7§m------------§7[]");
                    Bukkit.broadcastMessage("  §8» §7Gestartet von: §c" + p.getName());
                    Bukkit.broadcastMessage("  §8» §7Gekickt werden: §a" + name);
                    Bukkit.broadcastMessage("§7Stimme mit §a§lJa §7oder mit §c§lNein §7ab.");
                    Bukkit.broadcastMessage("§7[]§7§m------------§7[§cStart§4Kick§7]§7§m------------§7[]");

                    startTimer(name, p);
                }
                if (args.length == 0) {
                    if(args[0].equalsIgnoreCase("ja")) {
                        if(isActive) {
                            ja++;
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

    public void startTimer(String name, Player p) {
        list.put(name, 1);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                if(ja > nein) {
                    p.kickPlayer(name);
                } else {
                    list.remove(name);
                }
            }
        }, 3600L);
    }

}