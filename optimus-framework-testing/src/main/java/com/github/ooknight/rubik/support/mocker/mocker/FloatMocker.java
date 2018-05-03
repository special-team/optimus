package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Float对象模拟器
 */
public class FloatMocker implements Mocker<Float> {

    @Override
    public Float mock(MockConfig mockConfig) {
        return RandomUtils.nextFloat(mockConfig.getFloatRange()[0], mockConfig.getFloatRange()[1]);
    }
}
