package culeusermatch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Saler {

    private Integer id;

    private String salerName;

    private Integer teamId;

    private Set<IDPair> CLUE_SET = new HashSet<IDPair>();

//    private Set<IDPair> clueSet;

//    public Set<IDPair> getClueSet() {
//        return clueSet;
//    }
//
//    public void setClueSet(Set<IDPair> clueSet) {
//        this.clueSet = clueSet;
//    }


    public Set<IDPair> getCLUE_SET() {
        return CLUE_SET;
    }

    public boolean addClue(IDPair clue) {
       return this.CLUE_SET.add(clue);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
