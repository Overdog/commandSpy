package me.overdog.commandspy;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.overdog.commandspy.commands.CommandCommandSpy;
import me.overdog.commandspy.commands.CommandToggleSpy;
import me.overdog.commandspy.listeners.CommandPreprocessEvent;
import me.overdog.commandspy.listeners.JoinEvent;
import me.overdog.commandspy.update.AutoUpdate;
 
public class Core extends JavaPlugin
{
	public static Core plugin;
	public FileConfiguration config = new YamlConfiguration();
	
	public ArrayList<String> playersWatchingLogs = new ArrayList<String>();
	public HashMap<Player, String> commandsLogged = new HashMap<Player, String>();
	
	public boolean limitedMode = false;
	private AutoUpdate updatechecker;
	public static String linkToResource = "https://www.spigotmc.org/resources/commandspy-watch-what-your-community-enters-and-prepare.65115/";
	@Override
	public void onEnable()
	{
		plugin = this;

		this.saveDefaultConfig();
		PluginManager pm = Bukkit.getPluginManager();
		if (config.getBoolean("disable-startup-message")) 
		{
		Bukkit.getLogger().log(Level.INFO, "Hello there! My name is Overdog and I developed InventoryViewer. This is an advertisement in your console. If you'd like, I can remove this message from your plugin, as it does get quite annoying.");
		Bukkit.getLogger().log(Level.INFO, "Taking time away from server development may seem bad, however, just a quick minute of your time will help me. No cash required.");
		Bukkit.getLogger().log(Level.INFO, "I own a Youtube channel named Overdog. I used to upload content, however view counts slowed. If you could just spend a minute and subscribe to me, it will be appreciated.");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Channel Link: https://www.youtube.com/c/overdog");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Thank you for your time. Now, let me start your plugin.");
		}
		pm.registerEvents(new CommandPreprocessEvent(), this);
		pm.registerEvents(new JoinEvent(), this);
        getCommand("commandspy").setExecutor(new CommandCommandSpy());
        getCommand("togglespy").setExecutor(new CommandToggleSpy());
        
        //Included in basic core. Required for ALL plugins.
		updatechecker = new AutoUpdate(this);
		updatechecker.startUpdateCheck();
	}
 
	@Override
	public void onDisable()
	{
		if (config.getBoolean("disable-startup-message")) 
		{
		Bukkit.getLogger().log(Level.INFO, "Hello there! My name is Overdog and I developed InventoryViewer. This is an advertisement in your console. If you'd like, I can remove this message from your plugin, as it does get quite annoying.");
		Bukkit.getLogger().log(Level.INFO, "Taking time away from server development may seem bad, however, just a quick minute of your time will help me. No cash required.");
		Bukkit.getLogger().log(Level.INFO, "I own a Youtube channel named Overdog. I used to upload content, however view counts slowed. If you could just spend a minute and subscribe to me, it will be appreciated.");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Channel Link: https://www.youtube.com/c/overdog");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Thank you for your time. Now, let me stop your plugin.");
		}
		commandsLogged.clear();
		playersWatchingLogs.clear();
		limitedMode = false;
	}
}