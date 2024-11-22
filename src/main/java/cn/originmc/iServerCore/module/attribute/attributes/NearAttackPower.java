package cn.originmc.iServerCore.module.attribute.attributes;


import cn.originmc.iServerCore.IServerCore;
import cn.originmc.iServerCore.module.attribute.ServerAttributeEnum;
import cn.originmc.iServerCore.module.attribute.entity.impl.LongAttribute;
import cn.originmc.iServerCore.task.TaskManager;
import cn.originmc.iServerCore.utils.AttributeUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
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
        Entity origin=event.getEntity();
        Entity target=event.getDamager();
        String taskName = "battle:"+ AttributeUtil.generateBattleIdentifier(origin.getUniqueId().toString(),target.getUniqueId().toString());
        // 异步分发一个计算任务
        // TODO 实现异步任务分发系统
        TaskManager.TaskQueue battleQueue = IServerCore.taskManager.getOrCreateTaskQueue(taskName);
        battleQueue.submitTask(() -> {
            // 异步计算逻辑
            Bukkit.getScheduler().runTask(IServerCore.plugin, () -> {

            });
        });
        event.setDamage(0);
    }

}
