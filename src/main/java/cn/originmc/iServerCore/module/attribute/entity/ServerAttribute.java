package cn.originmc.iServerCore.module.attribute.entity;

import cn.originmc.iServerCore.module.attribute.ServerAttributeEnum;
import org.bukkit.persistence.PersistentDataHolder;


public interface ServerAttribute<T> {
    String getDisplayName();
    ServerAttributeEnum getEnum();
    boolean hasAttribute(PersistentDataHolder persistentDataHolder);
    void setAttribute(PersistentDataHolder persistentDataHolder,T value);
    T getAttribute(PersistentDataHolder persistentDataHolder);
}
