package com.example.benawad.walkthroughretrofitlol;

import com.google.gson.annotations.Expose;

/**
 * Created by benawad on 7/5/15.
 */
public class Summoner {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private int profileIconId;
    @Expose
    private int summonerLevel;
    @Expose
    private int revisionDate;

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The profileIconId
     */
    public int getProfileIconId() {
        return profileIconId;
    }

    /**
     *
     * @param profileIconId
     * The profileIconId
     */
    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    /**
     *
     * @return
     * The summonerLevel
     */
    public int getSummonerLevel() {
        return summonerLevel;
    }

    /**
     *
     * @param summonerLevel
     * The summonerLevel
     */
    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    /**
     *
     * @return
     * The revisionDate
     */
    public int getRevisionDate() {
        return revisionDate;
    }

    /**
     *
     * @param revisionDate
     * The revisionDate
     */
    public void setRevisionDate(int revisionDate) {
        this.revisionDate = revisionDate;
    }

}
