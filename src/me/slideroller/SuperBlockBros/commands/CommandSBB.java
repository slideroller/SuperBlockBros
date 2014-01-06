package me.slideroller.SuperBlockBros.commands;

import me.slideroller.SuperBlockBros.SuperBlockBros;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSBB implements CommandExecutor {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("sbb"))
    {
      if (args.length == 0) {
    	  sender.sendMessage(ChatColor.BLUE + "Super Block Bros" + "Version: " + SuperBlockBros.instance.getDescription().getVersion() + ChatColor.GRAY + " by slideroller, StashCat, and abalalahaha");
    	  sender.sendMessage("Commands do not work!!!");
          sender.sendMessage("/sbb join <Game> - Join a game!");
          sender.sendMessage("/sbb leave - Leave a game!");
          sender.sendMessage("/sbb arena - Shows the arena setup!");
          sender.sendMessage("/sbb kits - Displays all the kits");
      }
      // Add command structures here with args
    }
	return false;
  }
}