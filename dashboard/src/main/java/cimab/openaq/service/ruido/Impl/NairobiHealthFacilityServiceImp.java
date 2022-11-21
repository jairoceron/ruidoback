package cimab.openaq.service.ruido.Impl;

import cimab.openaq.entity.ruido.NairobiHealthFacility;
import cimab.openaq.repository.ruido.NairobiHealthFacilityRepository;
import cimab.openaq.service.ruido.NairobiHealthFacilityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NairobiHealthFacilityServiceImp implements NairobiHealthFacilityService {

    @Autowired
    private NairobiHealthFacilityRepository nairobiHealthFacilityRepository;

    public List<NairobiHealthFacility> findAll() {
        return  nairobiHealthFacilityRepository.findAll();
    }

    public NairobiHealthFacility findById(int id) throws NotFoundException {
        return nairobiHealthFacilityRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Health Facility with ID: " + id + " not found.")
        );
    }

    @Override
    public List<NairobiHealthFacility> findAllHospitalsWithinSubCounty(int subCountyId) {
        return nairobiHealthFacilityRepository.findAllHospitalsWithinSubCounty(subCountyId);
    }

    @Override
    public List<NairobiHealthFacility> findAllHospitalsByDistanceFromUser(Double userLongitude, Double userLatitude) {
        return nairobiHealthFacilityRepository.findAllHospitalsByDistanceFromUser(userLongitude,userLatitude);
    }
    public void deleteById(int id) {
        nairobiHealthFacilityRepository.deleteById(id);
    }

}
