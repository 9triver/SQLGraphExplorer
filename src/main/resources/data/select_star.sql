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

create table SRC_TABLE1 (
    gh VARCHAR2(255),
    jrxkzh VARCHAR2(255),
    nbjgh VARCHAR2(255),
    yhjgmc VARCHAR2(255),
    xm VARCHAR2(255),
    gj VARCHAR2(255),
    zjlb VARCHAR2(255),
    zjhm VARCHAR2(255),
    lxdh VARCHAR2(255),
    ssbm VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
    initial 64K next 1M minextents 1 maxextents unlimited
);

create table SRC_TABLE2 (
    gh VARCHAR2(255),
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
    EAST5_YGB (
        JRXKZH,
        NBJGH,
        YHJGMC,
        GH,
        XM,
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
select
    *
from
    SRC_TABLE1 s1
    LEFT JOIN SRC_TABLE2 s2 ON s1.gh = s2.gh;