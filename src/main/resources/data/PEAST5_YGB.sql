--每一段加工逻辑处理，打一个标签
/*SQLSTART*/
--员工表
INSERT INTO
  EAST5_YGB (
    JRXKZH,
    --金融许可证号
    NBJGH,
    --内部机构号
    YHJGMC,
    --银行机构名称
    GH,
    --工号
    XM,
    --姓名
    GJHDQ,
    --国籍
    ZJLB,
    --证件类别
    ZJHM,
    --证件号码
    LXDH,
    --联系电话
    SSBM,
    --所属部门
    GWBH,
    --岗位编号
    GWMC,
    --岗位名称
    SFGG,
    --是否高管
    PFRQ,
    --批复日期
    RZRQ,
    --任职日期
    YGLX,
    --员工类型
    YGZT,
    --员工状态
    BBZ,
    --备注
    CJRQ,
    --采集日期
    ETL_DATE
  )
SELECT
  B.JRXKZH AS JRXKZH,
  --金融许可证号
  --------modified by xsm 20220610 关联GZYH_CBJG_ZH：拆并机构映射转换表，获取映射后的机构号--------------
  case
    when A.NBJGH = C.oldNbjgh then C.newnbjgh
    else A.NBJGH
  end AS NBJGH,
  --内部机构号
  -------------------------------------------------------------------------------------------------------
  B.YHJGMC AS YHJGMC,
  --银行机构名称
  A.GH AS GH,
  --工号
  A.XM AS XM,
  --姓名
  NVL(A.GJ, '中国') AS GJ,
  --国籍
  A.ZJLB AS ZJLB,
  --证件类别
  A.ZJHM AS ZJHM,
  --证件号码
  A.LXDH AS LXDH,
  --联系电话
  SUBSTR(B.YHJGMC, '11', LENGTH(B.YHJGMC)) AS SSBM,
  --所属部门
  A.GWBH AS GWBH,
  --岗位编号
  A.GWMC AS GWMC,
  --岗位名称
  '否' AS SFGG,
  --是否高管
  A.PFRQ AS PFRQ,
  --批复日期
  A.RZRQ AS RZRQ,
  --任职日期
  A.YGLX AS YGLX,
  --员工类型
  A.YGZT AS YGZT,
  --员工状态
  A.BBZ AS BBZ,
  --备注
  V_DATE AS CJRQ,
  --采集日期
  TO_DATE(V_DATE, 'yyyymmdd') AS ETL_DATE --跑批日期
