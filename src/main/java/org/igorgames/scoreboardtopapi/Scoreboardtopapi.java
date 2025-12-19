package org.igorgames.scoreboardtopapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class Scoreboardtopapi extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        new papi().register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
