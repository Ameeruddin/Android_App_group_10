package com.example.shruthisports;

public class Sports {

    public Long sportId=(long)0;
    public String sportName="sairaam";
    public String sportCategory="door";
    Integer min_players=111;
    Integer max_players=111;

    public Sports(Long sportId, String sportName, String sportCategory,
                  Integer min_players, Integer max_players){
        this.sportId=sportId;
        this.sportName=sportName;
        this.sportCategory=sportCategory;
        this.min_players=min_players;
        this.max_players=max_players;
    }

}
