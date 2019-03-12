package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.MockException;
import com.github.ooknight.rubik.support.mocker.util.DateTool;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Date对象模拟器
 */
@SuppressWarnings("Duplicates")
public class DateMocker implements Mocker<Date> {

    @Override
    public Date mock(DataConfig mockConfig) {
        long startTime;
        long endTime;
        try {
            startTime = DateTool.getString2DateAuto(mockConfig.dateRange()[0]).getTime();
            endTime = DateTool.getString2DateAuto(mockConfig.dateRange()[1]).getTime();
        } catch (ParseException e) {
            throw new MockException("不支持的日期格式，或者使用了错误的日期", e);
        }
        return new Date(RandomUtils.nextLong(startTime, endTime));
    }
}
