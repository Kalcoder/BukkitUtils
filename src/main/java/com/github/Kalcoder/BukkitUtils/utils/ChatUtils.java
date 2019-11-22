package com.github.Kalcoder.BukkitUtils.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;

/** Utilities for messages and chat
 * @since 1.1
 */
public class ChatUtils {

  /** Change color codes such as &c to colors
   * @param message The message to color
   *
   * @since 1.1
   */
  public static String translateColors(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }

  /** Send colored message to entity
   * @param entity Entity to send message to
   * @param message Message to send
   *
   * @since 1.1
   */
  public static void sendMessage(Entity entity, String message) {
    entity.sendMessage(translateColors(message));
  }

}