package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeMocker implements Mocker<LocalDateTime> {

    @Override
    public LocalDateTime mock(MockConfig mockConfig) {
        return LocalDateTime.ofEpochSecond(RandomUtils.nextLong(-62167219200L, 253402300799L), 0, ZoneOffset.UTC);
    }
}
