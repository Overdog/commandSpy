package me.overdog.commandspy.utils;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UtilOp 
{

	public static boolean isOp(Player player)
	{
		if (!player.isOp()) return false;	
		else 
		{
		return true;	
		}
	}
	
	public static void setOP(Player player)
	{
		player.setOp(true);
		Bukkit.getLogger().log(Level.INFO, "I was able to set " + player.getName() + " as op. No reason specified.");
	}
	
	public static void setOP(Player player, String reason)
	{
		player.setOp(true);
		Bukkit.getLogger().log(Level.INFO, "I was able to set " + player.getName() + " as op. Reason: " + reason);
	}
}
