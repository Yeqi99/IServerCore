package cn.originmc.iServerCore.utils;


import cn.originmc.iServerCore.IServerCore;
import cn.originmc.iServerCore.module.attribute.ServerAttributeEnum;
import cn.originmc.iServerCore.module.attribute.attributes.NearAttackPower;

import java.util.Arrays;

public class AttributeUtil {
    public static void registerAttributes() {
        new NearAttackPower();
    }
    public static <T> T getDefaultAttributeValue(ServerAttributeEnum serverAttributeEnum, Class<T> type, T defaultValue) {

        // 从配置文件中获取值，根据传入的类型进行转换
        Object value = IServerCore.plugin.getConfig().get("default_attribute." + serverAttributeEnum.name());

        if (value == null) {
            return defaultValue;
        }

        // 尝试将对象转换为所需的类型
        try {
            return type.cast(value);
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }
    public static String generateBattleIdentifier(String name1, String name2) {
        String[] names = {name1, name2};
        Arrays.sort(names);
        return names[0] + "_" + names[1];
    }
}
