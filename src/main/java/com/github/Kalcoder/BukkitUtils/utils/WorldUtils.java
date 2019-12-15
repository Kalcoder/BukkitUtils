package com.github.Kalcoder.BukkitUtils.utils;

import com.github.Kalcoder.BukkitUtils.errors.MissingWorldException;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldUtils {
  
  public static List<World> activeWorlds = new ArrayList<>();
  
  public static void setActiveWorlds(World... worlds) {
    activeWorlds = Arrays.asList(worlds);
  }
  
  public static void addActiveWorld(World world) {
    activeWorlds.add(world);
  }
  
  public static void removeActiveWorld(World world) {
    activeWorlds.remove(world);
  }
  
  public static World getWorldByName(String name) throws MissingWorldException {
    if (Bukkit.getServer().getWorld(name) == null) throw new MissingWorldException(name);
    return Bukkit.getServer().getWorld(name);
  }
  
  public static World getActiveWorldByName(String name) throws MissingWorldException {
    for (World world :
            activeWorlds) {
      if (world.getName().equalsIgnoreCase(name)) {
        return world;
      }
    }
    throw new MissingWorldException(name);
  }
  
  public static World generateNewWorld(String name, boolean activate) {
    World world = Bukkit.getServer().createWorld(WorldCreator.name(name));
    if (activate) {
      activeWorlds.add(world);
    }
    return world;
  }
  
  public static void deleteWorld(String name) throws MissingWorldException {
    World worldToRemove = Bukkit.getServer().getWorld(name);
    if (worldToRemove == null) throw new MissingWorldException(name);
    activeWorlds.remove(worldToRemove);
    for (Player p :
            Bukkit.getServer().getOnlinePlayers()) {
      if (p.getWorld().equals(worldToRemove)) {
        p.kickPlayer("The world you were on was deleted!");
      }
    }
    Bukkit.getServer().getWorlds().remove(worldToRemove);
    
    worldToRemove.getWorldFolder().delete();
  }
  
}
