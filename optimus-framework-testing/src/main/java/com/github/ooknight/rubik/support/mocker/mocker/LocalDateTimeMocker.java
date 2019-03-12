package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.MockException;
import com.github.ooknight.rubik.support.mocker.util.DateTool;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@SuppressWarnings("Duplicates")
public class LocalDateTimeMocker implements Mocker<LocalDateTime> {

    @Override
    public LocalDateTime mock(DataConfig config) {
        long endTime;
        long startTime;
        try {
            startTime = DateTool.getString2DateAuto(config.dateRange()[0]).getTime();
            endTime = DateTool.getString2DateAuto(config.dateRange()[1]).getTime();
        } catch (ParseException e) {
            throw new MockException("不支持的日期格式，或者使用了错误的日期", e);
        }
        return LocalDateTime.ofEpochSecond(RandomUtils.nextLong(startTime, endTime), 0, ZoneOffset.UTC);
    }
}
