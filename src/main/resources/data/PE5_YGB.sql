create table EAST5_YGB (
  jrxkzh VARCHAR2(255),
  nbjgh VARCHAR2(255),
  yhjgmc VARCHAR2(255),
  gh VARCHAR2(255),
  xm VARCHAR2(255),
  gj VARCHAR2(255),
  zjlb VARCHAR2(255),
  zjhm VARCHAR2(255),
  lxdh VARCHAR2(255),
  ssbm VARCHAR2(255),
  gwbh VARCHAR2(255),
  gwmc VARCHAR2(255),
  sfgg VARCHAR2(255),
  pfrq VARCHAR2(255),
  rzrq VARCHAR2(255),
  yglx VARCHAR2(255),
  ygzt VARCHAR2(255),
  bbz VARCHAR2(255),
  cjrq VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

INSERT INTO
  E5_YGB (
    ID,
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
    CJRQ,
    gsfzjg
  )
SELECT
  SEQ_FITECH.NEXTVAL ID,
  T2.ID REPORTID,
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
  CJRQ,
  '9999'
FROM
  EAST5_YGB T1
  INNER JOIN (
    SELECT
      L.ID ID,
      T.TABLENAME TABLE_NAME,
      I.INSTITUTIONID INSTITUTIONID,
      L.TERM TERM
    FROM
      LEDGERREPORT L
      LEFT JOIN REPORTTEMPLATE T ON L.LEDGERREPORTTEMPLATE_ID = T.ID
      LEFT JOIN INSTITUTION I ON L.INSTITUTION_ID = I.ID
    WHERE
      L.TERM = V_DATE
      AND T.TABLENAME = V_LOG.TABLNO
  ) T2 ON (T2.TABLE_NAME = V_LOG.TABLNO)
WHERE
  T1.CJRQ = V_DATE;