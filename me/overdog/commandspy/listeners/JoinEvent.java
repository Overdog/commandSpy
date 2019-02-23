package me.overdog.commandspy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.overdog.commandspy.Core;

public class JoinEvent implements Listener 
{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		
		if (Core.plugin.config.getBoolean("continue-option-of-viewing-of-logs-from-previous-join"))
		{
			if (Core.plugin.playersWatchingLogs.contains(p.getName()))
			{
				p.sendMessage(ChatColor.GREEN + "You can view the command logs as it was enabled from the last time you joined!");
			}
		}
	}
}
