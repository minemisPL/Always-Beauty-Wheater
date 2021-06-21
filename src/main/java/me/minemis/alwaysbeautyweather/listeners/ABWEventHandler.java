package me.minemis.alwaysbeautyweather.listeners;

import me.minemis.alwaysbeautyweather.AlwaysBeautyWeather;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class ABWEventHandler implements Listener {

    private final AlwaysBeautyWeather plugin;

    public ABWEventHandler(AlwaysBeautyWeather plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void handleRain(WeatherChangeEvent e){

        if (!plugin.getKeepClear()){
            return;
        }

        World world = e.getWorld();

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            world.setStorm(false);

        },10L);
    }
}
