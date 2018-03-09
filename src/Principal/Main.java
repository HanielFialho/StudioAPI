package Principal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import ComandosAvançados.DelWarp;
import ComandosAvançados.JoinToSpawn;
import ComandosSimples.Fome;
import ComandosSimples.Give;
import ComandosSimples.LimparIventario;
import ComandosSimples.ModoDeJogo;
import ComandosSimples.Suicidio;
import ComandosSimples.Teleporte;
import ComandosSimples.Vanish;
import Eventos.AntiTab;
import Eventos.BlockRenameAnvil;
import Eventos.DeathEvent;
import Eventos.JoinAndLeave;
import Eventos.SingColor;

public class Main extends JavaPlugin {

	public static Main getPlugin() {
		return JavaPlugin.getPlugin(Main.class);
	}

	@Override
	public void onEnable() {
		org.bukkit.Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD
				+ "Sua luta não termina quando sentir cansaço, mas sim quando atingir o sucesso tão merecido.");
		RegistrarComandos();
		RegistrarEventos();
	}

	private void RegistrarComandos() {
		getCommand("Fly").setExecutor(new ComandosSimples.Fly());
		getCommand("Vanish").setExecutor(new Vanish());
		getCommand("tp").setExecutor(new Teleporte());
		getCommand("v").setExecutor(new ComandosSimples.OlharIventario());
		getCommand("gamemode").setExecutor(new ModoDeJogo());
		getCommand("Clear").setExecutor(new LimparIventario());
		getCommand("Dia").setExecutor(new ComandosSimples.Dia());
		getCommand("Noite").setExecutor(new ComandosSimples.Noite());
		getCommand("Vida").setExecutor(new ComandosSimples.Vida());
		getCommand("Fome").setExecutor(new Fome());
		getCommand("Kill").setExecutor(new Suicidio());
		getCommand("Hat").setExecutor(new ComandosSimples.Chapéu());
		getCommand("Give").setExecutor(new Give());
		getCommand("setwarp").setExecutor(new ComandosAvançados.SetWarp());
		getCommand("delwarp").setExecutor(new DelWarp());
		getCommand("warp").setExecutor(new ComandosAvançados.Warp());
		getCommand("warplist").setExecutor(new ComandosAvançados.WarpList());
	}

	private void RegistrarEventos() {
		getServer().getPluginManager().registerEvents(new Eventos.Clime(), this);
		getServer().getPluginManager().registerEvents(new JoinAndLeave(), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinToSpawn(), this);
		getServer().getPluginManager().registerEvents(new SingColor(), this);
		getServer().getPluginManager().registerEvents(new BlockRenameAnvil(), this);
		getServer().getPluginManager().registerEvents(new AntiTab(), this);
	}

	@Override
	public void onDisable() {
		for (Player players : Bukkit.getOnlinePlayers()) {
			players.kickPlayer(
					"§6§lMINESTUDIO \n §6Olá Querio, verificamos é constatamos que o o nosso Mainframe, esta reiniciando, \n porfavor aguarde o retorno do mesmo, para voltar a jogar de agradável é sem bugs.");
			HandlerList.unregisterAll(this);
		}
	}

}
