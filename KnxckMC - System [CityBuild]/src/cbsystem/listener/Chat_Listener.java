package cbsystem.listener;

import cbsystem.commands.Bold_CMD;
import cbsystem.commands.Globalmute_CMD;
import cbsystem.commands.SlowChat_CMD;
import cbsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat_Listener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        String message = e.getMessage();

        if(!SlowChat_CMD.usedChat.contains(p)) {
            if(SlowChat_CMD.slowChat == true) {

                SlowChat_CMD.usedChat.add(p);
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        SlowChat_CMD.usedChat.remove(p);
                    }
                }, 60L);

            }

        } else {
            p.sendMessage(Main.getPrefix() + "§e§lDu kannst nur alle §c§l3 Sekunden §e§lschreiben!");

            e.setCancelled(true);
            e.setMessage(null);

            return;
        }

        if(Globalmute_CMD.isGlobalMute == true) {
            if(p.hasPermission("cbsystem.bypass.globalmute") || p.hasPermission("cbsystem.bypass.*")) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
                e.setMessage(null);
                p.sendMessage(Main.getPrefix() + "§cDu kannst nicht schreiben, da momentan der Globalmute aktiv ist!");
            }
        }

        if(Bold_CMD.bold.contains(p)) {
            message = "§a§l" + e.getMessage().replaceAll("%", "Prozent");
        }

        if(p.hasPermission("rank.owner") || p.hasPermission("rank.*")) {
            e.setFormat("§4Owner §8● §4" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.admin")) {
            e.setFormat("§4Admin §8● §4" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.srdev")) {
            e.setFormat("§bSrDeveloper §8● §b" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.srmod")) {
            e.setFormat("§cSrModerator §8● §c" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.srsupp")) {
            e.setFormat("§9SrSupporter §8● §9" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.srbuilder")) {
            e.setFormat("§eSrBuilder §8● §e" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.dev")) {
            e.setFormat("§bDeveloper §8● §b" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.mod")) {
            e.setFormat("§cModerator §8● §c" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.supp")) {
            e.setFormat("§9Supporter §8● §9" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.admin")) {
            e.setFormat("§4Admin §8● §4" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.builder")) {
            e.setFormat("§eBuilder §8● §e" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.tdev")) {
            e.setFormat("§bTest-Developer §8● §b" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.tmod")) {
            e.setFormat("§cTest-Moderator §8● §c" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.tsupp")) {
            e.setFormat("§9Test-Supporter §8● §9" + p.getName() + " §8» §7" + message);
        } else if(p.hasPermission("rank.tbuilder")) {
            e.setFormat("§eTest-Builder §8● §e" + p.getName() + " §8» §7" + message);
        } else {
            e.setFormat("§7Spieler §8● §7" + p.getName() + " §8» §7" + message);
        }

    }

}
