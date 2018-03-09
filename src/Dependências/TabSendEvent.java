package Dependências;

import org.bukkit.entity.Player;

public class TabSendEvent extends org.bukkit.event.Event {
	private static final org.bukkit.event.HandlerList handlers = new org.bukkit.event.HandlerList();
	private final Player player;
	private String header;
	private String footer;
	private boolean cancelled = false;

	public TabSendEvent(Player player, String header, String footer) {
		this.player = player;
		this.header = header;
		this.footer = footer;
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
