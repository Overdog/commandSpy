package me.overdog.commandspy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.overdog.commandspy.Core;

public class CommandToggleSpy implements CommandExecutor
{
	private Core plugin = Core.plugin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	    if (!(sender instanceof Player)) 
	    {
	    	System.out.print("This command can only be used in game!");
		  return true;
	    }
	    
	    
	    Player player = (Player) sender;
	    
	    if (args.length == 0)
	    {
	    	if (!player.hasPermission("commandspy.toggle"))
	    	{
	    		player.sendMessage(ChatColor.RED + "You don't have proper permissions to use this command!");
	    		return true;
	    	}
	    	if (!plugin.playersWatchingLogs.contains(player.getName()))
	    	{
	    		plugin.playersWatchingLogs.add(player.getName());
	    		player.sendMessage(ChatColor.GREEN + "You can now see command logs!");
	    	} else
	    	{
	    		plugin.playersWatchingLogs.remove(player.getName());
	    		player.sendMessage(plugin.config.getString("You can no longer see command logs!"));
	    	}
	    }
		return true;
	  }
}
