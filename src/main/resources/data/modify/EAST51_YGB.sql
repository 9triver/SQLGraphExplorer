/*
 修改自：EAST51_YGB.sql
 */
create table HRS_HRS_USRA01 (
    A0144 VARCHAR2(255),
    A0101 VARCHAR2(255),
    A01CA VARCHAR2(255),
    A0130 VARCHAR2(255),
    A0177 VARCHAR2(255),
    A0148 VARCHAR2(255),
    A01CV VARCHAR2(255),
    A01BK VARCHAR2(255),
    A01AD VARCHAR2(255),
    A01AH VARCHAR2(255),
    A0182 VARCHAR2(255),
    B0110 VARCHAR2(255),
    HYREN_S_DATE VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table HRS_HRS_RETA01 (
    A0144 VARCHAR2(255),
    A0101 VARCHAR2(255),
    A01CA VARCHAR2(255),
    A0130 VARCHAR2(255),
    A0177 VARCHAR2(255),
    A0148 VARCHAR2(255),
    A01CV VARCHAR2(255),
    A01BK VARCHAR2(255),
    A01AD VARCHAR2(255),
    A01AH VARCHAR2(255),
    A0182 VARCHAR2(255),
    B0110 VARCHAR2(255),
    HYREN_S_DATE VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table HRS_HRS_B01 (
    B0110 VARCHAR2(255),
    HYREN_S_DATE VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table EAST51_YGB (
    GH VARCHAR2(255),
    XM VARCHAR2(255),
    GJ VARCHAR2(255),
    ZJLB VARCHAR2(255),
    ZJHM VARCHAR2(255),
    LXDH VARCHAR2(255),
    SSBM VARCHAR2(255),
    GWBH VARCHAR2(255),
    GWMC VARCHAR2(255),
    YGLX VARCHAR2(255),
    YGZT VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

/*过滤人员状态为：'正常在岗'的人员信息*/
--取人力资源系统中的在职人员的基本信息
SELECT
    HRS_HRS_USRA01.A0144 AS GH,
    /*取A0144:员工编号作为工号*/
    HRS_HRS_USRA01.A0101 AS XM,
    /*姓名*/
    HRS_HRS_USRA01.A01CA AS GJ,
    /*取A01CA:国籍作为国籍字段，在EAST5表做码值映射判断，如A01CA='CHN',为'中国'*/
    HRS_HRS_USRA01.A0130 AS ZJLB,
    /*取A0130：个人证件类型，作为证件类别，在EAST5表做码值映射，如当A0130='101'时为'居民身份证'*/
    HRS_HRS_USRA01.A0177 AS ZJHM,
    /*取A0177:个人证件号码作为证件号码*/
    HRS_HRS_USRA01.A0148 AS LXDH,
    /*取A0148:手机号码作为联系电话*/
    HRS_HRS_USRA01.A01CV AS SSBM,
    /*所属部门*/
    HRS_HRS_USRA01.A01BK AS GWBH,
    /*取A01BK:职位编码作为岗位编号*/
    HRS_HRS_USRA01.A01AD AS GWMC,
    /*岗位名称*/
    HRS_HRS_USRA01.A01AH AS YGLX,
    /*员工类型,在EAST5表做码值映射，如A01AH='I'为'正式员工'*/
    HRS_HRS_USRA01.A0182 AS YGZT
    /*取A0182:人员状态作为员工状态，在EAST5表做码值映射，如A0182 IN ('0101','0105')，状态为'在岗'*/
FROM
    HRS_HRS_USRA01
    /*在职人员基本信息*/
    JOIN HRS_HRS_B01
    /*机构基本情况*/
    ON HRS_HRS_USRA01.B0110 = HRS_HRS_B01.B0110
    AND HRS_HRS_B01.HYREN_S_DATE <= '#{ETL_DT}'
    AND HRS_HRS_B01.HYREN_E_DATE > '#{ETL_DT}'
WHERE
    LENGTH (NVL (HRS_HRS_USRA01.A0144, '')) > 0
    /*员工编号有值的数据*/
    AND HRS_HRS_USRA01.HYREN_S_DATE <= '#{ETL_DT}'
    AND HRS_HRS_USRA01.HYREN_E_DATE > '#{ETL_DT}'
UNION
ALL --从减员人员基本信息表中获取除了状态为'非正常在岗'的人员信息
SELECT
    HRS_HRS_RETA01.A0144 AS GH,
    /*取A0144:员工编号作为工号*/
    HRS_HRS_RETA01.A0101 AS XM,
    /*姓名*/
    HRS_HRS_RETA01.A01CA AS GJ,
    /*国籍*/
    HRS_HRS_RETA01.A0130 AS ZJLB,
    /*取A0130：个人证件类型，作为证件类别，在EAST5表做码值映射，如当A0130='101'时为'居民身份证'*/
    HRS_HRS_RETA01.A0177 AS ZJHM,
    /*取A0177:个人证件号码作为证件号码*/
    HRS_HRS_RETA01.A0148 AS LXDH,
    /*取A0148:手机号码作为联系电话*/
    HRS_HRS_RETA01.A01CV AS SSBM,
    /*所属部门*/
    HRS_HRS_RETA01.A01BK AS GWBH,
    /*取A01BK:职位编码作为岗位编号*/
    HRS_HRS_RETA01.A01AD AS GWMC,
    /*岗位名称*/
    HRS_HRS_RETA01.A01AH AS YGLX,
    /*员工类型,在EAST5表做码值映射，如A01AH='I'为'正式员工'*/
    HRS_HRS_RETA01.A0182 AS YGZT
    /*取A0182:人员状态作为员工状态，在EAST5表做码值映射，如A0182 IN ('0101','0105')，状态为'在岗'*/
FROM
    HRS_HRS_RETA01
    JOIN HRS_HRS_B01
    /*机构基本情况*/
    ON HRS_HRS_RETA01.B0110 = HRS_HRS_B01.B0110
    AND HRS_HRS_B01.HYREN_S_DATE <= '#{ETL_DT}'
    AND HRS_HRS_B01.HYREN_E_DATE > '#{ETL_DT}'
WHERE
    LENGTH (NVL (HRS_HRS_RETA01.A0144, '')) > 0
    /*员工编号有值的数据*/
    AND HRS_HRS_RETA01.HYREN_S_DATE <= '#{ETL_DT}'
    AND HRS_HRS_RETA01.HYREN_E_DATE > '#{ETL_DT}'
    AND HRS_HRS_RETA01.A0182 <> '0101';

/*过滤人员状态为：'正常在岗'的人员信息*/
-- results