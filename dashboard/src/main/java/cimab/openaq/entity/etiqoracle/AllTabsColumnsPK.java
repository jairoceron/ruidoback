package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@NoArgsConstructor

public class AllTabsColumnsPK implements Serializable {
    private String TABLE_NAME;  // VARCHAR2
    private String COLUMN_NAME;
}

