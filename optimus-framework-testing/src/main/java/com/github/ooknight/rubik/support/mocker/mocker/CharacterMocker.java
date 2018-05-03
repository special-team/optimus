package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker implements Mocker<Character> {

    @Override
    public Character mock(MockConfig mockConfig) {
        char[] charSeed = mockConfig.getCharSeed();
        return charSeed[RandomUtils.nextInt(0, charSeed.length)];
    }
}
