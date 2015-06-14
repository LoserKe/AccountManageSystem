package com.softwareengineering.accountmanager.controller;
import com.softwareengineering.accountmanager.model.DatabaseManager;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {
    private DatabaseManager DB;
    @RequestMapping("/main")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DB =new DatabaseManager();
        ModelAndView mv = new ModelAndView();
        String account_name = req.getParameter("account_name");
        Double balance = DB.queryBalance(account_name);
        List<PurchaseRecord> record = DB.queryPurchaseRecordByAccountName(account_name);
        mv.addObject("account_name",account_name);
        mv.addObject("balance",balance);
        mv.addObject("record",record);
        mv.setViewName("main");
        return mv;
    }
}