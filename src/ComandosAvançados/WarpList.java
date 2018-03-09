package ComandosAvançados;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import Dependências.WarpUtils;

public class WarpList implements CommandExecutor {
	public WarpList() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String warplist, String[] args) {
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			if (p.hasPermission("Warp.warplist")) {
				if (args.length == 0) {
					File file = new File("plugins/StudioAPI", "warps.yml");
					FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
					int i = 0;
					p.sendMessage(WarpUtils.prefix);
					for (String key : cfg.getKeys(true)) {
						if (!key.contains(".")) {
							i++;
							p.sendMessage(WarpUtils.prefix + "§7" + i + ". §6'" + key + "'");
						}
					}

					i = 0;
				} else {
					p.sendMessage(WarpUtils.prefix + "§c/warplist");
				}
			} else {
				p.sendMessage(WarpUtils.noperm);
			}
		} else {
			System.out.println("Not for Console!");
		}
		return false;
	}
}
