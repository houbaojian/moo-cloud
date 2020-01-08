package moo.cloud.service.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/gateway")
public class ServiceController {
    @GetMapping(path = "/user/info")
    public Map<String, Object> g0() {
        log.info("user info requesting...");
        Map<String, String> dummy = new HashMap<String, String>();
        dummy.put("uuid", "1001");
        dummy.put("username", "houbj");
        dummy.put("name", "侯宝健");
        dummy.put("age", "25");
        dummy.put("address", "沈阳");
        dummy.put("school", "工大");
        dummy.put("sex", "0");

        Map<String, Object> m = new HashMap<String, Object> ();
        m.put("code", "0");
        m.put("message", "success");
        m.put("data", dummy);

        return m;
    }
}
