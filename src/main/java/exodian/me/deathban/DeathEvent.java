package exodian.me.deathban;


import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.BanList;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerGameModeChangeEvent event){
        Player player = event.getPlayer();
        if((event.getNewGameMode() == GameMode.SPECTATOR) && (!player.hasPermission("banondeath.immune"))){
            final Team bros = player.getServer().getScoreboardManager().getMainScoreboard().getTeam("Brothers");
            final Team leader = player.getServer().getScoreboardManager().getMainScoreboard().getTeam("Leader");
            final String name = player.getName();

            player.getServer().getBanList(BanList.Type.NAME).addBan(name, "RIP", null, "BanOnDeath"); // NAME BAN
            player.getServer().getLogger().info("BanOnDeath has banned " + name);

            try {
                if(!bros.hasEntry(name) && !leader.hasEntry(name)){
                    player.getServer().broadcast(ChatColor.DARK_RED+""+ChatColor.ITALIC+"[DeathBan] "+name+" has been automatically banned.", player.getServer().BROADCAST_CHANNEL_ADMINISTRATIVE);
                    player.kickPlayer("Thanks for playing.");
                }
            } catch (NullPointerException ex) {
                player.getServer().getLogger().warning("Tried to ban player, but the required teams were missing");
                player.getServer().getBanList(BanList.Type.NAME).pardon(name);
            }
        }
    }
}