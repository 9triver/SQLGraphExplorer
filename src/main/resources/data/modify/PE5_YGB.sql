/*
 修改自：PE5_YGB.sql
 */
create table LEDGERREPORT (
    ID VARCHAR2(255),
    TERM VARCHAR2(255),
    LEDGERREPORTTEMPLATE_ID VARCHAR2(255),
    INSTITUTION_ID VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table REPORTTEMPLATE (
    ID VARCHAR2(255),
    TABLENAME VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table INSTITUTION (
    ID VARCHAR2(255),
    INSTITUTIONID VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table EAST5_YGB (
    JRXKZH VARCHAR2(255),
    NBJGH VARCHAR2(255),
    YHJGMC VARCHAR2(255),
    GH VARCHAR2(255),
    XM VARCHAR2(255),
    GJ VARCHAR2(255),
    ZJLB VARCHAR2(255),
    ZJHM VARCHAR2(255),
    LXDH VARCHAR2(255),
    SSBM VARCHAR2(255),
    GWBH VARCHAR2(255),
    GWMC VARCHAR2(255),
    SFGG VARCHAR2(255),
    PFRQ VARCHAR2(255),
    RZRQ VARCHAR2(255),
    YGLX VARCHAR2(255),
    YGZT VARCHAR2(255),
    BBZ VARCHAR2(255),
    CJRQ VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

INSERT INTO
    E5_YGB (
        REPORTID,
        JRXKZH,
        NBJGH,
        YHJGMC,
        GH,
        XM,
        GJHDQ,
        ZJLB,
        ZJHM,
        LXDH,
        SSBM,
        GWBH,
        GWMC,
        SFGG,
        PFRQ,
        RZRQ,
        YGLX,
        YGZT,
        BBZ,
        CJRQ
    )
SELECT
    TEMP_TABLE_0.ID AS REPORTID,
    T1.JRXKZH AS JRXKZH,
    T1.NBJGH NBJGH,
    T1.YHJGMC YHJGMC,
    T1.GH GH,
    T1.XM XM,
    T1.GJHDQ GJHDQ,
    T1.ZJLB ZJLB,
    T1.ZJHM ZJHM,
    T1.LXDH LXDH,
    T1.SSBM SSBM,
    T1.GWBH GWBH,
    T1.GWMC GWMC,
    T1.SFGG SFGG,
    T1.PFRQ PFRQ,
    T1.RZRQ RZRQ,
    T1.YGLX YGLX,
    T1.YGZT YGZT,
    T1.BBZ BBZ,
    T1.CJRQ CJRQ
FROM
    EAST5_YGB T1
    INNER JOIN (
        SELECT
            L.ID AS ID,
            T.TABLENAME AS TABLE_NAME,
            I.INSTITUTIONID AS INSTITUTIONID,
            L.TERM AS TERM
        FROM
            LEDGERREPORT L
            LEFT JOIN REPORTTEMPLATE T ON L.LEDGERREPORTTEMPLATE_ID = T.ID
            LEFT JOIN INSTITUTION I ON L.INSTITUTION_ID = I.ID
        WHERE
            L.TERM = V_DATE
            AND T.TABLENAME = V_LOG.TABLNO
    ) TEMP_TABLE_0 ON (TEMP_TABLE_0.TABLE_NAME = V_LOG.TABLNO)
WHERE
    T1.CJRQ = V_DATE;