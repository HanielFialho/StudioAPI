package Eventos;

import org.bukkit.event.player.PlayerJoinEvent;

public class JoinAndLeave implements org.bukkit.event.Listener {
	public JoinAndLeave() {
	}

	@org.bukkit.event.EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
	}

	@org.bukkit.event.EventHandler
	public void onPlayerLeave(org.bukkit.event.player.PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}
}
