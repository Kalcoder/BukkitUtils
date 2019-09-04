package me.sh0ck.BukkitUtils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

/** This is the base command class used for creating commands.
 * @version 1.0
 * @since 1.0
 */
public abstract class BaseCommand implements CommandExecutor {
  
  /** The plugin that is using BukkitUtils */
  private final JavaPlugin plugin;
  
  /**
   * @param plugin The plugin that is using BukkitUtils
   */
  public BaseCommand(JavaPlugin plugin) {
    this.plugin = plugin;
  }
  
  /** Function called when the command registered under this command's name is executed
   * @param sender The sender of the command
   * @param command The command
   * @param label The alias of the command used
   * @param args The arguments provided when the command was executed
   */
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (this instanceof IHasPermissions) {
      for (Permission perm:
           ((IHasPermissions) this).permissions) {
        if (!sender.hasPermission(perm)) {
          sender.sendMessage("Error: You are missing required permission " + perm.getName() + "!");
        }
      }
    }
    onCommand(sender, args);
    return true;
  }
  
  /** The function to be overridden in any command created that executes command logic
   * @param sender The sender of the command
   * @param args The arguments provided when the command was executed
   */
  protected abstract void onCommand(CommandSender sender, String[] args);
}
