package org.kingszelda.version2.controller;

import com.google.common.collect.Maps;
import org.kingszelda.version2.service.CalculateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by shining.cui on 2017/7/15.
 */
@RestController("calculateControllerV2")
@RequestMapping("version2")
public class CalculateController {

    @Resource
    private CalculateService calculateServiceV2;

    @RequestMapping("add")
    public Map<String, String> add(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateServiceV2.add(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }

    @RequestMapping("sub")
    public Map<String, String> sub(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateServiceV2.sub(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }
}
