package exodian.me.deathban;

import org.bukkit.plugin.java.JavaPlugin;

public final class DeathBan extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        getLogger().info("DeathBan v2.0 has started.");
    }

    @Override
    public void onDisable() {
        getLogger().info("DeathBan v2.0 has stopped.");
    }
}
