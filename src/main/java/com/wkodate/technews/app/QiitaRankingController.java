package com.wkodate.technews.app;

import com.wkodate.technews.domain.model.Item;
import com.wkodate.technews.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QiitaRankingController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getLikesRanking(Model model) {
        Iterable<Item> dailyItems = itemService.sortDailyByLikes();
        Iterable<Item> weeklyItems = itemService.sortWeeklyByLikes();
        model.addAttribute("dailyItems", dailyItems);
        model.addAttribute("weeklyItems", weeklyItems);
        return "ranking";
    }

}
