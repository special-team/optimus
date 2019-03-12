package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;

import java.math.BigDecimal;

/**
 * BigDecimal对象模拟器
 */
public class BigDecimalMocker implements Mocker<BigDecimal> {

    @Override
    public BigDecimal mock(DataConfig mockConfig) {
        return BigDecimal.valueOf(mockConfig.global().getMocker(Double.class).mock(mockConfig));
    }
}
