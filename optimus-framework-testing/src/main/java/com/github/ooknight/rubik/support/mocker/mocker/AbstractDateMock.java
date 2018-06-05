package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

abstract class AbstractDateMock {

    Long startTime;
    Long endTime;

    AbstractDateMock(String startTimePattern, String endTimePattern) {
        try {
            this.startTime = new SimpleDateFormat("yyyy-MM-dd").parse(startTimePattern).getTime();
            this.endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endTimePattern).getTime();
        } catch (ParseException e) {
            throw new MockException("时间格式设置错误，设置如下格式yyyy-MM-dd ", e);
        }
    }
}
