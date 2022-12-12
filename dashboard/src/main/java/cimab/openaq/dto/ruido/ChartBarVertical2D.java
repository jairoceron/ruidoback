package cimab.openaq.dto.ruido;

import lombok.Data;

import java.util.List;

@Data
public class ChartBarVertical2D {
    String name;
    List<ChartGenerico> series;
}
