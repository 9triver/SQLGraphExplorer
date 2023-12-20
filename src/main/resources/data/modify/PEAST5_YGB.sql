/*
 修改自：PE5_YGB.sql
 */
create table PEAST5_YGB (
    JRXKZH VARCHAR2(255),
    NBJGH VARCHAR2(255),
    YHJGMC VARCHAR2(255),
    GH VARCHAR2(255),
    XM VARCHAR2(255),
    GJ VARCHAR2(255),
    ZJLB VARCHAR2(255),
    LXDH VARCHAR2(255),
    GWBH VARCHAR2(255),
    GWMC VARCHAR2(255),
    PFRQ VARCHAR2(255),
    RZRQ VARCHAR2(255),
    YGLX VARCHAR2(255),
    YGZT VARCHAR2(255),
    BBZ VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

--每一段加工逻辑处理，打一个标签
/*SQLSTART*/
--员工表
SELECT
    EAST5_JGXXB.JRXKZH AS JRXKZH,
    --金融许可证号
    GZYH_CBJG_ZH.newnbjgh AS NBJGH,
    --内部机构号
    EAST5_JGXXB.YHJGMC AS YHJGMC,
    --银行机构名称
    TEMP_TABLE_0.GH AS GH,
    --工号
    TEMP_TABLE_0.XM AS XM,
    --姓名
    TEMP_TABLE_0.GJ AS GJ,
    --国籍
    TEMP_TABLE_0.ZJHM AS ZJHM,
    --证件号码
    TEMP_TABLE_0.LXDH AS LXDH,
    --联系电话
    TEMP_TABLE_0.GWBH AS GWBH,
    --岗位编号
    TEMP_TABLE_0.GWMC AS GWMC,
    --岗位名称
    TEMP_TABLE_0.PFRQ AS PFRQ,
    --批复日期
    TEMP_TABLE_0.RZRQ AS RZRQ,
    --任职日期
    TEMP_TABLE_0.YGLX AS YGLX,
    --员工类型
    TEMP_TABLE_0.YGZT AS YGZT,
    --员工状态
    TEMP_TABLE_0.BBZ AS BBZ --备注
FROM
    (
        SELECT
            EAST51_YGB_GL.JGH AS NBJGH,
            --内部机构号
            EAST51_YGB.GH AS GH,
            --工号
            EAST51_YGB.XM AS XM,
            --姓名
            EAST51_YGB.GJ AS GJ,
            --国籍
            EAST51_YGB.ZJHM AS ZJHM,
            --证件号码
            EAST51_YGB.LXDH AS LXDH,
            --联系电话
            EAST51_YGB.GWBH AS GWBH,
            --岗位编号
            EAST51_YGB.GWMC AS GWMC,
            --岗位名称
            EAST51_YGB.PFRQ AS PFRQ,
            --批复日期
            EAST51_YGB.RZRQ AS RZRQ,
            --任职日期
            EAST51_YGB.YGLX AS YGLX,
            /*员工类型,I:内部员工,D:派遣员工*/
            EAST51_YGB.YGZT AS YGZT,
            --员工状态
            EAST51_YGB.BBZ --备注
        FROM
            EAST51_YGB --（大数据平台）员工表
            LEFT JOIN EAST51_YGB_GL ON EAST51_YGB.GH = EAST51_YGB_GL.YGH
            AND EAST51_YGB_GL.CJRQ = V_DATE --（大数据平台）员工关联表，获取内部机构号
        WHERE
            EAST51_YGB.XM IS NOT NULL
            AND EAST51_YGB.CJRQ = V_DATE
    ) TEMP_TABLE_0 -------modified by xsm 20220610 关联GZYH_CBJG_ZH：拆并机构映射转换表，获取映射后的机构号------------------------
    LEFT JOIN GZYH_CBJG_ZH --拆并机构转换表
    ON TEMP_TABLE_0.NBJGH = GZYH_CBJG_ZH.oldNbjgh
    LEFT JOIN EAST5_JGXXB --机构信息表
    ON NVL(GZYH_CBJG_ZH.newNbjgh, TEMP_TABLE_0.NBJGH) = EAST5_JGXXB.NBJGH
    AND TEMP_TABLE_0.CJRQ = EAST5_JGXXB.CJRQ
where
    TEMP_TABLE_0.CJRQ = V_DATE;