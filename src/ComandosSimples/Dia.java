package ComandosSimples;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Dia implements org.bukkit.command.CommandExecutor {
	public Dia() {
	}

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("Dia")) || (!sender.hasPermission("StudioAPI." + command.getName()))) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			return true;
		}
		Player p = (Player) sender;
		org.bukkit.World world = p.getWorld();
		world.setTime(0L);
		p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
		p.sendMessage("§eVocê alterou o tempo deste mundo para: DIA.");

		return false;
	}
}
