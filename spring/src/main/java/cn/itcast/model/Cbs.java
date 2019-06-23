package cn.itcast.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cbs {
    private List<Object> list;
    private Object[] array;
    private Map<String,Object> map;
    private Set<Object> set;

    public Cbs() {
    }

    public Cbs(List<Object> list, Object[] array, Map<String, Object> map, Set<Object> set) {
        this.list = list;
        this.array = array;
        this.map = map;
        this.set = set;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Set<Object> getSet() {
        return set;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Cbs{" +
                "list=" + list +
                ", array=" + Arrays.toString(array) +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
