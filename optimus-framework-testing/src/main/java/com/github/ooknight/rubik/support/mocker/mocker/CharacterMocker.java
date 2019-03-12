package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker implements Mocker<Character> {

    @Override
    public Character mock(DataConfig mockConfig) {
        char[] charSeed = mockConfig.charSeed();
        return charSeed[RandomUtils.nextInt(0, charSeed.length)];
    }
}
