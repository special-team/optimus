package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;

import java.math.BigInteger;

/**
 * BigInteger对象模拟器
 */
public class BigIntegerMocker implements Mocker<BigInteger> {

    @Override
    public BigInteger mock(DataConfig mockConfig) {
        return BigInteger.valueOf(mockConfig.global().getMocker(Long.class).mock(mockConfig));
    }
}
