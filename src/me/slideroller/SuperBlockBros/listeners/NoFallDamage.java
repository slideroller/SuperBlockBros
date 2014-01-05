package me.slideroller.SuperBlockBros.listeners;

import me.slideroller.SuperBlockBros.SuperBlockBros;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class NoFallDamage implements Listener {

	@SuppressWarnings("unused")
	private SuperBlockBros plugin;

	public NoFallDamage(SuperBlockBros plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (event.getCause() == DamageCause.FALL) {
			Player player = (Player) event.getEntity();
			if (player.isOp() || !(player.isOp())) {
				event.setCancelled(true);
			}
		}
	}
}
