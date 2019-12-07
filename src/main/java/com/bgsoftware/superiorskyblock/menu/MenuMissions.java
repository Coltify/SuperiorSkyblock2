package com.bgsoftware.superiorskyblock.menu;

import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import com.bgsoftware.superiorskyblock.utils.FileUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MenuMissions extends SuperiorMenu {

    private static int playerSlot, islandSlot;

    private MenuMissions(SuperiorPlayer superiorPlayer){
        super("menuMissions", superiorPlayer);
    }

    @Override
    public void onPlayerClick(InventoryClickEvent e) {
        if(e.getRawSlot() == playerSlot){
            previousMove = false;
            MenuPlayerMissions.openInventory(superiorPlayer, 1, this);
        }
        else if(e.getRawSlot() == islandSlot){
            previousMove = false;
            MenuIslandMissions.openInventory(superiorPlayer, 1, this);
        }
    }

    public static void init(){
        MenuMissions menuMissions = new MenuMissions(null);

        File file = new File(plugin.getDataFolder(), "menus/missions.yml");

        if(!file.exists())
            FileUtils.saveResource("menus/missions.yml");

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Map<Character, List<Integer>> charSlots = FileUtils.loadGUI(menuMissions, "missions.yml", cfg);

        playerSlot = charSlots.getOrDefault(cfg.getString("player-missions", "@").charAt(0), Collections.singletonList(-1)).get(0);
        islandSlot = charSlots.getOrDefault(cfg.getString("island-missions", "^").charAt(0), Collections.singletonList(-1)).get(0);
    }

    public static void openInventory(SuperiorPlayer superiorPlayer, SuperiorMenu previousMenu){
        new MenuMissions(superiorPlayer).open(previousMenu);
    }

}
