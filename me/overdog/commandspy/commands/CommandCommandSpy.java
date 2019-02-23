package me.overdog.commandspy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.overdog.commandspy.Core;

public class CommandCommandSpy implements CommandExecutor
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
	    if (!player.hasPermission("commandspy.info")|| player.isOp())
	    {
	      player.sendMessage(ChatColor.RED + "You don't have proper permissions to use this command!");
	      return true;
	    }

	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "This plugin/CommandSpy was developed by Overdog! Please be sure to subscribe to him, it will be appreciated!");
	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "CommandSpy Commands"); 
	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "/commandspy - Sends this message. - commandspy.info");
	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "/togglespy - Toggles the command spy logs. - commandspy.toggle");
	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "/commandspy logs - Sends the last 50 commands sent by players. - commandspy.logs");
	    player.sendMessage(ChatColor.BLUE + "Information> " + ChatColor.GRAY + "To even be able to see logs, you must have commandspy.view.");
	    } else 
	    {
		    if (!player.hasPermission("commandspy.logs") || !player.isOp())
		    {
		      player.sendMessage(ChatColor.RED + "You don't have proper permissions to use this command!");
		      return true;
		    }
		    
		    if (args.length != 1)
		    {
		      player.sendMessage(ChatColor.RED + "Your arguments for this command are invalid! Do /commandspy logs");
		      return true;
		    }
		    
		    if (args[0].equalsIgnoreCase("logs"))
		    {
		    	for (Player uuid : plugin.commandsLogged.keySet())
		    	{
			    	for (String command : plugin.commandsLogged.values())
			    	{
		    for (int i = 0; i < plugin.commandsLogged.size(); i++)
		    {
		    	player.sendMessage(ChatColor.BLUE + "Log> " + ChatColor.GRAY + "Player "  + uuid.getName() + " (UUID: " + uuid.getUniqueId() + ") used " + command + ".");
		    	if (i >= 50 || i >= plugin.commandsLogged.size())
		    	{
		    		player.sendMessage(ChatColor.BLUE + "Log> " + ChatColor.GRAY + "Those are all of the commands I could find. Please check with your administrator for longer logs posted in the console if enabled in the configuration. I can't store more than 50 logs as I am limited to memory, and I want to make this as fast as possible.");
		    		return true;
		    	}    	
		    }
	    }
	  }
	}
  }
		return true;
}
}
