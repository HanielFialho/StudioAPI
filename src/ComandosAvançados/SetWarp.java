package ComandosAvançados;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import Dependências.WarpUtils;

public class SetWarp implements org.bukkit.command.CommandExecutor {

	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, Command cmd, String setwarp, String[] args) {
		File file = new File("plugins/StudioAPI", "warps.yml");
		FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			if (p.hasPermission("Warp.setwarp")) {
				if (args.length == 1) {
					String world = p.getWorld().getName();
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					double yaw = p.getLocation().getYaw();
					double pitch = p.getLocation().getPitch();

					cfg.set(args[0] + ".world", world);
					cfg.set(args[0] + ".x", Double.valueOf(x));
					cfg.set(args[0] + ".y", Double.valueOf(y));
					cfg.set(args[0] + ".z", Double.valueOf(z));
					cfg.set(args[0] + ".yaw", Double.valueOf(yaw));
					cfg.set(args[0] + ".pitch", Double.valueOf(pitch));
					try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage(WarpUtils.prefix + args[0]
							+ " §eVerificamos é constatamos que você setou a warp com exito.");
					p.sendMessage("");
					p.sendMessage("");
				} else {
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage(
							WarpUtils.prefix + "§eYah,você esta quase lá, simplemente digite /setwarp + nomedawarp");
					p.sendMessage("");
					p.sendMessage("");
				}
			} else {
				p.sendMessage(WarpUtils.noperm);
			}
		} else {
			System.out.println("");
		}
		return false;
	}
}
