package cn.wean2016.UUIDUtil;

import cn.wean2016.Util.UUIDUtil;
import org.junit.Test;

public class testUUIDUtil {
    @Test
    public void test(){
        System.out.println(UUIDUtil.getUUID());
        System.out.println(UUIDUtil.getLongUUID());
    }
}
