package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.math.BigInteger;

/**
 * BigInteger对象模拟器
 */
public class BigIntegerMocker implements Mocker<BigInteger> {

    @Override
    public BigInteger mock(MockConfig mockConfig) {
        return BigInteger.valueOf(RandomUtils.nextLong(mockConfig.getLongRange()[0], mockConfig.getLongRange()[1]));
    }
}
