package me.overdog.commandspy.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.overdog.commandspy.Core;

public class Notifier 
{
	private static Core plugin = Core.plugin;
	
	public static void alertPlayersWithPermission(String permission, String message)
	{
		for (Player p : Bukkit.getOnlinePlayers())
		{
			if (p.hasPermission(permission))
			{
				if (plugin.config.getBoolean("sound-on-alert"))
				{
					p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
				}
				p.sendMessage(message);
			}
		}
	}
}
