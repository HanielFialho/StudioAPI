package ComandosSimples;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Noite implements org.bukkit.command.CommandExecutor {
	public Noite() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("noite"))
				|| (!sender.hasPermission("StudioAPI." + command.getName()))) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			return true;
		}
		Player p = (Player) sender;
		org.bukkit.World world = p.getWorld();
		world.setTime(19000L);
		p.sendMessage("§eVocê alterou o tempo deste mundo para: NOITE.");

		return false;
	}
}
