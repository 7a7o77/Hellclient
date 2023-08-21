package com.example.addon.modules;

import com.example.addon.Addon;
import meteordevelopment.meteorclient.events.entity.player.InteractEntityEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;


public class ModuleExample extends Module {
    public ModuleExample() {
        super(Addon.CATEGORY, "rhit", "An Custom module in a custom category.");

    }
    @Override
    public void onActivate(){
        super.onActivate();
    }
    @EventHandler
    void test(InteractEntityEvent e){
        if (isActive()){
            e.setCancelled(true);
            mc.player.attack(e.entity);
        }
    }
}
