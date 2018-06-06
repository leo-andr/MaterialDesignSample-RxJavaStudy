package me.lipiao.material_design.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipiao
 * @date 2018/6/5.
 * @description 数据
 */
public class Utils {
    public static List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}
