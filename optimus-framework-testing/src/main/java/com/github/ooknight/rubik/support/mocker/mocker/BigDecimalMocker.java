package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.math.BigDecimal;

/**
 * BigDecimal对象模拟器
 */
public class BigDecimalMocker implements Mocker<BigDecimal> {

    @Override
    public BigDecimal mock(MockConfig mockConfig) {
        return BigDecimal.valueOf(RandomUtils.nextDouble(mockConfig.getDoubleRange()[0], mockConfig.getDoubleRange()[1]));
    }
}
