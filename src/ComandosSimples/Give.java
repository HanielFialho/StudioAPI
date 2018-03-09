package ComandosSimples;

import org.bukkit.command.CommandSender;

public class Give implements org.bukkit.command.CommandExecutor {

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("give"))
				|| (!sender.hasPermission("StudioAPI." + command.getName()))) {
			sender.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho..");

			return true;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /give <nick> <id> [quantidade] para enviar um item á um jogador.");

			return true;
		}
		if (args.length == 1) {
			sender.sendMessage("§cUtilize /give [nick] <id> [quantidade] para enviar um item á um jogador.");

			return true;
		}
		if (args.length == 2) {
			org.bukkit.entity.Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
			if (p1 == null) {
				sender.sendMessage("§cEste jogador não está on-line.");

				return true;
			}
			if (isInt(args[1])) {
				int id = Integer.valueOf(args[1]).intValue();
				if (org.bukkit.Material.getMaterial(id) == null) {
					sender.sendMessage("§cItem não encontrado.");

					return true;
				}
				org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(
						org.bukkit.Material.getMaterial(id));

				p1.getInventory().addItem(new org.bukkit.inventory.ItemStack[] { item });

				sender.sendMessage(
						"§aEnviando 1x " + item.getType().toString().toUpperCase() + " para " + p1.getName() + ".");
				return true;
			}
			String name = args[1].toUpperCase();
			if (org.bukkit.Material.getMaterial(name) == null) {
				sender.sendMessage("§cItem não encontrado.");

				return true;
			}
			org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(
					org.bukkit.Material.getMaterial(name));

			p1.getInventory().addItem(new org.bukkit.inventory.ItemStack[] { item });

			sender.sendMessage(
					"§aEnviando 1x " + item.getType().toString().toUpperCase() + " para " + p1.getName() + ".");
			return true;
		}
		if (args.length == 3) {
			org.bukkit.entity.Player p1 = org.bukkit.Bukkit.getPlayer(args[0]);
			if (p1 == null) {
				sender.sendMessage("§cEste jogador não está on-line.");

				return true;
			}
			if (isInt(args[1])) {
				if (isInt(args[2])) {
					int id = Integer.valueOf(args[1]).intValue();

					int quant = Integer.valueOf(args[2]).intValue();
					if (org.bukkit.Material.getMaterial(id) == null) {
						sender.sendMessage("§cItem não encontrado.");

						return true;
					}
					org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(
							org.bukkit.Material.getMaterial(id), quant);

					p1.getInventory().addItem(new org.bukkit.inventory.ItemStack[] { item });

					sender.sendMessage("§aEnviando " + quant + "x " + item.getType().toString().toUpperCase() + " para "
							+ p1.getName() + ".");
					return true;
				}
				sender.sendMessage("§cVocê inseriu um número inválido.");

				return true;
			}
			if (isInt(args[2])) {
				String name = args[1].toUpperCase();
				if (org.bukkit.Material.getMaterial(name) == null) {
					sender.sendMessage("§cItem não encontrado.");

					return true;
				}
				int quant = Integer.valueOf(args[2]).intValue();

				org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(
						org.bukkit.Material.getMaterial(name), quant);

				p1.getInventory().addItem(new org.bukkit.inventory.ItemStack[] { item });

				sender.sendMessage("§aEnviando " + quant + "x " + item.getType().toString().toUpperCase() + " para "
						+ p1.getName() + ".");
				return true;
			}
			sender.sendMessage("§cVocê inseriu um n§mero inv§lido.");

			return true;
		}
		return false;
	}
}
