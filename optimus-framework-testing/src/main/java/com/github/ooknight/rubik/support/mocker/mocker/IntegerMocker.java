package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

    @Override
    public Integer mock(MockConfig mockConfig) {
        return RandomUtils.nextInt(mockConfig.getIntRange()[0], mockConfig.getIntRange()[1]);
    }
}
