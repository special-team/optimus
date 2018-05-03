package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker implements Mocker<Boolean> {

    @Override
    public Boolean mock(MockConfig mockConfig) {
        return RandomUtils.nextBoolean();
    }
}
