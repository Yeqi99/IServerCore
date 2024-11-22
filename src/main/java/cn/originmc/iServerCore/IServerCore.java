package cn.originmc.iServerCore;

import cn.originmc.iServerCore.lang.LangLoader;
import cn.originmc.iServerCore.utils.AttributeUtil;
import cn.originmc.iServerCore.module.attribute.ServerAttributeEnum;
import cn.originmc.iServerCore.module.attribute.entity.ServerAttribute;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public final class IServerCore extends JavaPlugin {
    public static JavaPlugin plugin;
    public static final Map<ServerAttributeEnum, ServerAttribute<?>> attributes = new ConcurrentHashMap<>();
    public static LangLoader lang;
    @Override
    public void onEnable() {
        plugin=this;
        saveDefaultConfig();
        loadOrReload();
    }

    @Override
    public void onDisable() {

    }

    public static void loadOrReload(){
        plugin.reloadConfig();
        lang=new LangLoader();
        AttributeUtil.registerAttributes();
    }
}
