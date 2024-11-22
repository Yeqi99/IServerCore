package cn.originmc.iServerCore.module.attribute;

public enum ServerAttributeEnum {
    // 攻击属性分为近战和远程攻击力
    // 防御属性分为近战和远程防御力
    // HEALING_POWER 治疗力，每个恢复时间单位恢复的生命值（非战斗状态下） 每次恢复量= (治疗力/生命强度/2)
    // 影响对其他人治疗时计算无需/2  每次恢复量= (治疗力/生命强度)
    // LIFE_POWER 是生命强度，计算伤害时最终扣除的生命值= （总伤害/生命强度）
    // ESCAPE_POWER 逃脱能力  战斗状态逃脱的加速倍率
    NEAR_ATTACK_POWER,REMOTE_ATTACK_POWER,HEALING_POWER,
    NEAR_DEFENSE_POWER,REMOTE_DEFENSE_POWER,LIFE_POWER,
    ESCAPE_POWER,

    // 远近攻击的加速度，远近攻击的攻速系统逻辑:
    // 每个人默认的近战速度为1 远程速度为0.5
    // 记录上一次的对应类型的攻击时间戳，在下次攻击时检查是否已经超过了攻击间隔，相等则满额伤害
    // 超过CRITICAL_STRIKE_TIME属性则根据CRITICAL_STRIKE_POWER属性计算暴击伤害
    NEAR_ATTACK_SPEED,REMOTE_ATTACK_SPEED,CRITICAL_STRIKE_POWER,CRITICAL_STRIKE_TIME
}
