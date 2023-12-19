package ru.t1murcoder.textquest.domain;

public class Situation {
    public Situation[] direction;
    public String text;
    public int dHappiness;
    public int dPopulation;
    public int dMoney;
    public Situation (String text, int variants, int dHappiness,int dPopulation,int dMoney) {
        this.text=text;
        this.dHappiness=dHappiness;
        this.dPopulation=dPopulation;
        this.dMoney=dMoney;
        direction=new Situation[variants];
    }
}