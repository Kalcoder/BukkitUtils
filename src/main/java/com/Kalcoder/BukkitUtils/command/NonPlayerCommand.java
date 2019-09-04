package com.Kalcoder.BukkitUtils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/** This is the base command class used for creating non-client only commands.
 * @version 1.0
 * @since 1.0
 */
public abstract class NonPlayerCommand extends BaseCommand {
  
  /**
   * @param plugin The plugin that is using BukkitUtils
   */
  public NonPlayerCommand(JavaPlugin plugin) {
    super(plugin);
  }
  
  /**
   * Function called when the command registered under this command's name is executed
   *
   * @param sender  The sender of the command
   * @param command The command
   * @param label   The alias of the command used
   * @param args    The arguments provided when the command was executed
   */
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      sender.sendMessage("Error: Players are not allowed to use this command!");
      return true;
    }
    return super.onCommand(sender, command, label, args);
  }
}
