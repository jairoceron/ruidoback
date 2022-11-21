package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.NairobiHealthFacility;
import javassist.NotFoundException;

import java.util.List;


public interface NairobiHealthFacilityService {
    List<NairobiHealthFacility> findAll();
    NairobiHealthFacility findById(int id) throws NotFoundException;
    List<NairobiHealthFacility> findAllHospitalsWithinSubCounty(int subCountyId);
    List<NairobiHealthFacility> findAllHospitalsByDistanceFromUser(Double userLongitude, Double userLatitude);
    void deleteById(int id);
}
