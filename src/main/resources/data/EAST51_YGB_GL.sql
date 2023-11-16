---------取人力资源系统中的在职人员的机构，部门信息-----------------------
SELECT
	b.B01AD AS JGMC,
	--机构名称,
	b.B01AC AS JGJC,
	--机构简称,
	CASE
		WHEN a.b0110 = '0101' THEN b.b010a
		ELSE b.B01AA
	END AS JGH,
	/*机构号,取A表:在职人员基本信息表的B0110:人资系统中机构编码作为判断条件，当B0110='0101'时(总行管理机构),取B表:机构基本情况表的B010A:上级机构编码作为机构号,
	 否则取B01AA:机构编码作为机构号*/
	CASE
		WHEN a.b0110 = '0101' THEN NULL
		WHEN c.b01AD = '内设部门' THEN NULL
		WHEN c.b01AD = '其他' THEN NULL
		WHEN d.B01AD = '经营型支行' THEN e.b01AD
		ELSE F.b01AD
	END AS FZHMC,
	/*分支行名称,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)或者当C表:机构基本情况表的b01AD（机构名称）为'内设部门'时，
	 或者当C表:机构基本情况表的b01AD（机构名称）为'其他'时,分支行名称都为空,当D表:机构基本情况表的b01AD（机构名称）为'经营型支行'时，取机构基本情况表的b01AD（机构名称）作为分支行名称*/
	CASE
		WHEN a.b0110 = '0101' THEN NULL
		WHEN c.b01AD = '内设部门' THEN NULL
		WHEN c.b01AD = '其他' THEN NULL
		WHEN d.B01AD = '经营型支行' THEN e.b01AA
		ELSE F.b01AA
	END AS FZHJGH,
	/*分支行机构号,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)或者当C表:机构基本情况表的b01AD（机构名称）为'内设部门'时，
	 或者当C表:机构基本情况表的b01AD（机构名称）为'其他'时,分支行机构号都为空,当D表:机构基本情况表的b01AD（机构名称）为'经营型支行'时，取机构基本情况表的b01AA（机构编码）作为分支行机构号*/
	CASE
		WHEN a.b0110 = '0101' THEN c.B01AD
		WHEN a.a01ch IS NOT NULL
		AND d.B01AD <> '经营型支行' THEN a.a01cy
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NOT NULL THEN a.a01cx
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NOT NULL THEN a.a01cw
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NULL
		AND a.a01ce IS NOT NULL THEN a.a01cv
		ELSE NULL
	END AS BM,
	/*部门,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)时，取C表:机构基本情况表的b01AD（机构名称）*/
	CASE
		WHEN a.b0110 = '0101' THEN C.b01AA
		WHEN a.a01ch IS NOT NULL
		AND d.B01AD <> '经营型支行'
		AND a.a01ch = g.b0110 THEN g.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NOT NULL
		AND a.a01cg = h.b0110 THEN h.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NOT NULL
		AND a.a01cf = i.b0110 THEN i.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NULL
		AND a.a01ce IS NOT NULL
		AND a.a01ce = j.b0110 THEN j.b01aa
		ELSE NULL
	END AS BMJGH,
	/*部门机构号,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)时，取C表:机构基本情况表的b01AA（机构编码）*/
	a.A0144 AS YGH,
	/*取A0144:员工编号作为员工号*/
	'#{ETL_DT}' AS CJRQ --采集日期	
FROM
	HRS_HRS_usrA01 a
	/*在职人员基本信息表*/
	LEFT JOIN HRS_HRS_b01 b ON a.b0110 = b.b0110
	AND b.HYREN_S_DATE <= '#{ETL_DT}'
	AND b.HYREN_E_DATE > '#{ETL_DT}'
	/*机构基本情况*/
	LEFT JOIN HRS_HRS_b01 c ON substr(a.e0122, 1, length(a.b0110) + 2) = c.b0110
	AND c.HYREN_S_DATE <= '#{ETL_DT}'
	AND c.HYREN_E_DATE > '#{ETL_DT}'
	/*e0122:部门号*/
	LEFT JOIN HRS_HRS_b01 d ON substr(a.e0122, 1, length(a.e0122) - 2) = d.b0110
	AND d.HYREN_S_DATE <= '#{ETL_DT}'
	AND d.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 e ON a.e0122 = e.B0110
	AND e.HYREN_S_DATE <= '#{ETL_DT}'
	AND e.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 F ON substr(a.e0122, 1, length(a.b0110) + 4) = F.b0110
	AND F.HYREN_S_DATE <= '#{ETL_DT}'
	AND F.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 g ON a.a01ch = g.b0110
	AND g.HYREN_S_DATE <= '#{ETL_DT}'
	AND g.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 h ON a.a01cg = h.b0110
	AND h.HYREN_S_DATE <= '#{ETL_DT}'
	AND h.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 i ON a.a01cf = i.b0110
	AND i.HYREN_S_DATE <= '#{ETL_DT}'
	AND i.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 j ON a.a01ce = j.b0110
	AND j.HYREN_S_DATE <= '#{ETL_DT}'
	AND j.HYREN_E_DATE > '#{ETL_DT}'
where
	a.HYREN_S_DATE <= '#{ETL_DT}'
	AND a.HYREN_E_DATE > '#{ETL_DT}'
