package org.kingszelda.version3.controller;

import com.google.common.collect.Maps;
import org.kingszelda.version3.service.CalculateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by shining.cui on 2017/7/15.
 */
@RestController("calculateControllerV3")
@RequestMapping("version3")
public class CalculateController {

    @Resource
    private CalculateService calculateServiceV3;

    @RequestMapping("add")
    public Map<String, String> add(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateServiceV3.add(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }

    @RequestMapping("sub")
    public Map<String, String> sub(int first, int second) {
        Map<String, String> result = Maps.newHashMap();
        int addResult = calculateServiceV3.sub(first, second);
        result.put("result", String.valueOf(addResult));
        return result;
    }
}
