package ComandosSimples;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Vanish implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener {

	public static ArrayList<String> vanish = new ArrayList<String>();

	@EventHandler
	public static void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (vanish.contains(p.getName())) {
			vanish.remove(p.getName());
		}
	}

	@EventHandler
	public static void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("StudioAPI.seevanish")) {
			for (Player todos : Bukkit.getOnlinePlayers()) {
				if (vanish.contains(todos.getName())) {
					p.showPlayer(todos);
				}
			}
			return;
		}
		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (vanish.contains(todos.getName())) {
				p.hidePlayer(todos);
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("vanish")) || (!(sender instanceof Player))) {
			sender.sendMessage("§cApenas jogadores in-game podem executar este comando.");
			return true;
		}
		if (!sender.hasPermission("StudioAPI." + command.getName())) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");

			return true;
		}
		Player p = (Player) sender;
		if (vanish.contains(p.getName())) {
			p.sendMessage("§cModo invisível desligado!");
			vanish.remove(p.getName());
			for (Player todos : Bukkit.getOnlinePlayers()) {
				todos.showPlayer(p);
			}
			return true;
		}
		vanish.add(p.getName());

		p.sendMessage("§aModo invisível ativado!");
		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (!todos.hasPermission("StudioAPI.vanish")) {
				todos.hidePlayer(p);
				return true;
			}
			todos.showPlayer(p);
		}
		return false;
	}
}
