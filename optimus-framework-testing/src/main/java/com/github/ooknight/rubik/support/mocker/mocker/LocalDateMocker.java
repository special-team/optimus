package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.time.LocalDate;

@SuppressWarnings("Duplicates")
public class LocalDateMocker implements Mocker<LocalDate> {

    @Override
    public LocalDate mock(DataConfig config) {
        //long startTime;
        //long endTime;
        //try {
        //    startTime = DateTool.getString2DateAuto(config.dateRange()[0]).getTime();
        //    endTime = DateTool.getString2DateAuto(config.dateRange()[1]).getTime();
        //} catch (ParseException e) {
        //    throw new MockException("不支持的日期格式，或者使用了错误的日期", e);
        //}
        return LocalDate.ofEpochDay(RandomUtils.nextLong(0, 99999));
    }
}
