package Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class AntiTab implements Listener {

	@EventHandler
	public void AntiChatTab(PlayerChatTabCompleteEvent e) {
		e.getChatMessage().charAt(0);
		e.getTabCompletions().clear();
		e.getLastToken().charAt(0);
	}

}