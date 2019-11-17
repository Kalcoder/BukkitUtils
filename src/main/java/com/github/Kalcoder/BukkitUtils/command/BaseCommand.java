package com.github.Kalcoder.BukkitUtils.command;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/** This is the base command class used for creating commands.
 *
 * @since 1.0
 */
public abstract class BaseCommand implements CommandExecutor {
  
  /** The plugin that is using BukkitUtils
   * @since 1.0
   */
  private final JavaPlugin plugin;
  
  /** Constructor
   * @param plugin The plugin that is using BukkitUtils
   * @since 1.0
   */
  public BaseCommand(JavaPlugin plugin) {
    this.plugin = plugin;
  }
  
  /** Function called when the command registered under this command's name is executed
   *
   * @param sender The sender of the command
   * @param command The command
   * @param label The alias of the command used
   * @param args The arguments provided when the command was executed
   *
   * @since 1.0
   */
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
