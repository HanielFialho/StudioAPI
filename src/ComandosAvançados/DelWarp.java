package ComandosAvançados;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import Dependências.WarpUtils;

@SuppressWarnings("unused")
public class DelWarp implements CommandExecutor {
	public DelWarp() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String delwarp, String[] args) {
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			if (p.hasPermission("Warp.delwarp")) {
				if (args.length == 1) {
					File file = new File("plugins/StudioAPI", "warps.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					if (cfg.getString(args[0]) != null) {
						cfg.set(args[0], null);
						p.sendMessage(WarpUtils.prefix + args[0]);
						try {
							cfg.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						p.sendMessage(WarpUtils.prefix + args[0]);
					}
				} else {
					p.sendMessage(WarpUtils.prefix + "§c/delwarp <WARP>");
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
