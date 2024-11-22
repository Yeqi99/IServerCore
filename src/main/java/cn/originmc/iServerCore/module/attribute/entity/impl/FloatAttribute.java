package cn.originmc.iServerCore.module.attribute.entity.impl;

import cn.originmc.iServerCore.module.attribute.entity.NormalAttribute;
import cn.originmc.iServerCore.module.attribute.entity.ServerAttribute;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;

import static cn.originmc.iServerCore.IServerCore.plugin;

public abstract class FloatAttribute extends NormalAttribute<Float> {
    @Override
    public void setAttribute(PersistentDataHolder target, Float value) {
        PersistentDataContainer dataContainer = target.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, getEnum().name());
        dataContainer.set(key, PersistentDataType.FLOAT, value);
    }

    @Override
    public Float getAttribute(PersistentDataHolder target) {
        PersistentDataContainer dataContainer = target.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, getEnum().name());
        return dataContainer.get(key, PersistentDataType.FLOAT);
    }

    @Override
    public boolean hasAttribute(PersistentDataHolder target) {
        PersistentDataContainer dataContainer = target.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, getEnum().name());
        return dataContainer.has(key);
    }
}
