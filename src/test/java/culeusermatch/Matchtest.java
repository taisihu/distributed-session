package culeusermatch;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Matchtest {


    /**
     * 2017-02-28 21:59 逻辑有问题，无线死循环,i=0???
     * @param args
     */
    public static void main(String[] args){

        int defalut_avg_count = 3;//每个销售默认条数
        int max_assing_times = 3;//每个公司每条线索最多分配多少次
        int new_second_rage = 4;//新房:二手房=4:6
        int team_count = 0;//团队个数
        int avg_count = 0;//*线索不够情况下，每个销售条数，需要计算
        int currentCulesIdx = 0;//当前遍历到线索第几条，用来减少线索重复使用,提高线索利用率

        Company company = new Company();
        company.setId(1);
        company.setCompanyName("company_1");

        Matchtest matchtest = new Matchtest();

        //线索
        List<IDPair> clues = matchtest.buildClues();

        //团队
        Map<Integer,Team> teams = matchtest.getTeamsSalers();

        List<Saler> salers = new ArrayList<Saler>();
        Map<Integer,List<Saler>> team_saler_cule_map = new HashMap<Integer,List<Saler>>();

        //获得整个团队的成员,已去重
        for(Map.Entry<Integer,Team> map : teams.entrySet()){
            Team team = map.getValue();
            salers.addAll(new ArrayList<Saler>(team.getSalerSet()));
        }

        //每个人能分配到的线索条数:线索总数/团队总人数
//        int count = clues.size()/team_count;
//        avg_count =  count>defalut_avg_count?defalut_avg_count:count;



        //为用户分配线索
        for(int i=0;i<salers.size();i++){
            Saler saler = salers.get(i);

            for(int j=0;j<clues.size();j++){

                int k = i*defalut_avg_count+j;

                if(k>=clues.size()){
                    k=k-i*defalut_avg_count;
                }

                IDPair idPair = clues.get(k);

                //判断用户线索长度
                Set<IDPair> saler_clues = salers.get(i).getCLUE_SET();
                if(saler_clues.size()>=defalut_avg_count){
                    break;
                }
                //查看该团队是否被分配过
                Map<Integer,Integer> useCount = company.getClue_count();
                //如果该线索在该公司分配过5次就跳过
                if(null!=useCount.get(idPair.getId())){
                    if(useCount.get(idPair.getId())>=max_assing_times){
                        continue;
                    }
                }
                Map<Integer,Integer> useTeam = company.getUse_team();
                //判断是否给这个团队分配过
                if(useTeam.size()>0 && null!=useTeam.get(idPair.getId()) && (saler.getTeamId()==useTeam.get(idPair.getId()))){
                    continue;
                }

                //此处为set，自动去重，分配完成需要检查用户线索个数
                boolean assign_succ = saler.addClue(idPair);
                //判断插入为重复数据的话，再重新插入一遍
                if(!assign_succ){
                    continue;
                }

                //标记该线索分配给某个team过
                company.setUse_team(idPair.getId(),saler.getTeamId());
                //标记该线索在此公司使用次数
                company.setClue_count(idPair.getId());
            }
        }


        //将销售根据teamId归类
        for(Saler saler : salers){
            List<Saler> salerList =  team_saler_cule_map.get(saler.getTeamId());
            if(CollectionUtils.isEmpty(salerList)){
                salerList = new ArrayList<Saler>();
                salerList.add(saler);
            }else{
                salerList.add(saler);
            }
            team_saler_cule_map.put(saler.getTeamId(),salerList);
        }

        CuleResult.result.put(company.getId(),team_saler_cule_map);

//        for(Map.Entry<Integer,Map<Integer,List<Saler>>> map : CuleResult.result.entrySet()){
//            for(Map.Entry<Integer,List<Saler>> map1 : map.getValue().entrySet()){
//                List<Saler> salers1 = map1.getValue();
//                for(Saler saler : salers1){
//                    System.out.println("=================================team:"+saler.getTeamId()+"-saler:"+saler.getSalerName());
//                    for(IDPair idPair : saler.getCLUE_SET()){
//                        System.out.println(idPair.getId());
//                    }
//                }
//            }
//
//        }


        for(Map.Entry<Integer,Map<Integer,List<Saler>>> map : CuleResult.result.entrySet()){
            for(Map.Entry<Integer,List<Saler>> map1 : map.getValue().entrySet()){
                List<Saler> salers1 = map1.getValue();
                System.out.println("============team:"+map1.getKey()+"==============");
                String s = "";
                for(Saler saler : salers1){
                    for(IDPair idPair : saler.getCLUE_SET()){
                        s += idPair.getId() + " ";
                    }
                }
                System.out.println(s);
            }

        }

        //个人不能重复
        //团队中的id不能重复
        //标记团队用过的id
        //标记线索被分配的次数
        //循环分配，标记线索
        //设置用户线索，标记用户
    }

    public List<IDPair> buildClues(){
        List<IDPair> list = Lists.newArrayList();
        for(int i=1;i<=9;i++){
            IDPair idPair = new IDPair();
            idPair.setId(i);
            idPair.setValue(i);
//            idPair.setWeight(3);

            list.add(idPair);
        }
        return list;
    }


    public Map<Integer,Team> getTeamsSalers(){

        Map<Integer,Team> map = new HashMap<Integer,Team>();
        for(int i=1;i<=6;i++){
            Team team = new Team();
            team.setId(i);
            team.setTeamName("team_"+i);
            Set<Saler> salers = new HashSet<Saler>();
            for(int j=1;j<=2;j++){
                Saler saler = new Saler();
                saler.setId((i-1)*2+j);
                saler.setSalerName("saller_" + j);
                saler.setTeamId(i);
                salers.add(saler);
            }
            team.setSalerSet(salers);
            map.put(i,team);
        }
        return map;

    }


}
