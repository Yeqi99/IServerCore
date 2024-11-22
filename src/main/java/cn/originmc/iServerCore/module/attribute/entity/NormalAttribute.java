package cn.originmc.iServerCore.module.attribute.entity;

import cn.originmc.iServerCore.IServerCore;
import org.bukkit.event.Listener;

public abstract class NormalAttribute<T> implements ServerAttribute<T>, Listener {
    public NormalAttribute(){
        IServerCore.attributes.put(this.getEnum(),this);
        IServerCore.plugin.getServer().getPluginManager().registerEvents(this, IServerCore.plugin);
    }
}
