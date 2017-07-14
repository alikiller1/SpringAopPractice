package org.kingszelda.version1.controller;

import com.google.common.collect.Maps;
import org.kingszelda.version1.service.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by shining.cui on 2017/7/15.
 */
@RestController
public class CalculateController {

    private static final Logger logger = LoggerFactory.getLogger(CalculateController.class);

    @Resource
    private CalculateService calculateService;

    @RequestMapping("add")
    public Map<String, String> add(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateService.add(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }

    @RequestMapping("sub")
    public Map<String, String> sub(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateService.sub(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }
}
