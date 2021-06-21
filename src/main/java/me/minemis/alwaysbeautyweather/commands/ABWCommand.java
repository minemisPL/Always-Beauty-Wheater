package me.minemis.alwaysbeautyweather.commands;

import me.minemis.alwaysbeautyweather.AlwaysBeautyWeather;
import me.minemis.alwaysbeautyweather.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class ABWCommand implements CommandExecutor {

    private final AlwaysBeautyWeather plugin;

    public ABWCommand(AlwaysBeautyWeather plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!((args.length == 1 || args.length == 2) && ChatUtils.compare(Arrays.asList("on", "off"), args[0]))) {
            sender.sendMessage(ChatColor.RED + "Poprawne użycie:\n/ABweather on/off <argument>");
            return true;
        }

        boolean isOn = args[0].equalsIgnoreCase("on");

        if (args.length == 1) {
            plugin.setKeepDay(isOn);
            plugin.setKeepClear(isOn);

            for (World world : Bukkit.getWorlds()) {
                world.setGameRuleValue("dodaylightcycle", Boolean.toString(!isOn));

                if (!isOn) {
                    continue;
                }

                world.setStorm(false);
                world.setTime(5000L);
            }

            return true;
        }

        if (args[1].equalsIgnoreCase("weather")) {
            plugin.setKeepClear(isOn);

            for (World world : Bukkit.getWorlds()) {
                if (!isOn) {
                    break;
                }

                world.setStorm(false);
            }

            return true;
        }

        if (args[1].equalsIgnoreCase("day")) {
            plugin.setKeepDay(isOn);
            for (World world : Bukkit.getWorlds()) {
                world.setGameRuleValue("dodaylightcycle", Boolean.toString(!isOn));

                if (!isOn) {
                    continue;
                }

                world.setTime(5000L);
            }

            return true;
        }


        sender.sendMessage(ChatColor.RED + "Poprawne użycie:\n/ABweather on/off <argument>");
        return true;
    }

}
