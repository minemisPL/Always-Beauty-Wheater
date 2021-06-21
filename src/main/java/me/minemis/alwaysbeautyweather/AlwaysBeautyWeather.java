package me.minemis.alwaysbeautyweather;

import me.minemis.alwaysbeautyweather.commands.ABWCommand;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlwaysBeautyWeather extends JavaPlugin {

    private boolean keepDay = true;
    private boolean keepClear = true;

    @Override
    public void onEnable() {
        this.getCommand("ABWeather").setExecutor(new ABWCommand(this));

        for (World world : Bukkit.getWorlds()) {
            world.setGameRuleValue("dodaylightcycle", String.valueOf(false));

            world.setStorm(false);
            world.setTime(5000L);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public boolean getKeepDay(){
        return keepDay;
    }
    public boolean getKeepClear(){
        return keepClear;
    }


    public void setKeepDay(boolean keepDay){
        this.keepDay = keepDay;
    }
    public void setKeepClear(boolean keepRain){
        this.keepClear = keepRain;
    }
}
