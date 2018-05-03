package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * 模拟Long对象
 */
public class LongMocker implements Mocker<Long> {

    @Override
    public Long mock(MockConfig mockConfig) {
        return RandomUtils.nextLong(mockConfig.getLongRange()[0], mockConfig.getLongRange()[1]);
    }
}
