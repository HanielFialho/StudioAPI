package ComandosAvançados;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import Dependências.WarpUtils;

public class Warp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		File file = new File("plugins/StudioAPI", "warps.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Player p = (Player) sender;
		if (p.hasPermission("Warp.warp")) {
			if (args.length == 1) {
				if (cfg.getString(args[0]) != null) {
					String world = cfg.getString(args[0] + ".world");
					double x = cfg.getDouble(args[0] + ".x");
					double y = cfg.getDouble(args[0] + ".y");
					double z = cfg.getDouble(args[0] + ".z");
					double yaw = cfg.getDouble(args[0] + ".yaw");
					double pitch = cfg.getDouble(args[0] + ".pitch");

					Location loc = new Location(Bukkit.getWorld(world), x, y, z);
					loc.setPitch((float) pitch);
					loc.setYaw((float) yaw);

					p.teleport(loc);
					p.playSound(p.getLocation(), Sound.PISTON_RETRACT, 5.0F, 5.0F);
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage(WarpUtils.prefix + "§aBaixando informações do local do teleporte…");
					p.sendMessage("§aLocalização localizada você foi teleportado para seu destino selecionado.");
					p.sendMessage("");
					p.sendMessage("");
				} else {
					p.sendMessage(WarpUtils.prefix + args[0] + " §7");
				}
			} else {
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage(WarpUtils.prefix + "§eTeleporte Utilizando /warp + NomeDaWarp");
				p.sendMessage("");
				p.sendMessage("");
			}
		} else {
			p.sendMessage(WarpUtils.noperm);
		}
		return false;
	}
}
