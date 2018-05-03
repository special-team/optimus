package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.util.Date;

/**
 * Date对象模拟器
 */
public class DateMocker extends AbstractDateMock implements Mocker<Date> {

    public DateMocker(String startTimePattern, String endTime) {
        super(startTimePattern, endTime);
    }

    @Override
    public Date mock(MockConfig mockConfig) {
        return new Date(RandomUtils.nextLong(startTime, endTime));
    }
}
