package com.hell.client.modules;

import com.hell.client.Addon;
import meteordevelopment.meteorclient.events.entity.player.InteractEntityEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;


public class Hit extends Module {
    Setting<Boolean> OnlyCrits;
    public Hit() {
        super(Addon.CATEGORY, "hit", "A more legit killaura simply hold right click and aim at your target.");
        SettingGroup GlSettings = settings.getDefaultGroup();
        OnlyCrits = GlSettings.add(new BoolSetting.Builder()
            .name("OnlyCrits")
            .description("Only Attacks While Criting")
            .defaultValue(false)
            .build());
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
            if (OnlyCrits.get()&&mc.player.getVelocity().y > 0.01) return;
            assert mc.interactionManager != null;
            mc.interactionManager.attackEntity(mc.player, e.entity);
        }
    }
}
