create table EAST51_YGB (
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

comment on column EAST51_YGB.jrxkzh is '金融许可证号';

comment on column EAST51_YGB.nbjgh is '内部机构号';

comment on column EAST51_YGB.yhjgmc is '银行机构名称';

comment on column EAST51_YGB.gh is '工号';

comment on column EAST51_YGB.xm is '姓名';

comment on column EAST51_YGB.gj is '国籍字段';

comment on column EAST51_YGB.zjlb is '个人证件类型';

comment on column EAST51_YGB.zjhm is '个人证件号码';

comment on column EAST51_YGB.lxdh is '联系电话';

comment on column EAST51_YGB.ssbm is '所属部门';

comment on column EAST51_YGB.gwbh is '岗位编号';

comment on column EAST51_YGB.gwmc is '岗位名称';

comment on column EAST51_YGB.sfgg is '是否高管';

comment on column EAST51_YGB.pfrq is '批复日期';

comment on column EAST51_YGB.rzrq is '任职日期';

comment on column EAST51_YGB.yglx is '员工类型';

comment on column EAST51_YGB.ygzt is '人员状态';

comment on column EAST51_YGB.bbz is '备注';

comment on column EAST51_YGB.cjrq is '采集日期';

create table EAST51_YGB_GL (
  jgmc VARCHAR2(255),
  jgjc VARCHAR2(255),
  jgh VARCHAR2(255),
  fzhmc VARCHAR2(255),
  fzhjgh VARCHAR2(255),
  bm VARCHAR2(255),
  bmjgh VARCHAR2(255),
  ygh VARCHAR2(255),
  cjrq VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

comment on column EAST51_YGB_GL.jgmc is '机构名称';

comment on column EAST51_YGB_GL.jgjc is '机构简称';

comment on column EAST51_YGB_GL.jgh is '机构号';

comment on column EAST51_YGB_GL.fzhmc is '分支行名称';

comment on column EAST51_YGB_GL.fzhjgh is '分支行机构号';

comment on column EAST51_YGB_GL.bm is '部门';

comment on column EAST51_YGB_GL.bmjgh is '部门机构号';

comment on column EAST51_YGB_GL.ygh is '员工号';

comment on column EAST51_YGB_GL.cjrq is '采集日期';

create table EAST5_JGXXB (
  yhjgdm VARCHAR2(255),
  nbjgh VARCHAR2(255),
  jrxkzh VARCHAR2(255),
  yyzzh VARCHAR2(255),
  yhjgmc VARCHAR2(255),
  jglb VARCHAR2(255),
  xzqhdm VARCHAR2(255),
  yyzt VARCHAR2(255),
  clrq VARCHAR2(255),
  jgdz VARCHAR2(255),
  jglxdh VARCHAR2(255),
  fzrxm VARCHAR2(255),
  fzrzw VARCHAR2(255),
  fzrlxdh VARCHAR2(255),
  cjrq VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

comment on column EAST5_JGXXB.yhjgdm is '银行机构代码';

comment on column EAST5_JGXXB.nbjgh is '内部机构号';

comment on column EAST5_JGXXB.jrxkzh is '金融许可证号';

comment on column EAST5_JGXXB.yyzzh is '营业执照号';

comment on column EAST5_JGXXB.yhjgmc is '银行机构名称';

comment on column EAST5_JGXXB.jglb is '机构类别';

comment on column EAST5_JGXXB.xzqhdm is '行政区划代码';

comment on column EAST5_JGXXB.yyzt is '营业状态';

comment on column EAST5_JGXXB.clrq is '成立日期';

comment on column EAST5_JGXXB.jgdz is '机构地址';

comment on column EAST5_JGXXB.jglxdh is '机构联系电话';

comment on column EAST5_JGXXB.fzrxm is '负责人姓名';

comment on column EAST5_JGXXB.fzrzw is '负责人职务';

comment on column EAST5_JGXXB.fzrlxdh is '负责人联系电话';

comment on column EAST5_JGXXB.cjrq is '采集日期';

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

comment on column EAST5_YGB.jrxkzh is '金融许可证号';

comment on column EAST5_YGB.nbjgh is '内部机构号';

comment on column EAST5_YGB.yhjgmc is '银行机构名称';

comment on column EAST5_YGB.gh is '工号';

comment on column EAST5_YGB.xm is '姓名';

comment on column EAST5_YGB.gj is '国籍';

comment on column EAST5_YGB.zjlb is '证件类别';

comment on column EAST5_YGB.zjhm is '证件号码';

comment on column EAST5_YGB.lxdh is '联系电话';

comment on column EAST5_YGB.ssbm is '所属部门';

comment on column EAST5_YGB.gwbh is '岗位编号';

comment on column EAST5_YGB.gwmc is '岗位名称';

comment on column EAST5_YGB.sfgg is '是否高管';

comment on column EAST5_YGB.pfrq is '批复日期';

comment on column EAST5_YGB.rzrq is '任职日期';

comment on column EAST5_YGB.yglx is '员工类型';

comment on column EAST5_YGB.ygzt is '员工状态';

comment on column EAST5_YGB.bbz is '备注';

comment on column EAST5_YGB.cjrq is '采集日期';

create table GZYH_CBJG_ZH (
  oldnbjgh VARCHAR2(255),
  newnbjgh VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

comment on column GZYH_CBJG_ZH.oldnbjgh is '老内部机构号';

comment on column GZYH_CBJG_ZH.newnbjgh is '新内部机构号';

alter table
  EAST51_YGB disable all triggers;

alter table
  EAST51_YGB_GL disable all triggers;

alter table
  EAST5_JGXXB disable all triggers;

alter table
  EAST5_YGB disable all triggers;

alter table
  GZYH_CBJG_ZH disable all triggers;

truncate table GZYH_CBJG_ZH;

truncate table EAST5_YGB;

truncate table EAST5_JGXXB;

truncate table EAST51_YGB_GL;

truncate table EAST51_YGB;

insert into
  EAST51_YGB (
    jrxkzh,
    nbjgh,
    yhjgmc,
    gh,
    xm,
    gj,
    zjlb,
    zjhm,
    lxdh,
    ssbm,
    gwbh,
    gwmc,
    sfgg,
    pfrq,
    rzrq,
    yglx,
    ygzt,
    bbz,
    cjrq
  )
values
  (
    null,
    '0101',
    null,
    'A001',
    '张三',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null
  );

insert into
  EAST51_YGB (
    jrxkzh,
    nbjgh,
    yhjgmc,
    gh,
    xm,
    gj,
    zjlb,
    zjhm,
    lxdh,
    ssbm,
    gwbh,
    gwmc,
    sfgg,
    pfrq,
    rzrq,
    yglx,
    ygzt,
    bbz,
    cjrq
  )
values
  (
    null,
    '0101',
    null,
    'A002',
    '李四',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null
  );

insert into
  EAST51_YGB (
    jrxkzh,
    nbjgh,
    yhjgmc,
    gh,
    xm,
    gj,
    zjlb,
    zjhm,
    lxdh,
    ssbm,
    gwbh,
    gwmc,
    sfgg,
    pfrq,
    rzrq,
    yglx,
    ygzt,
    bbz,
    cjrq
  )
values
  (
    null,
    '0102',
    null,
    'B001',
    '张龙',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null
  );

insert into
  EAST51_YGB (
    jrxkzh,
    nbjgh,
    yhjgmc,
    gh,
    xm,
    gj,
    zjlb,
    zjhm,
    lxdh,
    ssbm,
    gwbh,
    gwmc,
    sfgg,
    pfrq,
    rzrq,
    yglx,
    ygzt,
    bbz,
    cjrq
  )
values
  (
    null,
    '0102',
    null,
    'B002',
    '赵虎',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null
  );

commit;

insert into
  EAST51_YGB_GL (
    jgmc,
    jgjc,
    jgh,
    fzhmc,
    fzhjgh,
    bm,
    bmjgh,
    ygh,
    cjrq
  )
values
  (
    null,
    null,
    null,
    null,
    null,
    null,
    'BM001',
    'A001',
    '20231031'
  );

insert into
  EAST51_YGB_GL (
    jgmc,
    jgjc,
    jgh,
    fzhmc,
    fzhjgh,
    bm,
    bmjgh,
    ygh,
    cjrq
  )
values
  (
    null,
    null,
    null,
    null,
    null,
    null,
    'BM001',
    'A002',
    '20231031'
  );

insert into
  EAST51_YGB_GL (
    jgmc,
    jgjc,
    jgh,
    fzhmc,
    fzhjgh,
    bm,
    bmjgh,
    ygh,
    cjrq
  )
values
  (
    null,
    null,
    null,
    null,
    null,
    null,
    'BM002',
    'B001',
    '20231031'
  );

insert into
  EAST51_YGB_GL (
    jgmc,
    jgjc,
    jgh,
    fzhmc,
    fzhjgh,
    bm,
    bmjgh,
    ygh,
    cjrq
  )
values
  (
    null,
    null,
    null,
    null,
    null,
    null,
    'BM003',
    'B002',
    '20231031'
  );

commit;

insert into
  EAST5_JGXXB (
    yhjgdm,
    nbjgh,
    jrxkzh,
    yyzzh,
    yhjgmc,
    jglb,
    xzqhdm,
    yyzt,
    clrq,
    jgdz,
    jglxdh,
    fzrxm,
    fzrzw,
    fzrlxdh,
    cjrq
  )
values
  (
    null,
    'BM001',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    '20231031'
  );

insert into
  EAST5_JGXXB (
    yhjgdm,
    nbjgh,
    jrxkzh,
    yyzzh,
    yhjgmc,
    jglb,
    xzqhdm,
    yyzt,
    clrq,
    jgdz,
    jglxdh,
    fzrxm,
    fzrzw,
    fzrlxdh,
    cjrq
  )
values
  (
    null,
    'BM002',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    '20231031'
  );

insert into
  EAST5_JGXXB (
    yhjgdm,
    nbjgh,
    jrxkzh,
    yyzzh,
    yhjgmc,
    jglb,
    xzqhdm,
    yyzt,
    clrq,
    jgdz,
    jglxdh,
    fzrxm,
    fzrzw,
    fzrlxdh,
    cjrq
  )
values
  (
    null,
    'BM003',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    '20231031'
  );

commit;

insert into
  GZYH_CBJG_ZH (oldnbjgh, newnbjgh)
values
  ('0101', 'BM001');

insert into
  GZYH_CBJG_ZH (oldnbjgh, newnbjgh)
values
  ('0102', 'BM002');

commit;

alter table
  EAST51_YGB enable all triggers;

alter table
  EAST51_YGB_GL enable all triggers;

alter table
  EAST5_JGXXB enable all triggers;

alter table
  EAST5_YGB enable all triggers;

alter table
  GZYH_CBJG_ZH enable all triggers;