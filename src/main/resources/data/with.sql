create table orders (
    customer_id VARCHAR2(255),
    order_amount VARCHAR2(255),
    order_id VARCHAR2(255),
    price VARCHAR2(255)
);

WITH customer_orders (customer_id, total_amount) AS (
    SELECT
        customer_id,
        SUM(order_amount) AS total_amount
    FROM
        orders
    GROUP BY
        customer_id
),
order_info (order_id, price) AS (
    SELECT
        order_id,
        price
    FROM
        orders
)
SELECT
    customer_id,
    total_amount,
    order_id,
    price
FROM
    customer_orders,
    order_info
WHERE
    customer_orders.total_amount > 1000;