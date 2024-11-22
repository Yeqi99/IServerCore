package cn.originmc.iServerCore.lang;

import cn.originmc.iServerCore.IServerCore;
import cn.originmc.iServerCore.utils.config.YamlManager;

public class LangLoader {
    public YamlManager yamlManager;
    public LangLoader() {
        yamlManager=new YamlManager(IServerCore.plugin,"lang",true);
    }
    public String getLang(String langType,String textKey,String defaultText){
        return (String) yamlManager.get(langType,textKey,defaultText);
    }
    public String getLang(String textKey,String defaultText){
        return (String) yamlManager.get(IServerCore.plugin.getConfig().getString(textKey),defaultText);
    }
}
