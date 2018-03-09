package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SingColor implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent sign) {
		Player player = sign.getPlayer();
		if (player.hasPermission("pc.color")) {
			if ((sign.getLine(0).contains("&1")) || (sign.getLine(0).contains("&2")) || (sign.getLine(0).contains("&3"))
					|| (sign.getLine(0).contains("&4")) || (sign.getLine(0).contains("&5"))
					|| (sign.getLine(0).contains("&6")) || (sign.getLine(0).contains("&7"))
					|| (sign.getLine(0).contains("&8")) || (sign.getLine(0).contains("&9"))
					|| (sign.getLine(0).contains("&0")) || (sign.getLine(0).contains("&a"))
					|| (sign.getLine(0).contains("&b")) || (sign.getLine(0).contains("&c"))
					|| (sign.getLine(0).contains("&d")) || (sign.getLine(0).contains("&e"))
					|| (sign.getLine(0).contains("&f")) || (sign.getLine(0).contains("&o"))
					|| (sign.getLine(0).contains("&l")) || (sign.getLine(0).contains("&k"))
					|| (sign.getLine(0).contains("&n")) || (sign.getLine(0).contains("&m"))
					|| (sign.getLine(0).contains("&r"))) {
				sign.setLine(0, sign.getLine(0).replace("&", "§"));
			}
			if ((sign.getLine(1).contains("&1")) || (sign.getLine(1).contains("&2")) || (sign.getLine(1).contains("&3"))
					|| (sign.getLine(1).contains("&4")) || (sign.getLine(1).contains("&5"))
					|| (sign.getLine(1).contains("&6")) || (sign.getLine(1).contains("&7"))
					|| (sign.getLine(1).contains("&8")) || (sign.getLine(1).contains("&9"))
					|| (sign.getLine(1).contains("&0")) || (sign.getLine(1).contains("&a"))
					|| (sign.getLine(1).contains("&b")) || (sign.getLine(1).contains("&c"))
					|| (sign.getLine(1).contains("&d")) || (sign.getLine(1).contains("&e"))
					|| (sign.getLine(1).contains("&f")) || (sign.getLine(1).contains("&o"))
					|| (sign.getLine(1).contains("&l")) || (sign.getLine(1).contains("&k"))
					|| (sign.getLine(1).contains("&n")) || (sign.getLine(1).contains("&m"))
					|| (sign.getLine(1).contains("&r"))) {
				sign.setLine(1, sign.getLine(1).replace("&", "§"));
			}
			if ((sign.getLine(2).contains("&1")) || (sign.getLine(2).contains("&2")) || (sign.getLine(2).contains("&3"))
					|| (sign.getLine(2).contains("&4")) || (sign.getLine(2).contains("&5"))
					|| (sign.getLine(2).contains("&6")) || (sign.getLine(2).contains("&7"))
					|| (sign.getLine(2).contains("&8")) || (sign.getLine(2).contains("&9"))
					|| (sign.getLine(2).contains("&0")) || (sign.getLine(2).contains("&a"))
					|| (sign.getLine(2).contains("&b")) || (sign.getLine(2).contains("&c"))
					|| (sign.getLine(2).contains("&d")) || (sign.getLine(2).contains("&e"))
					|| (sign.getLine(2).contains("&f")) || (sign.getLine(2).contains("&o"))
					|| (sign.getLine(2).contains("&l")) || (sign.getLine(2).contains("&k"))
					|| (sign.getLine(2).contains("&n")) || (sign.getLine(2).contains("&m"))
					|| (sign.getLine(2).contains("&r"))) {
				sign.setLine(2, sign.getLine(2).replace("&", "§"));
			}
			if ((sign.getLine(3).contains("&1")) || (sign.getLine(3).contains("&2")) || (sign.getLine(3).contains("&3"))
					|| (sign.getLine(3).contains("&4")) || (sign.getLine(3).contains("&5"))
					|| (sign.getLine(3).contains("&6")) || (sign.getLine(3).contains("&7"))
					|| (sign.getLine(3).contains("&8")) || (sign.getLine(3).contains("&9"))
					|| (sign.getLine(3).contains("&0")) || (sign.getLine(3).contains("&a"))
					|| (sign.getLine(3).contains("&b")) || (sign.getLine(3).contains("&c"))
					|| (sign.getLine(3).contains("&d")) || (sign.getLine(3).contains("&e"))
					|| (sign.getLine(3).contains("&f")) || (sign.getLine(3).contains("&o"))
					|| (sign.getLine(3).contains("&l")) || (sign.getLine(3).contains("&k"))
					|| (sign.getLine(3).contains("&n")) || (sign.getLine(3).contains("&m"))
					|| (sign.getLine(3).contains("&r"))) {
				sign.setLine(3, sign.getLine(3).replace("&", "§"));
			}
		}
	}
}
