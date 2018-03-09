package ComandosSimples;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ModoDeJogo implements org.bukkit.command.CommandExecutor {
	public ModoDeJogo() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gamemode")) {
			if (!p.hasPermission("StudioAPI." + cmd.getName())) {
				sender.sendMessage(
						"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§cUtilize /gamemode <modo> para alterar seu modo de jogo.");
				return true;
			}
			if (args.length >= 1) {
				String gm = args[0];
				if ((gm.equalsIgnoreCase("0")) || (gm.equalsIgnoreCase("survival"))) {
					if (args.length == 2) {
						if (!p.hasPermission("StudioAPI.gmpass")) {
							p.sendMessage(
									"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");

							return true;
						}
						Player p1 = Bukkit.getPlayer(args[1]);
						if (p1 == null) {
							p.sendMessage("§cEste jogador não foi encontrado.");
							return true;
						}
						p1.setGameMode(GameMode.SURVIVAL);
						p1.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
						p.sendMessage("§aModo de jogo do jogador " + p1.getName() + ", foi alterado para "
								+ p1.getGameMode() + ".");
					} else {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
					}
				}
				if ((gm.equalsIgnoreCase("1")) || (gm.equalsIgnoreCase("criativo"))) {
					if (!p.hasPermission("StudioAPI.gmpass")) {
						p.sendMessage(
								"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");

						return true;
					}
					if (args.length == 2) {
						Player p1 = Bukkit.getPlayer(args[1]);
						if (p1 == null) {
							p.sendMessage("§cEste jogador não foi encontrado!");
							return true;
						}
						p1.setGameMode(GameMode.CREATIVE);
						p1.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
						p.sendMessage("§aModo de jogo do jogador " + p1.getName() + ", foi alterado para "
								+ p1.getGameMode() + ".");
					} else {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
					}
				}
				if ((gm.equalsIgnoreCase("2")) || (gm.equalsIgnoreCase("adventure"))) {
					if (!p.hasPermission("StudioAPI.gmpass")) {
						p.sendMessage(
								"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");

						return true;
					}
					if (args.length == 2) {
						Player p1 = Bukkit.getPlayer(args[1]);
						if (p1 == null) {
							p.sendMessage("§cEste jogador não foi encontrado!");
							return true;
						}
						p1.setGameMode(GameMode.ADVENTURE);
						p1.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
						p.sendMessage("§aModo de jogo do jogador " + p1.getName() + ", foi alterado para "
								+ p1.getGameMode() + ".");
					} else {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
					}
				}
				if ((gm.equalsIgnoreCase("3")) || (gm.equalsIgnoreCase("spectator"))) {
					if (args.length == 2) {
						if (!p.hasPermission("StudioAPI.gmpass")) {
							p.sendMessage(
									"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");

							return true;
						}
						Player p1 = Bukkit.getPlayer(args[1]);
						if (p1 == null) {
							p.sendMessage("§cEste jogador não foi encontrado!");
							return true;
						}
						p1.setGameMode(GameMode.SPECTATOR);
						p1.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
						p.sendMessage("§aModo de jogo do jogador " + p1.getName() + ", foi alterado para "
								+ p1.getGameMode() + ".");
					} else {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§aModo de jogo alterado para " + p.getGameMode() + ".");
					}
				}
			}
		}
		return false;
	}
}
