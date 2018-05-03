package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * 模拟Short对象
 */
public class ShortMocker implements Mocker<Short> {

    @Override
    public Short mock(MockConfig mockConfig) {
        return (short) RandomUtils.nextInt(mockConfig.getShortRange()[0], mockConfig.getShortRange()[1]);
    }
}
