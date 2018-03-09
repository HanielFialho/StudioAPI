package Eventos;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class BlockRenameAnvil implements Listener {

	@EventHandler
	public void cliqueBigorna(InventoryClickEvent e) {
		HumanEntity p = e.getWhoClicked();
		if ((e.getInventory().getType() == InventoryType.ANVIL) && (e.getSlotType() == InventoryType.SlotType.RESULT)) {
			p.sendMessage(
					"§aOlá Marinheiro, verificamos é constatamos, que você esta tentando renomear na bigorna, mais lamentamos informar, que não é possivel aqui.");
			e.setCancelled(true);
		}
	}
}