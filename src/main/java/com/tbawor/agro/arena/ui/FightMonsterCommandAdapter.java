package com.tbawor.agro.arena.ui;

import com.tbawor.agro.arena.application.command.FightMonsterCommand;

public class FightMonsterCommandAdapter implements FightMonsterCommand {

    private final Integer monsterId;
    private final String heroOwnerLogin;

    public FightMonsterCommandAdapter(Integer monsterId, String heroOwnerLogin) {
        this.monsterId = monsterId;
        this.heroOwnerLogin = heroOwnerLogin;
    }

    @Override
    public String getHeroOwnerLogin() {
        return heroOwnerLogin;
    }

    @Override
    public Integer getMonsterId() {
        return monsterId;
    }
}
