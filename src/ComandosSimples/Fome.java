package ComandosSimples;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Fome implements org.bukkit.command.CommandExecutor {
	public Fome() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("fome")) || (!(sender instanceof Player))) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("StudioAPI." + command.getName())) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			return true;
		}
		if (args.length == 0) {
			p.setFoodLevel(20);
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
			p.sendMessage("§eFome saciada.");
			return true;
		}
		if (args.length == 1) {
			Player p1 = org.bukkit.Bukkit.getPlayerExact(args[0]);
			if (p1 == null) {
				p.sendMessage("§cEste jogador não está on-line!");
				p.playSound(p.getLocation(), Sound.VILLAGER_YES, 2F, 1F);
				return true;
			}
			p1.setFoodLevel(20);
			p.playSound(p.getLocation(), Sound.VILLAGER_YES, 2F, 1F);
			p.sendMessage("§eVocê  saciou a fome do jogador " + p1.getName() + "§e.");
		}
		return false;
	}
}
