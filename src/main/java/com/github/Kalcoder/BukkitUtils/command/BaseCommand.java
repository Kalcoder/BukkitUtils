package com.github.Kalcoder.BukkitUtils.command;

import org.bukkit.Bukkit;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/** This is the base command class used for creating commands.
 *
 * @since 1.0
 */
public abstract class BaseCommand extends BukkitCommand {
  
  /** Constructor
   * @param name The name of the command
   * @param namespace The prefix used when there are command conflicts
   *
   * @since 1.0
   */
  public BaseCommand(String name, String namespace) {
    super(name);
  
    try {
      final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
    
      bukkitCommandMap.setAccessible(true);
      CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
    
      commandMap.register(namespace, this);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  /** Function called when the command registered under this command's name is executed
   * @param sender The sender of the command
   * @param label The alias of the command used
   * @param args The arguments provided when the command was executed
   *
   * @since 1.0
   */
  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (this instanceof IPlayerCommand && !(sender instanceof Player)) {
      sender.sendMessage("Error: You must be a player to use this command!");
      return true;
    }
    if (this instanceof IConsoleCommand && !(sender instanceof ConsoleCommandSender)) {
      sender.sendMessage("Error: You must execute this command from the console!");
      return true;
    }
    if (this instanceof ICommandBlockCommand && !(sender instanceof BlockCommandSender)) {
      sender.sendMessage("Error: You must execute this command from a command block!");
      return true;
    }
    onCommand(sender, args);
    return true;
  }
  
  /** The function to be overridden in any command created that executes command logic
   *
   * @param sender The sender of the command
   * @param args The arguments provided when the command was executed
   *
   * @since 1.0
   */
  protected abstract void onCommand(CommandSender sender, String[] args);
}
