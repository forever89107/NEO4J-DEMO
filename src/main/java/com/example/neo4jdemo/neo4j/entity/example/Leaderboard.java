package com.example.neo4jdemo.neo4j.entity.example;

import java.util.Set;

/**
 * 排行榜 - 抽象類別
 */
public abstract class Leaderboard {
    // 總榜
    public abstract Set<Long> totalRanking();

    // 月榜
    public abstract Set<Long> monthRanking();

    // 周榜
    public abstract Set<Long> weekRanking();

    // 日榜
    public abstract Set<Long> dailyRanking();
}
