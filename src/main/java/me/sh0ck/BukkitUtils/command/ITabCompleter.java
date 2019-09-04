package me.sh0ck.BukkitUtils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

/** Gives command tab completion
 * @version 1.0
 * @since 1.0
 */
public interface ITabCompleter extends TabCompleter {
  
  /** Executes when a request for tab completion is sent
   * @param sender The executor of the request
   * @param command The command that is used during the request
   * @param label The alias of the command that is used during the request
   * @param args The arguments of the command that is used during the request
   * @return A list of strings that the executor can choose from when tab completing
   */
  List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args);
}
