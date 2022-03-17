package com.zzs.shardingJdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BirthdayAlgorithm implements PreciseShardingAlgorithm<Date> {

    List<Date> dateList = new ArrayList<>();
    {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2022, 1, 1, 0, 0, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2023, 1, 1, 0, 0, 0);
        dateList.add(calendar2.getTime());
        dateList.add(calendar3.getTime());
    }

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        // 获取属性数据库的值
        Date date = preciseShardingValue.getValue();
        // 获取数据源的名称信息列表
        Iterator<String> iterator = collection.iterator();
        String target = null;
        for (Date s : dateList) {
            target = iterator.next();
            // 如果数据晚于指定的日期直接返回
            if (date.before(s)) {
                break;
            }
        }
        return target;
    }
}
