package com.vote.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询当前投票信息的包装类
 */
public class VoteResultCustom  extends VoteResult{

    // 包装当前的参赛选手名称
    private List<String> playerNames = new ArrayList<>();
    // 包装当前的选手的票数
    private List<Long> playerTickets = new ArrayList<>();

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public List<Long> getPlayerTickets() {
        return playerTickets;
    }

    public void setPlayerTickets(List<Long> playerTickets) {
        this.playerTickets = playerTickets;
    }
}
