package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * 模拟Long对象
 */
public class LongMocker implements Mocker<Long> {

    @Override
    public Long mock(DataConfig mockConfig) {
        return RandomUtils.nextLong(mockConfig.longRange()[0], mockConfig.longRange()[1]);
    }
}
