package me.sh0ck.BukkitUtils.command;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/** This is the base command class used for creating command block only commands.
 * @version 1.0
 * @since 1.0
 */
public abstract class CommandBlockCommand extends NonPlayerCommand {
  
  /**
   * @param plugin The plugin that is using BukkitUtils
   */
  public CommandBlockCommand(JavaPlugin plugin) {
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
    if (!(sender instanceof BlockCommandSender)) {
      sender.sendMessage("Error: You can only execute this command through a command block!");
      return true;
    }
    return super.onCommand(sender, command, label, args);
  }
}
