package exodian.me.deathban;


import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.BanList;

public class QuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if((event.getPlayer().getGameMode() == GameMode.SPECTATOR) && (!event.getPlayer().hasPermission("banondeath.immune"))){
            event.getPlayer().getServer().getBanList(BanList.Type.NAME).addBan(event.getPlayer().getName(), "RIP", null, "Lord Moonmoon's faithful plugin"); // NAME BAN
            event.getPlayer().getServer().getLogger().info("BanOnDeath has banned " + event.getPlayer().getName());
        }
    }
}
