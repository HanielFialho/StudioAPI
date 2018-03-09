package ComandosSimples;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OlharIventario implements org.bukkit.command.CommandExecutor {
	public OlharIventario() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem utilizar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("v")) {
			if (!p.hasPermission("StudioAPI." + cmd.getName())) {
				sender.sendMessage(
						"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§cUtilize /invsee <jogador> para ver o invent�rio de um jogador.");
				return true;
			}
			Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
			if (p1 == null) {
				p.sendMessage("§cEste jogador não esta on-line.");
				return true;
			}
			org.bukkit.inventory.PlayerInventory inv = p1.getInventory();

			p.openInventory(inv);
		}
		return false;
	}
}
