package me.overdog.commandspy.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.overdog.commandspy.Core;
import me.overdog.commandspy.utils.LagDetection;

public class CommandPreprocessEvent implements Listener 
{
	private Core plugin = Core.plugin;
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) 
	{
		Player p = event.getPlayer();
		String command = event.getMessage();
		
	
		String finalString = ChatColor.BLUE + "Log> " + ChatColor.GRAY + "Player " + p.getName() + " used command " + command + ".";
		
		try 
		{
		plugin.commandsLogged.put(p, command);
		} catch (Exception e)
		{
		System.out.println("There seems to be an error with me being able to put commands in a list. Disabling feature! Please restart if you want the feature enabled.");
		}
			if (plugin.config.getBoolean("automatic-disable-ram"))
			{
				double memVariable = LagDetection.returnMemoryTotal() / 1.8;
				if (memVariable <= LagDetection.returnMemoryUsed())
				{
					try
					{
						plugin.limitedMode = true;
						System.out.print("It seems like we may be hogging up a bunch of memory! We've decided we'll be disabling some settings so we can run fast and easy! Check out your other plugins! You can disable this feature in the configuration.");
					} catch (Exception e)
					{
						System.out.println("I don't understand what is going on with this plugin, however, major erros are occuring. Please contact your administrator as the server is bugged.");
					}
				}
			}

		if (plugin.config.getBoolean("log-alerts-to-console"))
		{
			System.out.println("[COMMAND LOG] " + p.getName() + " used the command " + command + ".");
		}
		
		for (Player pl : Bukkit.getOnlinePlayers())
		{
			if (pl.hasPermission("commandspy.view") || pl.isOp())
			{
				if (plugin.playersWatchingLogs.contains(pl.getName()))
				{
				pl.sendMessage(ChatColor.translateAlternateColorCodes('&', finalString));
				}
			}
		}
	}
}  

