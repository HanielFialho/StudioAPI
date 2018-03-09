package Eventos;

import org.bukkit.event.weather.WeatherChangeEvent;

public class Clime implements org.bukkit.event.Listener {
	public Clime() {
	}

	@org.bukkit.event.EventHandler
	public void Mudançadeclima(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
}
