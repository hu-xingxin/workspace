package com.basictest.inet.chatroom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 扩展HashMap类 ,不允许value重复,提供根据value获取key  根据value删除key的方法
 * @author: hxx
 * @create: 2021-05-12 15:01
 **/
public class SocketMap<K,V> extends HashMap<K,V> {

    /**
     * 根据value来删除指定项
     * @param value
     */
    public void removeByValue(Object value){
        for(Object key : keySet()){
            if (get(key) == value){
                remove(key);
            }
        }
    }

    /**
     * 获取所有value组成的Set集合
     * @return
     */
    public Set<V> valueSet(){
        Set<V> result = new HashSet<>();
        for(K key : keySet()){
            result.add(get(key));
        }
        return result;
    }

    /**
     * 根据value查找key
     * @param val
     * @return
     */
    public K getKeyByValue(V val){
        for(K key : keySet()){
            if(get(key).equals(val) && get(key)==val){
                return key;
            }
        }
        return null;
    }

    /**
     * 重写HashMap的put方法,不允许value重复
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value){
        for(V val : valueSet()){
            if(val.equals(value) && val.hashCode() == value.hashCode() ){
                throw new RuntimeException("SocketMap实例中不允许有重复value");
            }
        }
        return super.put(key,value);
    }
}
