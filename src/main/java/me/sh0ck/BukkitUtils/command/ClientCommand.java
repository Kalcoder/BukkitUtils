package me.sh0ck.BukkitUtils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ClientCommand extends BaseCommand {
  
  /**
   * @param plugin The plugin that is using BukkitUtils
   */
  public ClientCommand(JavaPlugin plugin) {
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
    if (!(sender instanceof Player)) {
      sender.sendMessage("Error: You must be a player to use this command!");
      return true;
    }
    super.onCommand(sender, command, label, args);
    return true;
  }
}
