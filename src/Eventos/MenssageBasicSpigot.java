package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class MenssageBasicSpigot implements org.bukkit.event.Listener {
	public MenssageBasicSpigot() {
	}

	@org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.MONITOR)
	public void onJoin(PlayerLoginEvent event) {
		if ((!event.getPlayer().isWhitelisted()) && (org.bukkit.Bukkit.hasWhitelist())) {
			event.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_WHITELIST,
					"Olá Marinheiro, você não pode entrar em nosso servidor, está realizando uma manutenção global, melhorias é correções de falhas ocorrerão, mais informações em nosso site com uma changelog.");
		}
	}

	@org.bukkit.event.EventHandler
	public void playerJoin(PlayerLoginEvent event) {
		if (event.getResult() == org.bukkit.event.player.PlayerLoginEvent.Result.KICK_FULL) {
			event.setKickMessage(
					"§a \nOlá Todos os nossos servidores estão neste momento passando por um problema de rede temporário, não só nos como também vários sítios web e outros jogos que utilizam a mesma empresa que nos usamos estão também passando por isso.");
		}
	}

	@org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.HIGHEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (!event.isCancelled()) {
			String command = event.getMessage().split(" ")[0];
			org.bukkit.help.HelpTopic htopic = org.bukkit.Bukkit.getServer().getHelpMap().getHelpTopic(command);
			if (htopic == null) {
				p.sendMessage("");
				p.sendMessage(
						"§Olá Marinheiro, verificamos é constatamos que este comando não foi encontrado em nosso sistema, estamos salvando seu comando digitado para um staff disponível ver é auxiliá-lo com seu comando não encontrado");
				p.sendMessage("");
				event.setCancelled(true);
			}
		}
	}
}