FROM
  (
    SELECT
      CASE
        WHEN C.BMJGH IS NOT NULL
        AND D.NBJGH IS NOT NULL THEN C.BMJGH
        ELSE NVL(C.FZHJGH, C.JGH)
      END AS NBJGH,
      --内部机构号 按照部门机构号，分支行机构号，机构号顺序依次取（前者为空时取后者）
      A.GH,
      --工号
      A.XM,
      --姓名
      NVL(
        CASE
          WHEN A.GJ = 'CHN' THEN '中国'
          ELSE A.GJ
        END,
        '中国'
      ) AS GJ,
      --国籍
      CASE
        WHEN A.ZJLB = '101' THEN '居民身份证'
        WHEN A.ZJLB = '102' THEN '户口簿'
        WHEN A.ZJLB = '103' THEN '外国护照'
        WHEN A.ZJLB = '105' THEN '军人军官证'
        WHEN A.ZJLB = '106' THEN '军人士兵证'
        WHEN A.ZJLB = '107' THEN '武警军官证'
        WHEN A.ZJLB = '108' THEN '港澳居民往来内地通行证（香港）'
        WHEN A.ZJLB = '114' THEN '港澳居民往来内地通行证（澳门）'
        WHEN A.ZJLB = '109' THEN '台湾居民往来大陆通行证'
        WHEN A.ZJLB = '110' THEN '临时居民身份证'
        WHEN A.ZJLB = '111' THEN '外国人永久居留证'
        WHEN A.ZJLB = '112' THEN '中国护照'
        WHEN A.ZJLB = '113' THEN '武警士兵证'
        WHEN A.ZJLB = '115' THEN '边民出入境通行证'
        WHEN A.ZJLB = '116' THEN '台湾居民旅行证'
        WHEN A.ZJLB = '117' THEN '工作证'
        WHEN A.ZJLB = '118' THEN '执行公务证'
        WHEN A.ZJLB = '120' then '文职干部退休证'
        WHEN A.ZJLB = '121' THEN '武警文职干部证'
        WHEN A.ZJLB = '122' THEN '武警军官退休证'
        WHEN A.ZJLB = '123' THEN '武警文职干部退休证'
        WHEN A.ZJLB = '124' THEN '台湾居民身份证'
        WHEN A.ZJLB = '125' THEN '香港居民身份证'
        WHEN A.ZJLB = '126' THEN '澳门居民身份证'
        WHEN A.ZJLB = '127' THEN '驾驶证'
        WHEN A.ZJLB = '128' THEN '保险从业资格证'
        WHEN A.ZJLB = '129' THEN '专业证书'
        WHEN A.ZJLB = '130' THEN '学员证'
        WHEN A.ZJLB = '131' THEN '退休证'
        WHEN A.ZJLB = '132' THEN '学生证'
        WHEN A.ZJLB = '133' THEN '香港居民居住证'
        WHEN A.ZJLB = '134' THEN '澳门居民居住证'
        WHEN A.ZJLB = '135' THEN '台湾居民居住证'
        WHEN A.ZJLB = '136' THEN '军人身份证'
        WHEN A.ZJLB = '137' THEN '武警身份证'
        WHEN A.ZJLB = '138' THEN '社保卡'
        WHEN A.ZJLB = '139' THEN '外国人居留证'
        WHEN A.ZJLB = '140' THEN '军人文职干部证'
        WHEN A.ZJLB = '199' THEN '其他-个人证件'
        ELSE '其他-个人证件'
      END AS ZJLB,
      --证件类别
      A.ZJHM,
      --证件号码
      A.LXDH,
      --联系电话
      A.GWBH,
      --岗位编号
      A.GWMC,
      --岗位名称
      '否',
      --是否高管 （系统获取为非高管数据，高管数据补录获取）
      A.PFRQ,
      --批复日期
      A.RZRQ,
      --任职日期
      CASE
        WHEN A.YGLX = 'I' THEN '正式员工'
        else '非正式员工'
      END AS YGLX,
      /*员工类型,I:内部员工,D:派遣员工*/
      CASE
        WHEN A.YGZT IN (
          '0101',
          '0105',
          '0107',
          '0201',
          '02',
          '010701',
          '010702',
          '01'
        ) THEN '在岗'
        WHEN A.YGZT IN (
          '0106',
          '0102',
          '0103',
          '0104',
          '0106',
          '0202',
          '0203',
          '0108'
        ) THEN '离岗'
        WHEN A.YGZT IN ('0204', '0205', '0206', '0207', '0208') THEN '离职'
        ELSE '其他-其他'
      END AS YGZT,
      --员工状态
      A.BBZ,
      --备注
      A.CJRQ --采集日期
    FROM
      EAST51_YGB A --（大数据平台）员工表
      LEFT JOIN EAST51_YGB_GL C ON A.GH = C.YGH
      AND C.CJRQ = V_DATE --（大数据平台）员工关联表，获取内部机构号
      LEFT JOIN EAST5_JGXXB D --机构信息表
      ON D.NBJGH = C.BMJGH
      AND D.CJRQ = V_DATE
    WHERE
      A.XM IS NOT NULL
      AND A.CJRQ = V_DATE
  ) A -------modified by xsm 20220610 关联GZYH_CBJG_ZH：拆并机构映射转换表，获取映射后的机构号------------------------
  LEFT JOIN GZYH_CBJG_ZH C --拆并机构转换表
  ON A.NBJGH = C.oldNbjgh
  LEFT JOIN EAST5_JGXXB B --机构信息表
  ON NVL(C.newNbjgh, A.NBJGH) = B.NBJGH
  AND A.CJRQ = B.CJRQ
where
  A.CJRQ = V_DATE;