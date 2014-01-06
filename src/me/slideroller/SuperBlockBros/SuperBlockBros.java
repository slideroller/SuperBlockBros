package me.slideroller.SuperBlockBros;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import me.slideroller.SuperBlockBros.commands.CommandSBB;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SuperBlockBros extends JavaPlugin {

	public static SuperBlockBros instance;

	private static PluginManager pm = Bukkit.getPluginManager();
    private static Logger logger = Bukkit.getLogger();

	public void onDisable() {
		System.out.println("[SBB] Disabled!");
		}

	public void onEnable() {
		instance = this;

		getCommand("sbb").setExecutor(new CommandSBB());

        System.out.println("[SBB] Plugin enabled.");

		if(getWorldEdit() != null) {
			System.out.println("[SBB] WorldEdit found!");
		}

	}

	public static WorldEditPlugin getWorldEdit() {
		if(!pm.isPluginEnabled("WorldEdit")) {
			return null;
		} else {
			return (WorldEditPlugin) pm.getPlugin("WorldEdit");
		}
	}

}