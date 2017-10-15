package com.watschman.jobs;

import com.watschman.jobs.config.ModConfiguration;
import com.watschman.jobs.reference.Reference;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Jobs {

    @Mod.Instance(Reference.MOD_ID)
    public static Jobs instance;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        ModConfiguration.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(ModConfiguration.instance);
    }
}
