package com.github.Kalcoder.BukkitUtils.utils

import org.bukkit.ChatColor
import org.bukkit.entity.Entity

object ChatUtils {

  @JvmStatic
  fun translateColors(message: String): String {
    return ChatColor.translateAlternateColorCodes('&', message)
  }

  @JvmStatic
  fun sendMessage(entity: Entity, message: String) {
    entity.sendMessage(translateColors(message))
  }

}