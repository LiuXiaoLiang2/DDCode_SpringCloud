package com.ddcode.openfeign.service;

import com.ddcode.openfeign.config.MultipartSupportConfig;
import com.ddcode.openfeign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "openfeign-quickstart-provider", configuration = MultipartSupportConfig.class)
public interface OrderService {

    @PostMapping(value = "/openfeign/provider6", produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String echo6(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name);

    @PostMapping("/openfeign/provider9")
    public String echo9(@SpringQueryMap User user);
}
