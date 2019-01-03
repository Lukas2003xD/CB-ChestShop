package cbsystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import scoreboardapi.utils.ScoreboardAPI;

public class Join_Listener implements Listener {

    @EventHandler
    public void onJoi(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(null);

        if(p.hasPermission("system.rank.owner") || p.hasPermission("system.rank.*")) {
            ScoreboardAPI.setDefaultPrefix(p, "Owner");
        } else if(p.hasPermission("system.rank.admin")) {
//            ScoreboardAPI.setDefaultPrefix(p, "Admin");
        }

    }

}
