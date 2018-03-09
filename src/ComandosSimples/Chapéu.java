package ComandosSimples;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Dependências.TitleApi;

public class Chapéu implements org.bukkit.command.CommandExecutor {

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("hat")) || (!(sender instanceof Player))) {
			sender.sendMessage("§cApenas jogadores podem executar este comando.");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("StudioAPI." + command.getName())) {
			sender.sendMessage("");
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			sender.sendMessage("");
			return true;
		}
		if (args.length == 0) {
			if ((p.getItemInHand() != null) && (!p.getItemInHand().getType().equals(Material.AIR))) {
				String check = "S";
				if ((p.getInventory().getHelmet() != null)
						&& (!p.getInventory().getHelmet().getType().equals(Material.AIR))) {
					check = "N";
				}
				ItemStack cab = null;
				if (check.equals("N")) {
					cab = p.getInventory().getHelmet();
				}
				ItemStack itemStack = p.getItemInHand();

				p.getInventory().setHelmet(itemStack);
				p.setItemInHand(new ItemStack(Material.AIR));
				TitleApi.sendTitle(p, 20, 40, 20, "§6CHAPÉU", "§fColocado");
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
				p.sendMessage("");
				p.sendMessage("§aAproveite o seu novo chapéu!");
				p.sendMessage("");
				if (check.equals("N")) {
					p.setItemInHand(cab);
				}
				return true;
			}
			p.sendMessage("");
			p.sendMessage("§cVocê precisa de um item em sua mao!");
			p.sendMessage("");
		}
		return false;
	}
}
