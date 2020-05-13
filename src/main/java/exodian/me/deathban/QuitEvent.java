package exodian.me.deathban;


import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.BanList;
import org.bukkit.entity.Player;

public class QuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if((player.getGameMode() == GameMode.SPECTATOR) && (!player.hasPermission("banondeath.immune"))){
            player.getServer().getBanList(BanList.Type.NAME).addBan(player.getName(), "RIP", null, "Lord Moonmoon's faithful plugin"); // NAME BAN
            player.getServer().getLogger().info("BanOnDeath has banned " + player.getName());
            if(!player.getServer().getScoreboardManager().getMainScoreboard().getTeam("Brothers").hasEntry(player.getName())){
                player.kickPlayer("Thanks for playing.");
            }
        }
    }
}
