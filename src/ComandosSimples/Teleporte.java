package ComandosSimples;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleporte implements org.bukkit.command.CommandExecutor {
	public Teleporte() {
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("tp")) || (!(sender instanceof Player))) {
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
			sender.sendMessage("§cUtilize /tp <jogador> para teleportar para um jogador.");
		}
		if (args.length == 1) {
			Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
			if (p1 == null) {
				sender.sendMessage("§cEste jogador não está on-line!");
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
				return true;
			}
			if (p1.getName() == p.getName()) {
				p.sendMessage("§cVocê não pode se teleportar para si mesmo.");
				return true;
			}
			p.teleport(p1);

			p.sendMessage("§a" + p.getName() + " foi teleportado para " + p1.getName() + ".");
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
			return true;
		}
		if (args.length == 2) {
			Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
			if (p1 == null) {
				sender.sendMessage("§cEste jogador não está on-line!");
				return true;
			}
			Player p2 = org.bukkit.Bukkit.getPlayer(args[1]);
			if (p2 == null) {
				sender.sendMessage("§cEste jogador não está on-line!");
				return true;
			}
			if (p1.getName() == p2.getName()) {
				p.sendMessage("§cVocê não pode se teleportar para si mesmo.");
				return true;
			}
			Player send = (Player) sender;

			String player1 = p1.getName();
			String player2 = p2.getName();

			p1.teleport(p2);
			if (Vanish.vanish.contains(p2.getName())) {
				send.sendMessage("§a" + player1 + " foi teleportado para " + player2 + ".");

				return true;
			}
			send.sendMessage("§a" + player1 + " foi teleportado para " + player2 + ".");
			p1.sendMessage("§aTeleportado para " + p2.getName() + ".");
		}
		return false;
	}
}
