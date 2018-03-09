package ComandosSimples;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements org.bukkit.command.CommandExecutor {
	public static ArrayList<String> voando = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ((!command.getName().equalsIgnoreCase("fly")) || (!(sender instanceof Player))) {
			sender.sendMessage("§cApenas jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("StudioAPI." + command.getName())) {
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que este comando não esta liberado para você por falta de privilégios, estamos salvando seu comando digitado para um staff disponível ver é auxilia-lo com seu empecilho.");
			p.sendMessage("");
			p.sendMessage("");
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
			return true;
		}
		if (args.length == 0) {
			if (voando.contains(p.getName())) {
				p.setAllowFlight(false);
				p.playSound(p.getLocation(), Sound.EXPLODE, 10.0F, 1.0F);
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage(
						"§aOlá Amigo, verificamos é constatamos que você desativou seu modo de voo, agradecemos por seguir as normas do servidor.");
				p.sendMessage("");
				p.sendMessage("");
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2F, 1F);
				voando.remove(p.getName());

				return true;
			}
			p.setAllowFlight(true);
			p.playSound(p.getLocation(), Sound.EXPLODE, 10.0F, 1.0F);
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(
					"§cOlá Amigo, verificamos é constatamos que você ativou seu modo de voo, pedimos a colaboração de você para que quando você terminar de utilizar comando barra voar, você possa sair do modo de voo isso irar auxiliar o servidor para que ele possa ficar mais estavel.");
			p.sendMessage("");
			p.sendMessage("");

			voando.add(p.getName());
			return true;
		}
		if (args.length == 1) {
			if (org.bukkit.Bukkit.getServer().getPlayer(args[0]) == null) {
				p.sendMessage("");
				p.sendMessage("§cOlá Amigo Verificamos é constatamos que o jogador esta fora do servidor agora!.");
				p.sendMessage("");

				return true;
			}
			Player p1 = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
			if (voando.contains(p1.getName())) {
				p1.setAllowFlight(false);
				p.playSound(p.getLocation(), Sound.EXPLODE, 10.0F, 1.0F);
				p.sendMessage("§cModo de voo do jogador " + p1.getName() + ", foi desligado!");
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage("§cOlá Terráqueo Você Esta com voo desativado, Bom Pouso");
				p.sendMessage("");
				p.sendMessage("");
				voando.remove(p1.getName());
				return true;
			}
			p1.setAllowFlight(true);
			p.playSound(p.getLocation(), Sound.EXPLODE, 10.0F, 1.0F);
			p.sendMessage("§aModo de voo do jogador " + p1.getName() + ", foi ativado!");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("§cOlá Terráqueo Você Esta Voando, Cuidado Os Céus Tem Pássaros Furiosos.");
			p.sendMessage("");
			p.sendMessage("");
			voando.add(p1.getName());

			return true;
		}
		return false;
	}
}
