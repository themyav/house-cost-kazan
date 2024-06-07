package com.ml.housecost.controller;

import com.ml.housecost.Request;
import com.ml.housecost.message.RPCClient;
import com.ml.housecost.service.DistrictService;
import com.ml.housecost.service.ResComplexService;
import com.ml.housecost.service.StreetService;
import com.ml.housecost.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping("/prices")
public class CostController {
    private final StreetService streetService;
    private final DistrictService districtService;
    private final ResComplexService resComplexService;
    private final SubwayService subwayService;

    public CostController(StreetService streetService, DistrictService districtService, ResComplexService resComplexService, SubwayService subwayService) {
        this.streetService = streetService;
        this.districtService = districtService;
        this.resComplexService = resComplexService;
        this.subwayService = subwayService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("streets", streetService.getAll());
        model.addAttribute("districts", districtService.getAll());
        model.addAttribute("res_comps", resComplexService.getAll());
        model.addAttribute("subways", subwayService.getAll());
        return "main";
    }
    @PostMapping(value = "/getPrice")
    public String getCost(@RequestBody Request request, Model model){
        System.out.println(request);
        AtomicReference<Integer> cost = null;//request.rooms_count * 1000;
        try {
            cost = RPCClient.getPrice(request);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error!"); //TODO
        }
        model.addAttribute("cost", cost == null ? 0 : cost.get());
        return "frag/ajaxCost :: house-cost";
        //return "cost :: #price"; // Return only the fragment to update
    }
}