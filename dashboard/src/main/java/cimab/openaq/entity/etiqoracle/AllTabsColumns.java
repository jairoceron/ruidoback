package cimab.openaq.entity.etiqoracle;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@IdClass(AllTabsColumnsPK.class)
@Entity
@NamedQuery(name="AllTabsColumns.findAll", query="SELECT c FROM AllTabsColumns c")
@Table(name = "ALL_TAB_COLS")
public class AllTabsColumns {
    @Id
    @Column(name = "TABLE_NAME")
    String TABLE_NAME;   // VARCHAR2

    @Id
    @Column(name = "COLUMN_NAME")
    String COLUMN_NAME;   // VARCHAR2

    @Column(name = "OWNER")
    String OWNER;       // VARCHAR2

    @Column(name = "DATA_TYPE")
    String DATA_TYPE;   // VARCHAR2

    @Column(name = "DATA_TYPE_MOD")
    String DATA_TYPE_MOD; // VARCHAR2

    @Column(name = "DATA_TYPE_OWNER")
    String DATA_TYPE_OWNER;   // VARCHAR2

    @Column(name = "DATA_LENGTH")
    Integer DATA_LENGTH;   // NUMBER

    @Column(name = "DATA_PRECISION")
    Integer DATA_PRECISION; // NUMBER

    @Column(name = "DATA_SCALE")
    Integer DATA_SCALE; // NUMBER

    @Column(name = "NULLABLE")
    String NULLABLE; // VARCHAR2

    @Column(name = "COLUMN_ID")
    Integer COLUMN_ID; // NUMBER

    @Column(name = "DEFAULT_LENGTH")
    Integer DEFAULT_LENGTH; // NUMBER

    //  @Column(name = "DATA_DEFAULT")
    //  Long DATA_DEFAULT; // LONG

    @Column(name = "NUM_DISTINCT")
    Integer NUM_DISTINCT; // NUMBER

    @Column(name = "LOW_VALUE")
    String LOW_VALUE; // RAW

    @Column(name = "HIGH_VALUE")
    String HIGH_VALUE; // RAW

    @Column(name = "DENSITY")
    Integer DENSITY;   // NUMBER

    @Column(name = "NUM_NULLS")
    Integer NUM_NULLS; // NUMBER

    @Column(name = "NUM_BUCKETS")
    Integer NUM_BUCKETS;   // NUMBER

    @Column(name = "LAST_ANALYZED")
    Date LAST_ANALYZED; // DATE

    @Column(name = "SAMPLE_SIZE")
    Integer SAMPLE_SIZE;   // NUMBER

    @Column(name = "CHARACTER_SET_NAME")
    String CHARACTER_SET_NAME; // VARCHAR2

    @Column(name = "CHAR_COL_DECL_LENGTH")
    Integer CHAR_COL_DECL_LENGTH; // NUMBER

    @Column(name = "GLOBAL_STATS")
    String GLOBAL_STATS; // VARCHAR2

    @Column(name = "USER_STATS")
    String USER_STATS; // VARCHAR2

    @Column(name = "AVG_COL_LEN")
    Integer AVG_COL_LEN;  // NUMBER

    @Column(name = "CHAR_LENGTH")
    Integer CHAR_LENGTH; // NUMBER

    @Column(name = "CHAR_USED")
    String CHAR_USED; // VARCHAR2

    @Column(name = "V80_FMT_IMAGE")
    String V80_FMT_IMAGE; // VARCHAR2

    @Column(name = "DATA_UPGRADED")
    String DATA_UPGRADED; // VARCHAR2

    @Column(name = "HIDDEN_COLUMN")
    String HIDDEN_COLUMN; // VARCHAR2

    @Column(name = "VIRTUAL_COLUMN")
    String VIRTUAL_COLUMN; // VARCHAR2

    @Column(name = "SEGMENT_COLUMN_ID")
    Integer SEGMENT_COLUMN_ID; // NUMBER

    @Column(name = "INTERNAL_COLUMN_ID")
    Integer INTERNAL_COLUMN_ID; // NUMBER

    @Column(name = "HISTOGRAM")
    String HISTOGRAM; // VARCHAR2

    @Column(name = "QUALIFIED_COL_NAME")
    String QUALIFIED_COL_NAME; // VARCHAR2
}
