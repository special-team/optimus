package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

    @Override
    public Integer mock(DataConfig mockConfig) {
        return RandomUtils.nextInt(mockConfig.intRange()[0], mockConfig.intRange()[1]);
    }
}
