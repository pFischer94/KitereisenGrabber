package de.vw.f73.kitereisen.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoaderController {

    @Autowired
    private LoaderService loaderService;

    @GetMapping("/getAllStatistics")
    public void getAllStatistics() {
        this.loaderService.getAllStatistics();
    }
}
