--每一段加工逻辑处理，打一个标签
/*SQLSTART*/
/*MERGE INTO E5_YGB a
 USING (SELECT zjhm, pfrq, rzrq, sfgg FROM YGXXB where cjrq = I_DATE) b
 ON (a.ZJHM = b.ZJHM)
 WHEN MATCHED THEN
 UPDATE
 SET a.PFRQ = b.PFRQ, A.RZRQ = B.RZRQ, A.SFGG = B.SFGG
 where A.cjrq = I_date;*/
--------全表补录 modified by xsm 20220613----------
MERGE INTO E5_YGB a USING (
  SELECT
    yg.*
  from
    (
      SELECT
        m.*,
        row_number() over(
          partition by zjhm
          order by
            pfrq desc
        ) rn
      FROM
        BL_YGB m
        LEFT JOIN IRS_MODEL.EAST5_JGXXB D ON D.NBJGH = m.NBJGH
        AND D.CJRQ = V_DATE
      where
        to_char(m.cjrq, 'yyyymmdd') = V_DATE
    ) yg
  where
    yg.rn = 1
) b ON (
  A.ZJHM = B.ZJHM
  AND A.CJRQ = TO_CHAR(B.CJRQ, 'yyyymmdd')
)
WHEN MATCHED THEN
UPDATE
SET
  a.PFRQ = b.PFRQ,
  A.RZRQ = B.RZRQ,
  A.SFGG = B.SFGG,
  A.BBZ = B.BBZ
where
  A.cjrq = V_DATE
  when not matched then
INSERT
  (
    A.ID,
    A.REPORTID,
    A.JRXKZH,
    A.NBJGH,
    --内部机构号
    A.YHJGMC,
    --银行机构名称
    A.GH,
    --工号
    A.XM,
    --姓名
    A.GJHDQ,
    --国籍
    A.ZJLB,
    --证件类别
    A.ZJHM,
    --证件号码
    A.LXDH,
    --联系电话
    A.SSBM,
    --所属部门
    A.GWBH,
    --岗位编号
    A.GWMC,
    --岗位名称
    A.SFGG,
    --是否高管
    A.PFRQ,
    --批复日期
    A.RZRQ,
    --任职日期
    A.YGLX,
    --员工类型
    A.YGZT,
    --员工状态
    A.BBZ,
    --备注
    A.CJRQ
  )
values
  (
    Seq_Fitech.nextval,
    --序列
    get_dac_reportid('E5_YGB', I_DATE),
    --序列
    B.JRXKZH,
    B.NBJGH,
    --内部机构号
    B.YHJGMC,
    --银行机构名称
    B.GH,
    --工号
    B.XM,
    --姓名
    B.GJ,
    --国籍
    B.ZJLB,
    --证件类别
    B.ZJHM,
    --证件号码
    B.LXDH,
    --联系电话
    B.SSBM,
    --所属部门
    B.GWBH,
    --岗位编号
    B.GWMC,
    --岗位名称
    B.SFGG,
    --是否高管
    B.PFRQ,
    --批复日期
    B.RZRQ,
    --任职日期
    B.YGLX,
    --员工类型
    B.YGZT,
    --员工状态
    B.BBZ,
    --备注
    V_DATE
  );