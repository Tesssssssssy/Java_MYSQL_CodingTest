-- 코드를 입력하세요
SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
FROM ANIMAL_INS AS INS
LEFT JOIN ANIMAL_OUTS AS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE (INS.SEX_UPON_INTAKE LIKE 'Intact%') 
        AND (OUTS.SEX_UPON_OUTCOME LIKE 'Spayed%' or OUTS.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY INS.ANIMAL_ID;