package net.hk.mvcc.controller;

import net.hk.mvcc.pojo.DataTest;
import net.hk.mvcc.service.DataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("access")
public class DataAccessController extends BaseController {

    @Autowired
    private DataAccessService dataAccessService;

    @RequestMapping("listdata")
    public String listData(final ModelMap model){

        List<DataTest> dataTestList = dataAccessService.listData();

        model.addAttribute("dataTestList", dataTestList);

        return JSON_VIEW;

    }

    @RequestMapping("updatenumber")
    public String updateNumber(HttpServletRequest request,
                               HttpServletResponse response,
                                @RequestParam(value = "id", required=false,defaultValue ="0") int id,
                                final ModelMap model){
        DataTest dataTest = dataAccessService.findById(id);
        dataTest.setNumber(dataTest.getNumber()+1);
        try {
            dataAccessService.updateNumber(dataTest);
            model.addAttribute("msg", "更新成功");
        } catch (Exception e) {
            model.addAttribute("msg","更新失败======================");
//            e.printStackTrace();
        }


        return JSON_VIEW;
    }

    @RequestMapping("updnumwithretry")
    public String updNumWithRetry(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam(value = "id", required=false,defaultValue ="0") int id,
                               final ModelMap model){
        try {
            dataAccessService.updNumWithRetry(id);
            model.addAttribute("msg", "更新成功");
        } catch (Exception e) {
            model.addAttribute("msg","更新失败======================");
//            e.printStackTrace();
        }


        return JSON_VIEW;
    }


}
