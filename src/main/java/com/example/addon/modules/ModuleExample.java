package com.example.addon.modules;

import com.example.addon.Addon;
import meteordevelopment.meteorclient.events.entity.player.InteractEntityEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;


public class ModuleExample extends Module {
    public ModuleExample() {
        super(Addon.CATEGORY, "hit", "An Custom module in a custom category.");

    }
    @Override
    public void onActivate(){
        super.onActivate();
    }
    @EventHandler
    void test(InteractEntityEvent e){
        if (isActive()){
            e.setCancelled(true);
            if (mc.player == null)return;
            if ((int) (mc.player.getAttackCooldownProgress(0.0F) * 17.0F) < 16) return;
            if (mc.player.getVelocity().y >= 0) return;
            assert mc.interactionManager != null;
            mc.interactionManager.attackEntity(mc.player, e.entity);
        }
    }
}
