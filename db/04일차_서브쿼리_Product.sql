
# ANY(SOME), IN, ALL은 서브쿼리와 함께 사용 
# 속성 비교 ANY(값1, 값2, ...), 속성 비교 SOME(값1, 값2, ...)
# 속성 비교 ANY(서브쿼리)
# 값들 중 하나 이상의 값들을 만족할 때 사용 

# 속성 IN(값1, 값2, ...)
# 속성 IN(서브쿼리)
# IN은 = ANY와 같음 
# 속성값이 값1, 값2,... 중에 있으면 참 

# 속성 비교 ALL(값1, 값2, ...) 
# 속성 비교 ALL(서브쿼리)
# 속성값이 모든 값들을 만족할 때 사용 

# 가장 비싼 것보다 비싸다 : ALL
# 가장 싼 것 보다 비싸다 : ANY


use product;
# 가전 제품들의 가격들보다 비싼 제품들을 조회
SELECT 
    *
FROM
    product
WHERE
    pr_price > ANY (SELECT 
            pr_price
        FROM
            product
        WHERE
            pr_ca_code = 'ab');
            
# 의류의 가장 싼 제품보다 비싼 제품을 조회하는 쿼리
SELECT 
    *
FROM
    product
WHERE
    pr_price > ANY (SELECT 
            pr_price
        FROM
            product
        WHERE
            pr_ca_code = 'cd')
        AND pr_ca_code != 'cd';
        
SELECT 
    *
FROM
    (select * from product where pr_ca_code != 'cd') product2
WHERE
    pr_price > ANY (SELECT 
            pr_price
        FROM
            product
        WHERE
            pr_ca_code = 'cd');
        
        
# 가전 제품과 가격이 일치하는 제품을 검색.  가전 제품은 제외
SELECT 
    *
FROM
    (select * from product where pr_ca_code != 'ab') product2
WHERE
    pr_price = ANY (SELECT 
            pr_price
        FROM
            product
        WHERE
            pr_ca_code = 'ab');
        
        