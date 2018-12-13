package com.wkodate.qiitarank.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ItemFetcher {

    private static final Logger LOG = LoggerFactory.getLogger(ItemFetcher.class);

    private static final String ENDPOINT = "/api/v2/items";

    private static final String QUERY_PARAMETER = "?page=1&per_page=5";

    @Value("${host}")
    private String host;

    @Scheduled(fixedRate = 5000)
    public void fetchItems() {
        RestTemplate restTemplate = new RestTemplate();
        String items = restTemplate.getForObject(host + ENDPOINT + QUERY_PARAMETER, String.class);

        LOG.info(items);
    }
}
