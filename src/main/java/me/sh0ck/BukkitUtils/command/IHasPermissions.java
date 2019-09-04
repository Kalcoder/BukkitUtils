package me.sh0ck.BukkitUtils.command;

import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

/** Restricts command to listed permissions
 * @version 1.0
 * @since 1.0
 */
public interface IHasPermissions {
  
  /** The permissions
   *
   */
  public List<Permission> permissions = new ArrayList<>();
  
}
