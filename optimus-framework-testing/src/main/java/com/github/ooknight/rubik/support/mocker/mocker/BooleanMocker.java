package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker implements Mocker<Boolean> {

    @Override
    public Boolean mock(DataConfig mockConfig) {
        boolean[] booleanSeed = mockConfig.booleanSeed();
        return booleanSeed[RandomUtils.nextInt(0, booleanSeed.length)];
    }
}
