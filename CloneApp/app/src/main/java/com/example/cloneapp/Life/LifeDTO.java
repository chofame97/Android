package com.example.cloneapp.Life;

public class LifeDTO {
    private String top_subtitle;
    private String life_top1,life_top2,life_top3,life_top4;

    public LifeDTO(String top_subtitle) {
        this.top_subtitle = top_subtitle;
    }

    public LifeDTO(String life_top1, String life_top2, String life_top3, String life_top4) {
        this.life_top1 = life_top1;
        this.life_top2 = life_top2;
        this.life_top3 = life_top3;
        this.life_top4 = life_top4;
    }

    public LifeDTO() {
    }

    public String getTop_subtitle() {
        return top_subtitle;
    }

    public void setTop_subtitle(String top_subtitle) {
        this.top_subtitle = top_subtitle;
    }

    public String getLife_top1() {
        return life_top1;
    }

    public void setLife_top1(String life_top1) {
        this.life_top1 = life_top1;
    }

    public String getLife_top2() {
        return life_top2;
    }

    public void setLife_top2(String life_top2) {
        this.life_top2 = life_top2;
    }

    public String getLife_top3() {
        return life_top3;
    }

    public void setLife_top3(String life_top3) {
        this.life_top3 = life_top3;
    }

    public String getLife_top4() {
        return life_top4;
    }

    public void setLife_top4(String life_top4) {
        this.life_top4 = life_top4;
    }
}
