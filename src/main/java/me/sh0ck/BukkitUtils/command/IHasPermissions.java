package me.sh0ck.BukkitUtils.command;

import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

public interface IHasPermissions {
  
  /** The permissions
   *
   */
  public List<Permission> permissions = new ArrayList<>();
  
}
