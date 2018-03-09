package ComandosSimples;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Suicidio implements org.bukkit.command.CommandExecutor {
	public Suicidio() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("kill"))
				|| (!sender.hasPermission("StudioAPI." + command.getName()))) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			return true;
		}
		if (args.length == 0) {
			Player p = (Player) sender;
			p.setHealth(0.0D);
			p.sendMessage("§aVocê se matou! Diga Não Aõ Suicidio");
			return true;
		}
		if (args.length == 1) {
			Player p = (Player) sender;
			Player p1 = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
			if (p1 == null) {
				p.sendMessage("§cEste jogador não está on-line!");
				return true;
			}
			p1.setHealth(0.0D);
			p.sendMessage("§a" + p1.getName() + " morreu!");
		}
		return false;
	}
}
