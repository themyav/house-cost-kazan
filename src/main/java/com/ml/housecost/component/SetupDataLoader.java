package com.ml.housecost.component;
import com.ml.housecost.repository.SubwayRepo;
import com.ml.housecost.service.DistrictService;
import com.ml.housecost.service.ResComplexService;
import com.ml.housecost.service.StreetService;
import com.ml.housecost.service.SubwayService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private final SubwayService subwayService;
    private final StreetService streetService;
    private final DistrictService districtService;
    private final ResComplexService resComplexService;




    public SetupDataLoader(SubwayService subwayRepo, StreetService streetService, DistrictService districtService, ResComplexService resComplexService) {
        this.subwayService = subwayRepo;
        this.streetService = streetService;
        this.districtService = districtService;
        this.resComplexService = resComplexService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) return;
        subwayService.fillAll();
        streetService.fillAll();
        districtService.fillAll();
        resComplexService.fillAll();

    }
}