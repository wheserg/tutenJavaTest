package com.tuten.rest.tuten;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.*;
@RestController
@CrossOrigin
public class TimeController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @PostMapping(value = "/utc", consumes = "application/json", produces = "application/json")
    public Map time(@RequestBody JSONObject params){
        String tiempo = (String) params.get("dato1");
        String localizacion = (String) params.get("dato2");
        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.parse(tiempo);
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        ZonedDateTime UtcDate = ZonedDateTime.now(ZoneId.of(localizacion)).with(fecha).withZoneSameInstant(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Map<String, Object> response = new LinkedHashMap<>();
        Map<String, Object> dateResult = new LinkedHashMap<>();
        dateResult.put("time", UtcDate.format(formatter));
        dateResult.put("timezone", "utc");
        response.put("response", dateResult);
        return response;

    }


}
