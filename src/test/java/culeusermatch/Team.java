package culeusermatch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Team {

    private Integer id;

    private String teamName;

    //团队下的销售
//    public static Set<Saler> SALERS_SET = new HashSet<Saler>();

    //被分配过的线索ID
    public static Set<Integer> ASSIGNED_IDS_SET = new HashSet<Integer>();

    private Set<Saler> salerSet;

    public Set<Saler> getSalerSet() {
        return salerSet;
    }

    public void setSalerSet(Set<Saler> salerSet) {
        this.salerSet = salerSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
