package me.slideroller.SuperBlockBros;

import me.slideroller.SuperBlockBros.commands.CommandSBB;
import me.slideroller.SuperBlockBros.spectate.GhostFactory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class SuperBlockBros extends JavaPlugin {

	public static SuperBlockBros instance;

	public GhostFactory ghostFactory;

	private static PluginManager pm = Bukkit.getPluginManager();

	public void onDisable() {
		System.out.println("[SBB] Disabled!");
		}

	public void onEnable() {
		instance = this;

		getCommand("sbb").setExecutor(new CommandSBB());
		
		this.ghostFactory = new GhostFactory(this, true);

		if(getWorldEdit() != null) {
			System.out.println("[SBB] Plugin enabled. WorldEdit found!");
		} else {
			System.out.println("[SBB] Plugin enabled.");
		}

	}

	public static WorldEditPlugin getWorldEdit() {
		if(!pm.isPluginEnabled("WorldEdit")) {
			return null;
		} else {
			return (WorldEditPlugin) pm.getPlugin("WorldEdit");
		}
	}

	public void sendMessage(Player sender, String string) {
		
	}

}