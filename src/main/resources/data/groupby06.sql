create table products (
  prod_id VARCHAR2(255),
  prod_category VARCHAR2(255),
  prod_subcategory VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

create table sales (
  prod_id VARCHAR2(255),
  cust_id VARCHAR2(255),
  time_id VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

create table customers (
  cust_id VARCHAR2(255),
  cust_year_of_birth VARCHAR2(255),
  country_id VARCHAR2(255),
  cust_city VARCHAR2(255)
) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (
  initial 64K next 1M minextents 1 maxextents unlimited
);

select
  prod_category,
  prod_subcategory,
  country_id,
  cust_city,
  count(*)
from
  products,
  sales,
  customers
where
  sales.prod_id = products.prod_id
  and sales.cust_id = customers.cust_id
  and sales.time_id = '01-oct-00'
  and customers.cust_year_of_birth between 1960
  and 1970
group by
  grouping sets (
    (
      prod_category,
      prod_subcategory,
      country_id,
      cust_city
    ),
    (prod_category, prod_subcategory, country_id),
    (prod_category, prod_subcategory),
    country_id
  )
order by
  prod_category,
  prod_subcategory,
  country_id,
  cust_city