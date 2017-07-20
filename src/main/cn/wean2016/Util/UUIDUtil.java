package cn.wean2016.Util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getLongUUID(){
        return UUID.randomUUID().toString();
    }
}
