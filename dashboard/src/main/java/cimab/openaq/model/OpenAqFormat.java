package cimab.openaq.model;

import lombok.Data;

@Data
public class OpenAqFormat {
    // https://github.com/openaq/openaq-data-format
    private String parameter;
    private String location;
    private String city;
    private String country;
    private Double value;
    private String unit;
    private DateUtcLocal date;
    private String sourceName;
    private String sourceType;
    private Boolean mobile;
    private Location coordinates;
    private Attribution attribution;
    private AveragingPeriod averagingPeriod;
}
