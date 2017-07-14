package org.kingszelda;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by shining.cui on 2017/7/15.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("index")
    public Map<String, String> index() {
        logger.info("进入index函数");
        Map<String, String> map = Maps.newHashMap();
        map.put("hello", "kingszelda");
        return map;
    }

}
