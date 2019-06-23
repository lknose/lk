package cn.itcast.core;

public interface SqlSession {
    /**
     * 声明获取Mapper实例的方法,参数必须是接口,目的是创建接口的实现类,使用代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz);
}
