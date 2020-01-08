package moo.cloud.service.data.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class DataController {

    @GetMapping(path = "/department/info")
    public Map<String, Object> g0() {
        log.info("department info requesting...");
        Map<String, String> dummy = new HashMap<String, String>();
        dummy.put("uuid", "1001");
        dummy.put("name", "商用事业部");
        dummy.put("address", "东软软件园");

        Map<String, Object> m = new HashMap<String, Object> ();
        m.put("code", "0");
        m.put("message", "success");
        m.put("data", dummy);

        return m;
    }
}
