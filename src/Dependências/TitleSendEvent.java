package Dependências;

import org.bukkit.entity.Player;

public class TitleSendEvent extends org.bukkit.event.Event {
	private static final org.bukkit.event.HandlerList handlers = new org.bukkit.event.HandlerList();
	private final Player player;
	private String title;
	private String subtitle;
	private boolean cancelled = false;

	public TitleSendEvent(Player player, String title, String subtitle) {
		this.player = player;
		this.title = title;
		this.subtitle = subtitle;
	}

	public static org.bukkit.event.HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public org.bukkit.event.HandlerList getHandlers() {
		return handlers;
	}

	public Player getPlayer() {
		return player;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
