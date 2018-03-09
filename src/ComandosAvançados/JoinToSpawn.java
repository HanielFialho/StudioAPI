package ComandosAvançados;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class JoinToSpawn implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.performCommand("warp spawn");
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("§eVocê respawnou em um local seguro.");
		p.sendMessage("");
		p.sendMessage("");
		p.performCommand("warp spawn");
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onEntityDamageEvent(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		DamageCause cause = event.getCause();

		if (entity instanceof Player) {
			Player player = (Player) entity;
			World world = player.getWorld();
			Location location = world.getSpawnLocation();

			if (cause == EntityDamageEvent.DamageCause.VOID) {
				player.teleport(location);
				event.setCancelled(true);
				player.performCommand("warp spawn");
			}
		}
	}
}
