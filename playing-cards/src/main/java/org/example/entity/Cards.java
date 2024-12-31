package org.example.entity;

import org.example.enums.CardEnum;

public record Cards(
        CardEnum suit,
        int num,
        String StringNum
) {}
