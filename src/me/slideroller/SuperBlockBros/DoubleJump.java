package me.slideroller.SuperBlockBros;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.Bukkit;
import org.bukkit.Effect;

public class DoubleJump implements Listener {

	private SuperBlockBros plugin;
	private List<String> justJumped = new ArrayList<String>();

	public DoubleJump(SuperBlockBros instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
			player.setAllowFlight(true);
			justJumped.remove(player.getName());
		}
	

	@EventHandler
	public void setFlyOnJump(PlayerToggleFlightEvent event) {
		if (event.isFlying() && event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            Player player = event.getPlayer();
            final String name = player.getName();

            boolean messageOnJump = plugin.getConfig().getBoolean("jump.message");
            boolean sound = plugin.getConfig().getBoolean("jump.sound");
            boolean effect = plugin.getConfig().getBoolean("jump.effect");
            boolean wallJump = plugin.getConfig().getBoolean("jump.wall");
            boolean forwardOnJump = plugin.getConfig().getBoolean("jump.forward");
            int blocks = plugin.getConfig().getInt("jump.height");
            int interval = plugin.getConfig().getInt("jump.interval");
            if (!justJumped.contains(name)) {
                player.setFlying(false);

                if (forwardOnJump) {
                    player.setVelocity((player.getVelocity().multiply(1).setY(0.17 * blocks)).add((player.getLocation().getDirection().multiply(0.5))));
                } else {
                    player.setVelocity(player.getVelocity().multiply(1).setY(0.17 * blocks));
                }

                player.setAllowFlight(false);

                if (sound) {
                    player.playSound(player.getLocation(),Sound.IRONGOLEM_THROW, 10, -10);
                }

                if (effect) {
                    for (int i = 0; i <= 10; i++) {
                        player.getWorld().playEffect(player.getLocation(),Effect.SMOKE, i);
                    }
                }

                Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){public void run(){removeJumped(name);}}, ((interval*20)+1));

            } else {
                player.setFlying(false);
                player.setAllowFlight(false);

            }
            event.setCancelled(true);
		}
	}

	public void removeJumped(String name) {
		justJumped.remove(name);
	}
}
