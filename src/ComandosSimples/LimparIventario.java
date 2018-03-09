package ComandosSimples;

import org.bukkit.entity.Player;

public class LimparIventario implements org.bukkit.command.CommandExecutor {
	public LimparIventario() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem utilizar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("clear")) {
			if (args.length == 1) {
				if (!p.hasPermission("SmiteAPI." + cmd.getName())) {
					sender.sendMessage(
							"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
					return true;
				}
				Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
				if (p1 == null) {
					p.sendMessage("§cEste jogador não está online!");
					return true;
				}
				if (p1.hasPermission("StudioAPI.diretor")) {
					p.sendMessage(
							"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
					return true;
				}
				p1.getInventory().clear();
				p1.getInventory().setBoots(null);
				p1.getInventory().setChestplate(null);
				p1.getInventory().setHelmet(null);
				p1.getInventory().setLeggings(null);
				p.sendMessage("§aVoc§ limpou todo o invent§rio do jogador " + p1.getName() + ".");
			} else {
				if (args.length == 0) {
					if (!p.hasPermission("StudioAPI." + cmd.getName())) {
						p.sendMessage(
								"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
						return true;
					}
					p.getInventory().clear();
					p.getInventory().setBoots(null);
					p.getInventory().setChestplate(null);
					p.getInventory().setHelmet(null);
					p.getInventory().setLeggings(null);
					p.sendMessage("§aVocê limpou todo o seu inventário com sucesso.");
				}
				if (args.length > 1) {
					p.sendMessage("§cErro! Utilize: /clear <jogador>!");
					return true;
				}
			}
		}
		return false;
	}
}
