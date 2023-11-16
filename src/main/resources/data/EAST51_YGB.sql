--取人力资源系统中的在职人员的基本信息
SELECT
  '' AS JRXKZH,
  /*金融许可证号,在EAST5表中通过内部机构号关联机构信息表去获取*/
  CASE
    WHEN A.B0110 = '0101' THEN B.B010A
    ELSE B.B01AA
  END AS NBJGH,
  /*内部机构号，取A表:在职人员基本信息表的B0110:人资系统中机构编码作为判断条件，当B0110='0101'时(总行管理机构)，取B表:机构基本情况表的B010A:上级机构编码作为内部机构号,
  否则取B01AA:机构编码作为内部机构号*/
  '' AS YHJGMC,
  /*银行机构名称，在EAST5表中通过内部机构号关联机构信息表去获取*/
  A.A0144 AS GH,
  /*取A0144:员工编号作为工号*/
  A.A0101 AS XM,
  /*姓名*/
  A.A01CA AS GJ,
  /*取A01CA:国籍作为国籍字段，在EAST5表做码值映射判断，如A01CA='CHN',为'中国'*/
  A.A0130 AS ZJLB,
  /*取A0130：个人证件类型，作为证件类别，在EAST5表做码值映射，如当A0130='101'时为'居民身份证'*/
  A.A0177 AS ZJHM,
  /*取A0177:个人证件号码作为证件号码*/
  A.A0148 AS LXDH,
  /*取A0148:手机号码作为联系电话*/
  A.A01CV AS SSBM,
  /*所属部门*/
  A.A01BK AS GWBH,
  /*取A01BK:职位编码作为岗位编号*/
  A.A01AD AS GWMC,
  /*岗位名称*/
  CASE
    WHEN A.A01AN IN ('01', '02', '03', '04', '05', '06', '07', '09') THEN '是'
    ELSE '否'
  END SFGG,
  /*是否高管,根据A01AN:组织高管类型判断是否为高管*/
  '' AS PFRQ,
  /*批复日期（通过补录数据获取）*/
  '' AS RZRQ,
  /*任职日期（通过补录数据获取）*/
  A.A01AH AS YGLX,
  /*员工类型,在EAST5表做码值映射，如A01AH='I'为'正式员工'*/
  A.A0182 AS YGZT,
  /*取A0182:人员状态作为员工状态，在EAST5表做码值映射，如A0182 IN ('0101','0105')，状态为'在岗'*/
  '' AS BBZ,
  /*备注*/
  '#{ETL_DT}' AS CJRQ
  /*采集日期*/
FROM
  HRS_HRS_USRA01 A
  /*在职人员基本信息*/
  LEFT JOIN HRS_HRS_B01 B
  /*机构基本情况*/
  ON A.B0110 = B.B0110
  AND B.HYREN_S_DATE <= '#{ETL_DT}'
  AND B.HYREN_E_DATE > '#{ETL_DT}'
WHERE
  LENGTH (NVL (A.A0144, '')) > 0
  /*员工编号有值的数据*/
  AND A.HYREN_S_DATE <= '#{ETL_DT}'
  AND A.HYREN_E_DATE > '#{ETL_DT}'
UNION ALL
--从减员人员基本信息表中获取除了状态为'非正常在岗'的人员信息
SELECT
  '' AS JRXKZH,
  /*金融许可证号,在EAST5表中通过内部机构号关联机构信息表去获取*/
  CASE
    WHEN A.B0110 = '0101' THEN B.B010A
    ELSE B.B01AA
  END AS NBJGH,
  /*内部机构号，取A表:在职人员基本信息表的B0110:人资系统中机构编码作为判断条件，当B0110='0101'(总行管理机构)时，取B表:机构基本情况表的B010A:上级机构编码作为内部机构号,
  否则取B01AA:机构编码作为内部机构号*/
  '' AS YHJGMC,
  /*银行机构名称，在EAST5表中通过内部机构号关联机构信息表去获取*/
  A.A0144 AS GH,
  /*取A0144:员工编号作为工号*/
  A.A0101 AS XM,
  /*姓名*/
  A.A01CA AS GJ,
  /*国籍*/
  A.A0130 AS ZJLB,
  /*取A0130：个人证件类型，作为证件类别，在EAST5表做码值映射，如当A0130='101'时为'居民身份证'*/
  A.A0177 AS ZJHM,
  /*取A0177:个人证件号码作为证件号码*/
  A.A0148 AS LXDH,
  /*取A0148:手机号码作为联系电话*/
  A.A01CV AS SSBM,
  /*所属部门*/
  A.A01BK AS GWBH,
  /*取A01BK:职位编码作为岗位编号*/
  A.A01AD AS GWMC,
  /*岗位名称*/
  CASE
    WHEN A.A01AN IN ('01', '02', '03', '04', '05', '06', '07', '09') THEN '是'
    ELSE '否'
  END SFGG,
  /*是否高管,根据A01AN:组织高管类型判断是否为高管*/
  '' AS PFRQ,
  /*批复日期（通过补录数据获取）*/
  '' AS RZRQ,
  /*任职日期（通过补录数据获取）*/
  A.A01AH AS YGLX,
  /*员工类型,在EAST5表做码值映射，如A01AH='I'为'正式员工'*/
  A.A0182 AS YGZT,
  /*取A0182:人员状态作为员工状态，在EAST5表做码值映射，如A0182 IN ('0101','0105')，状态为'在岗'*/
  '' AS BBZ,
  /*备注*/
  '#{ETL_DT}' AS CJRQ
  /*采集日期*/
FROM
  HRS_HRS_RETA01 A
  LEFT JOIN HRS_HRS_B01 B
  /*机构基本情况*/
  ON A.B0110 = B.B0110
  AND B.HYREN_S_DATE <= '#{ETL_DT}'
  AND B.HYREN_E_DATE > '#{ETL_DT}'
WHERE
  LENGTH (NVL (A.A0144, '')) > 0
  /*员工编号有值的数据*/
  AND A.HYREN_S_DATE <= '#{ETL_DT}'
  AND A.HYREN_E_DATE > '#{ETL_DT}'
  AND A.A0182 <> '0101';

/*过滤人员状态为：'正常在岗'的人员信息*/