package com.example.addon.modules;

import com.example.addon.Addon;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;

public class ModuleExample extends Module {
    private final Setting<Boolean> hello;
    public ModuleExample() {
        super(Addon.CATEGORY, "example", "An Custom module in a custom category.");
        SettingGroup settingGroup = settings.getDefaultGroup();
        hello = settingGroup.add(new BoolSetting.Builder()
            .defaultValue(false)
            .name("test")
            .description("testing")
            .build()
        );

    }
    @Override
    public void onActivate(){

    }
}