union
all ---------------------------------------------------------------------从减员人员基本信息表中获取机构，部门信息-------------------------------------------------------------------------------------------
SELECT
	b.B01AD AS JGMC,
	--机构名称
	b.B01AC AS JGJC,
	--机构简称,
	CASE
		WHEN a.b0110 = '0101' THEN b.b010a
		ELSE b.B01AA
	END AS JGH,
	/*机构号,取A表:在职人员基本信息表的B0110:人资系统中机构编码作为判断条件，当B0110='0101'时(总行管理机构),取B表:机构基本情况表的B010A:上级机构编码作为机构号,
	 否则取B01AA:机构编码作为机构号*/
	CASE
		WHEN a.b0110 = '0101' THEN NULL
		WHEN c.b01AD = '内设部门' THEN NULL
		WHEN c.b01AD = '其他' THEN NULL
		WHEN d.B01AD = '经营型支行' THEN e.b01AD
		ELSE F.b01AD
	END AS FZHMC,
	/*分支行名称,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)或者当C表:机构基本情况表的b01AD（机构名称）为'内设部门'时，
	 或者当C表:机构基本情况表的b01AD（机构名称）为'其他'时,分支行名称都为空,当D表:机构基本情况表的b01AD（机构名称）为'经营型支行'时，取机构基本情况表的b01AD（机构名称）作为分支行名称*/
	CASE
		WHEN a.b0110 = '0101' THEN NULL
		WHEN c.b01AD = '内设部门' THEN NULL
		WHEN c.b01AD = '其他' THEN NULL
		WHEN d.B01AD = '经营型支行' THEN e.b01AA
		ELSE F.b01AA
	END AS FZHJGH,
	/*分支行机构号,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)或者当C表:机构基本情况表的b01AD（机构名称）为'内设部门'时，
	 或者当C表:机构基本情况表的b01AD（机构名称）为'其他'时,分支行机构号都为空,当D表:机构基本情况表的b01AD（机构名称）为'经营型支行'时，取机构基本情况表的b01AA（机构编码）作为分支行机构号*/
	CASE
		WHEN a.b0110 = '0101' THEN c.B01AD
		WHEN a.a01ch IS NOT NULL
		AND d.B01AD <> '经营型支行' THEN a.a01cy
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NOT NULL THEN a.a01cx
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NOT NULL THEN a.a01cw
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NULL
		AND a.a01ce IS NOT NULL THEN a.a01cv
		ELSE NULL
	END AS BM,
	/*部门,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)时，取C表:机构基本情况表的b01AD（机构名称）*/
	CASE
		WHEN a.b0110 = '0101' THEN C.b01AA
		WHEN a.a01ch IS NOT NULL
		AND d.B01AD <> '经营型支行'
		AND a.a01ch = g.b0110 THEN g.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NOT NULL
		AND a.a01cg = h.b0110 THEN h.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NOT NULL
		AND a.a01cf = i.b0110 THEN i.b01aa
		WHEN a.a01ch IS NULL
		AND a.a01cg IS NULL
		AND a.a01cf IS NULL
		AND a.a01ce IS NOT NULL
		AND a.a01ce = j.b0110 THEN j.b01aa
		ELSE NULL
	END AS BMJGH,
	/*部门机构号,当A表:在职人员基本信息表的B0110:人资系统中机构编码为'0101'时(总行管理机构)时，取C表:机构基本情况表的b01AA（机构编码）*/
	a.A0144 AS YGH,
	/*取A0144:员工编号作为员工号*/
	'#{ETL_DT}' AS CJRQ --采集日期	
FROM
	HRS_HRS_RETA01 a
	/*减员人员基本信息*/
	LEFT JOIN HRS_HRS_b01 b ON a.b0110 = b.b0110
	AND b.HYREN_S_DATE <= '#{ETL_DT}'
	AND b.HYREN_E_DATE > '#{ETL_DT}'
	/*机构基本情况*/
	LEFT JOIN HRS_HRS_b01 c ON substr(a.e0122, 1, length(a.b0110) + 2) = c.b0110
	AND c.HYREN_S_DATE <= '#{ETL_DT}'
	AND c.HYREN_E_DATE > '#{ETL_DT}'
	/*e0122:部门号*/
	LEFT JOIN HRS_HRS_b01 d ON substr(a.e0122, 1, length(a.e0122) - 2) = d.b0110
	AND d.HYREN_S_DATE <= '#{ETL_DT}'
	AND d.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 e ON a.e0122 = e.B0110
	AND e.HYREN_S_DATE <= '#{ETL_DT}'
	AND e.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 F ON substr(a.e0122, 1, length(a.b0110) + 4) = F.b0110
	AND F.HYREN_S_DATE <= '#{ETL_DT}'
	AND F.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 g ON a.a01ch = g.b0110
	AND g.HYREN_S_DATE <= '#{ETL_DT}'
	AND g.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 h ON a.a01cg = h.b0110
	AND h.HYREN_S_DATE <= '#{ETL_DT}'
	AND h.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 i ON a.a01cf = i.b0110
	AND i.HYREN_S_DATE <= '#{ETL_DT}'
	AND i.HYREN_E_DATE > '#{ETL_DT}'
	LEFT JOIN HRS_HRS_b01 j ON a.a01ce = j.b0110
	AND j.HYREN_S_DATE <= '#{ETL_DT}'
	AND j.HYREN_E_DATE > '#{ETL_DT}'
where
	a.HYREN_S_DATE <= '#{ETL_DT}'
	AND a.HYREN_E_DATE > '#{ETL_DT}'