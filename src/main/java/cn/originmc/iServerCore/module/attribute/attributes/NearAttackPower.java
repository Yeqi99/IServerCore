package cn.originmc.iServerCore.module.attribute.attributes;


import cn.originmc.iServerCore.IServerCore;
import cn.originmc.iServerCore.module.attribute.ServerAttributeEnum;
import cn.originmc.iServerCore.module.attribute.entity.impl.LongAttribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class NearAttackPower extends LongAttribute {


    @Override
    public String getDisplayName() {
        return IServerCore.lang.getLang("attributes.NEAR_ATTACK_POWER","近身攻击");
    }

    @Override
    public ServerAttributeEnum getEnum() {
        return ServerAttributeEnum.NEAR_ATTACK_POWER;
    }

    @EventHandler
    public void onNearAttackPower(EntityDamageByEntityEvent event){
        // 异步分发一个计算任务
        // TODO 实现异步任务分发系统
        event.setDamage(0);
    }

}
