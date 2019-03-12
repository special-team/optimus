package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.math.BigDecimal;

/**
 * Double对象模拟器
 */
public class DoubleMocker implements Mocker<Double> {

    @Override
    public Double mock(DataConfig mockConfig) {
        return new BigDecimal(RandomUtils.nextDouble(mockConfig.doubleRange()[0], mockConfig.doubleRange()[1])).setScale(mockConfig.decimalScale(), BigDecimal.ROUND_FLOOR).doubleValue();
    }
}
