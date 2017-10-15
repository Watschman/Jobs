package com.watschman.jobs.config;

import com.watschman.jobs.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ModConfiguration {
    public static final ModConfiguration instance = new ModConfiguration();
    public static Configuration config;

    public static void init(File configFile) {
        if(config == null) {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }
    public static void loadConfiguration () {
        Property testValue = config.get(Configuration.CATEGORY_GENERAL, "Test", 1, "This is just a TestValue");
        if(config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

}
