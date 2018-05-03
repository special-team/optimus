package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.time.LocalDate;

public class LocalDateMocker implements Mocker<LocalDate> {

    @Override
    public LocalDate mock(MockConfig mockConfig) {
        return LocalDate.ofEpochDay(RandomUtils.nextLong(-719528L, 2932896L));
    }
}
