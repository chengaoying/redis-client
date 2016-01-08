package com.dashuju.redis.client.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化与反序列化工具类
 * @author CGY
 * @date 2016-1-8
 */
public class SerializeUtil {

	/**
	 * 序列化对象
	 * @param object  被序列化对象
	 * @return byte[] 字节数组
	 */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
        	
        } finally{
        	try {
        		if(oos != null){
        			oos.close();
        		}
			} catch (IOException e) {}
        	try {
        		if(baos != null){
            		baos.close();
            	}
			} catch (IOException e) {}
        }
        return null;

    }

    /**
     * 反序列化对象
     * @param bytes 字节数组
     * @return obj  反序列化生成的对象
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
        	
        } finally{
        	try {
        		if(ois != null){
        			ois.close();
        		}
			} catch (IOException e) {}
        	try {
        		if(bais != null){
        			bais.close();
            	}
			} catch (IOException e) {}
        }
        return null;
    }

}