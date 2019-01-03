package cbsystem.main;

import cbsystem.commands.*;
import cbsystem.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import scoreboardapi.utils.ScoreboardAPI;

public class Main extends JavaPlugin {

    final static String prefix = "§7» §cCityBuild §8● ";
    final static String noPerms = getPrefix() + "§7Dazu hast du §c§nkeine§r §7Rechte!";
    final static String inst = "Instanzfehler: DU MUSST EIN SPIELER SEIN!";
    final static String use = getPrefix() + "§cVerwende §7» §c/";

    private static Main instance;

    public void onEnable() {
        init();

        instance = this;

        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aDas Plugin wurde erfolgreich gestartet!");

    }

    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§cDas Plugin wurde erfolgreich gestoppt!");

    }

    private void init() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new Chat_Listener(), this);
        pm.registerEvents(new DupePatch_Listener(), this);
        pm.registerEvents(new Interact_Listener(), this);
        pm.registerEvents(new Click_Listener(), this);
        pm.registerEvents(new Join_Listener(), this);

        getCommand("slowchat").setExecutor(new SlowChat_CMD());
        getCommand("bold").setExecutor(new Bold_CMD());
        getCommand("kopf").setExecutor(new Kopf_CMD());
        getCommand("globalmute").setExecutor(new Globalmute_CMD());
        getCommand("cc").setExecutor(new ChatClear_CMD());
        getCommand("itemcrate").setExecutor(new ItemCrates_CMD());
        getCommand("prefix").setExecutor(new Prefix_CMD());
        getCommand("startkick").setExecutor(new StartKick_CMD());
        getCommand("ja").setExecutor(new StartKick_CMD());
    }

    public static String getPrefix() {
        return prefix;
    }

    public static Main getInstance() {
        return instance;
    }

    public static String getNoPerms() {
        return noPerms;
    }

    public static String getInst() {
        return inst;
    }

}
