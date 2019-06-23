package cn.itcast.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanFactory {

    private static Properties pp = new Properties();
    private static Map<String, Object> beans = new HashMap<>();

    static {
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
        try {
            pp.load(in);
            Set<Object> keySet = pp.keySet();
            for (Object key : keySet) {
                String value = (String) pp.get(key);
                Object object = Class.forName(value).newInstance();
                beans.put(key.toString(), object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object getBean(String name) {
        return beans.get(name);
    }
}
