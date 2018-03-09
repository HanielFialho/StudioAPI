package ComandosSimples;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Vida implements org.bukkit.command.CommandExecutor {
	public Vida() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("Vida")) || (!(sender instanceof Player))) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("SmiteAPI." + command.getName())) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			return true;
		}
		if (args.length == 0) {
			p.setHealth(20.0D);
			p.sendMessage("§eVocê foi curado.");
			return true;
		}
		if (args.length == 1) {
			Player p1 = org.bukkit.Bukkit.getPlayerExact(args[0]);
			if (p1 == null) {
				p.sendMessage("§cEste jogador não está on-line!");
				return true;
			}
			p1.setHealth(20.0D);
			p.sendMessage("§eVocê curou o jogador " + p1.getName() + "§e.");
		}
		return false;
	}
}
